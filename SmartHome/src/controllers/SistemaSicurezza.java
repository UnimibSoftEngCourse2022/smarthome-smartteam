package controllers;

import java.util.List;

import dominio.Area;
import fr.liglab.adele.icasa.device.button.PushButton;
import fr.liglab.adele.icasa.device.doorWindow.DoorWindowSensor;
import listeners.SensorePortaFinestraListener;
import listeners.PulsanteAllarmeListener;

public class SistemaSicurezza extends Sistema{
	
	private SensorePortaFinestraListener listenerSensore = new SensorePortaFinestraListener();
	private PulsanteAllarmeListener listenerPulsante = new PulsanteAllarmeListener();
	
	public SistemaSicurezza(List<Area> aree){
		super(aree);
	}
	
	public void assegnaListener(DoorWindowSensor sensorePortaFinestra) {
		if(sensorePortaFinestra != null) {
			sensorePortaFinestra.addListener(listenerSensore);
		}
	}

	public void rimuoviListener(DoorWindowSensor sensorePortaFinestra) {
		if(sensorePortaFinestra != null) {
			sensorePortaFinestra.removeListener(listenerSensore);
		}
	}
	
	public void start() {
		for(Area area : aree) {
			PushButton pulsanteAllarme = area.getPulsanteAllarme();
			if(pulsanteAllarme != null)
				pulsanteAllarme.addListener(listenerPulsante);
			assegnaListener(area.getSensorePorteFinestre());
		}
		
		System.out.println("Il sistema di allarme e' partito");
	}
	
	public void stop() {
		for(Area area : aree) {
			PushButton pulsanteAllarme = area.getPulsanteAllarme();
			if(pulsanteAllarme != null)
				pulsanteAllarme.removeListener(listenerPulsante);
			rimuoviListener(area.getSensorePorteFinestre());
		}
		
		System.out.println("Il sistema di allarme e' terminato");
	}
}