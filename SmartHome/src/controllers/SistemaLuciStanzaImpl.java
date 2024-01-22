package controllers;

import fr.liglab.adele.icasa.device.button.PushButton;
import fr.liglab.adele.icasa.device.presence.PresenceSensor;
import listeners.PulsanteLuciListener;
import listeners.SensorePresenzaListener;

import java.util.List;

import database.GestoreAree;
import dominio.Area;

public class SistemaLuciStanzaImpl {

	SensorePresenzaListener listenerSensore = new SensorePresenzaListener();
	List<Area> aree;
	
	PulsanteLuciListener listenerPulsante = new PulsanteLuciListener();
	
	public SistemaLuciStanzaImpl(List<Area> aree) {
		this.aree = aree;
	}
	
	/** metodo per assegnare le dipendenze ai sensori di presenza. 
	* Collega le aree create nel simulatore a quelle del sistema.
	* Assegnando ad ogni area le rispettive luci e sensori
	public void assegnaSensorePresenza(PresenceSensor sensorePresenza) {

		GestoreAree gestoreAree = GestoreAree.getIstanza();
		String nomeArea = (String) sensorePresenza.getPropertyValue("Location");
		Area area = gestoreAree.getArea(nomeArea);
		// avendo assunto che ogni stanza debba avere un sensore di presenza
		// se un'area non ha pi� un sensore di presenza, viene riaggiunto
		if(area.getSensorePresenza() == null) {
			area.setSensorePresenza(sensorePresenza);
			assegnaListener(sensorePresenza);
		}
		
	}
	
	
	// metodo per rimuovere le dipendenze dai sensori di presenza
	public void ritiraSensorePresenza(PresenceSensor sensorePresenza) {
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		String nomeArea = (String) sensorePresenza.getPropertyValue("Location");
		Area area = gestoreAree.getArea(nomeArea);
		if(area.getSensorePresenza() != null) {
			area.setSensorePresenza(null);
			rimuoviListener(sensorePresenza);
		}
	}
	*/	


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