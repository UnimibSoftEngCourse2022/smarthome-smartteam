package controllers;

import java.util.List;

import dominio.Area;
import fr.liglab.adele.icasa.device.security.FloodSensor;
import listeners.SensoreAllagamentoListener;

public class SistemaAntiallagamento extends Sistema{

	SensoreAllagamentoListener listenerSensore = new SensoreAllagamentoListener();
	
	public SistemaAntiallagamento(List<Area> aree) {
		super(aree);
	}
	
	
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
		for(Area area : aree) {
			rimuoviListener(area.getSensoreAllagamento());
		}
		
		System.out.println("Il sistema antiallagamento e' terminato");
	}
	

	/** Component Lifecycle Method */
	public void start() {
		for(Area area : aree) {
			assegnaListener(area.getSensoreAllagamento());
		}
		
		System.out.println("Il sistema antiallagamento e' partito");
	}

}
