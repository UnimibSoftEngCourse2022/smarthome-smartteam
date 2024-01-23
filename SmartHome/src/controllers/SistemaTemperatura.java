package controllers;


import fr.liglab.adele.icasa.device.button.PushButton;
import listeners.PulsanteTemperaturaListener;
import java.util.List;
import dominio.Area;

public class SistemaTemperatura extends Sistema{
	
	private PulsanteTemperaturaListener listenerPulsante = new PulsanteTemperaturaListener();
	
	public SistemaTemperatura(List<Area> aree) {
		super(aree);
	}
	
	public void assegnaListener(PushButton pulsante) {
		if(pulsante != null) {
			pulsante.addListener(listenerPulsante);
		}
	}

	public void rimuoviListener(PushButton pulsante) {
		if(pulsante != null) {
			pulsante.removeListener(listenerPulsante);
		}
	}

	/** Component Lifecycle Method */
	public void stop() {		
		for(Area area : aree) {
			area.getTermostato().setTempAccesa(false);
			rimuoviListener(area.getPulsanteTemperatura());
		}	
		
		System.out.println("Il sistema gestione-temperatura e' terminato");
	}

	/** Component Lifecycle Method */
	public void start() {
		for(Area area : aree) {
			area.getTermostato().start();
			assegnaListener(area.getPulsanteTemperatura());
		}
		
		System.out.println("Il sistema gestione-temperatura e' partito");
	}

}
