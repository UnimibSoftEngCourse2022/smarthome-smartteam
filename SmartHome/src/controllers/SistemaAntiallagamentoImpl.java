package controllers;

import java.util.List;

import database.GestoreAree;
import dominio.Area;
import fr.liglab.adele.icasa.device.security.FloodSensor;
import interfacciaUtente.SensoreAllagamentoListener;

public class SistemaAntiallagamentoImpl {

	SensoreAllagamentoListener listenerSensore = new SensoreAllagamentoListener();
	
	// metodo per assegnare un listener ad un rilevatore di CO2
	private void assegnaListener(FloodSensor sensoreAllagamento){
		if(sensoreAllagamento != null) {
			sensoreAllagamento.addListener(listenerSensore);
		}
	}


	// metodo per rimuovere un listener da un rilevatore di CO2
	private void rimuoviListener(FloodSensor sensoreAllagamento){
		if(sensoreAllagamento != null) {
			sensoreAllagamento.removeListener(listenerSensore);
		}
	}
	
	
	/** Component Lifecycle Method */
	public void stop() {
		System.out.println("Fine sistema ANTIALLAGAMENTO");
		
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		List<Area> aree = gestoreAree.getAree();
		for(Area area : aree) {
			rimuoviListener(area.getSensoreAllagamento());
		}
	}
	

	/** Component Lifecycle Method */
	public void start() {
		System.out.println("Inizio sistema ANTIALLAGAMENTO");
		
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		List<Area> aree = gestoreAree.getAree();
		for(Area area : aree) {
			assegnaListener(area.getSensoreAllagamento());
		}
	}

}
