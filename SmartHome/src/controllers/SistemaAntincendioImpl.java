package controllers;

import fr.liglab.adele.icasa.device.gasSensor.CarbonDioxydeSensor;
import interfacciaUtente.RilevatoreCO2Listener;

import java.util.List;

import database.GestoreAree;
import dominio.Area;

public class SistemaAntincendioImpl {

	RilevatoreCO2Listener listenerRilevatori = new RilevatoreCO2Listener();
	
	// metodo per assegnare un listener ad un rilevatore di CO2
	public void assegnaListener(CarbonDioxydeSensor sensoreCO2){
		if(sensoreCO2 != null) {
			sensoreCO2.addListener(listenerRilevatori);
		}
	}


	// metodo per rimuovere un listener da un rilevatore di CO2
	public void rimuoviListener(CarbonDioxydeSensor sensoreCO2){
		if(sensoreCO2 != null) {
			sensoreCO2.removeListener(listenerRilevatori);
		}
	}
	
	/** Component Lifecycle Method */
	public void stop() {
		System.out.println("Fine sistema ANTINCENDIO");
		
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		List<Area> aree = gestoreAree.getAree();
		for(Area area : aree) {
			rimuoviListener(area.getRilevatoreCO2());
		}
	}

	/** Component Lifecycle Method */
	public void start() {
		System.out.println("Inizio sistema ANTINCENDIO");
		
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		List<Area> aree = gestoreAree.getAree();
		for(Area area : aree) {
			assegnaListener(area.getRilevatoreCO2());
		}
	}

	
}
