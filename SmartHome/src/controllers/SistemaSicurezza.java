package controllers;

import java.util.List;

import dominio.Area;
import fr.liglab.adele.icasa.device.doorWindow.DoorWindowSensor;
import listeners.SensorePortaFinestraListener;

public class SistemaSicurezza {
	
	private List<Area> aree;
	private SensorePortaFinestraListener listenerSensore = new SensorePortaFinestraListener();
	
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
			assegnaListener(area.getSensorePorteFinestre());
		}
	}
	
	public void stop() {
		System.out.println("Fine Sistema Sicurezza");
		for(Area area : aree) {
			rimuoviListener(area.getSensorePorteFinestre());
		}
	}
}