package controllers;


import fr.liglab.adele.icasa.device.temperature.Cooler;
import fr.liglab.adele.icasa.device.temperature.Heater;
import fr.liglab.adele.icasa.device.temperature.Thermometer;
import interfacciaUtente.SensorePresenzaListener;
import dominio.Termostato;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.GestoreAree;
import dominio.Area;

public class SistemaTemperaturaImpl {

	
	
	private List<Termostato> termostatiList = new ArrayList<Termostato>();
	
	/** Unbind Method for termometri dependency */
	public void ritiraTermometro(Thermometer thermometer, Map properties) {
		// TODO: Add your implementation code here
	}

	/** Bind Method for condizionatori dependency */
	public void assegnaCondizionatore(Cooler cooler, Map properties) {
		// TODO: Add your implementation code here
	}

	/** Unbind Method for condizionatori dependency */
	public void ritiraCondizionatore(Cooler cooler, Map properties) {
		// TODO: Add your implementation code here
	}

	/** Bind Method for caloriferi dependency */
	public void assegnaCalorifero(Heater heater, Map properties) {
		// TODO: Add your implementation code here
	}

	/** Unbind Method for caloriferi dependency */
	public void ritiraCalorifero(Heater heater, Map properties) {
		// TODO: Add your implementation code here
	}

	/** Component Lifecycle Method */
	public void stop() {
		// TODO: Add your implementation code here
		System.out.println("Fine sis. Temp.");
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		List<Area> aree = gestoreAree.getAree();
		for(Area area : aree) {
			area.getTermostato().interrupt();
		}	
	}

	/** Component Lifecycle Method */
	public void start() {
		// TODO: Add your implementation code here
		System.out.println("Inizio sis. Temp.");
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		List<Area> aree = gestoreAree.getAree();
		for(Area area : aree) {
			area.getTermostato().start();
		}
	}

}
