package controllers;

import java.util.List;

import dominio.Area;
import fr.liglab.adele.icasa.device.button.PushButton;
import fr.liglab.adele.icasa.device.doorWindow.DoorWindowSensor;
import listeners.SensorePortaFinestraListener;
import listeners.PulsanteAllarmeListener;

public class SistemaSicurezza {
	
	private List<Area> aree;
	private SensorePortaFinestraListener listenerSensore = new SensorePortaFinestraListener();
	private PulsanteAllarmeListener listenerPulsante = new PulsanteAllarmeListener();
	
	public SistemaSicurezza(List<Area> aree){
		this.aree = aree;
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
		System.out.println("Inizio Sistema Sicurezza");
		for(Area area : aree) {
			PushButton pulsanteAllarme = area.getPulsanteAllarme();
			if(pulsanteAllarme != null)
				pulsanteAllarme.addListener(listenerPulsante);
			assegnaListener(area.getSensorePorteFinestre());
		}
	}
	
	public void stop() {
		System.out.println("Fine Sistema Sicurezza");
		for(Area area : aree) {
			PushButton pulsanteAllarme = area.getPulsanteAllarme();
			if(pulsanteAllarme != null)
				pulsanteAllarme.removeListener(listenerPulsante);
			rimuoviListener(area.getSensorePorteFinestre());
		}
	}
}