package controllers;

import fr.liglab.adele.icasa.device.gasSensor.CarbonDioxydeSensor;
import listeners.RilevatoreCO2Listener;

import java.util.List;

import dominio.Area;

public class SistemaAntincendio extends Sistema{

	RilevatoreCO2Listener listenerRilevatori = new RilevatoreCO2Listener();
	
	public SistemaAntincendio(List<Area> aree) {
		super(aree);
	}
	
	
	// metodo per assegnare un listener ad un rilevatore di CO2
	private void assegnaListener(CarbonDioxydeSensor sensoreCO2){
		if(sensoreCO2 != null) {
			sensoreCO2.addListener(listenerRilevatori);
		}
	}


	// metodo per rimuovere un listener da un rilevatore di CO2
	private void rimuoviListener(CarbonDioxydeSensor sensoreCO2){
		if(sensoreCO2 != null) {
			sensoreCO2.removeListener(listenerRilevatori);
		}
	}
	
	/** Component Lifecycle Method */
	public void stop() {		
		for(Area area : aree) {
			rimuoviListener(area.getRilevatoreCO2());
		}
		
		System.out.println("Il sistema antincendio e' terminato");
	}

	/** Component Lifecycle Method */
	public void start() {
		for(Area area : aree) {
			assegnaListener(area.getRilevatoreCO2());
		}
		
		System.out.println("Il sistema antincendio e' partito");
	}

	
}
