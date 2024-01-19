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
	
	List<Area> aree;
	
	public SistemaTemperaturaImpl(List<Area> aree) {
		this.aree = aree;
	}

	/** Component Lifecycle Method */
	public void stop() {
		System.out.println("Fine sis. Temp.");
		
		for(Area area : aree) {
			area.getTermostato().interrupt();
		}	
	}

	/** Component Lifecycle Method */
	public void start() {
		System.out.println("Inizio sis. Temp.");
		
		for(Area area : aree) {
			area.getTermostato().start();
		}
	}

}
