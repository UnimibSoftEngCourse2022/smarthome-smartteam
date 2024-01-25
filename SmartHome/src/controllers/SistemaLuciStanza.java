package controllers;

import fr.liglab.adele.icasa.device.button.PushButton;
import fr.liglab.adele.icasa.device.presence.PresenceSensor;
import listeners.PulsanteLuciListener;
import listeners.SensorePresenzaListener;

import java.util.List;

import dominio.Area;

public class SistemaLuciStanza extends Sistema{

	SensorePresenzaListener listenerSensore = new SensorePresenzaListener();
	
	PulsanteLuciListener listenerPulsante = new PulsanteLuciListener();
	
	public SistemaLuciStanza(List<Area> aree) {
		super(aree);
	}
	

	/** metodo per assegnare un listener ad un sensore di presenza per regolare il comportamento
	 * 	a seconda della rilevazione di un fotometro e ad un pulsante
	*/
	private void assegnaListener(PresenceSensor sensorePresenza, PushButton pulsanteLuci){
		sensorePresenza.addListener(listenerSensore);
		pulsanteLuci.addListener(listenerPulsante);
	}


	// metodo per rimuovere un listener da un sensore di presenza non piu' usato e da un pulsante
	private void rimuoviListener(PresenceSensor sensorePresenza, PushButton pulsanteLuci){
		sensorePresenza.removeListener(listenerSensore);
		pulsanteLuci.removeListener(listenerPulsante);
	}

	
	/** Metodo di fine ciclo di vita del componente */
	public void stop() {
		for(Area area : aree) {
			rimuoviListener(area.getSensorePresenza(), area.getPulsanteLuci());
		}
		
		System.out.println("Il sistema gestione-luci e' terminato");
	}


	/** Metodo di inizio ciclo di vita del componente */
	public void start() {
		for(Area area : aree) {
			assegnaListener(area.getSensorePresenza(), area.getPulsanteLuci());
		}
		
		System.out.println("Il sistema gestione-luci e' partito");
	}
	
}