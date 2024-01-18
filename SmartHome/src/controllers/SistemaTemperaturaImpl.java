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
	
	/** Unbind Method for termometri dependency */
	public void ritiraTermometro(Thermometer thermometer, Map properties) {
		// Metodo ereditato dall' interfaccia
	}

	/** Bind Method for condizionatori dependency */
	public void assegnaCondizionatore(Cooler cooler, Map properties) {
		// Metodo ereditato dall' interfaccia
	}

	/** Unbind Method for condizionatori dependency */
	public void ritiraCondizionatore(Cooler cooler, Map properties) {
		// Metodo ereditato dall' interfaccia
	}

	/** Bind Method for caloriferi dependency */
	public void assegnaCalorifero(Heater heater, Map properties) {
		// Metodo ereditato dall' interfaccia
	}

	/** Unbind Method for caloriferi dependency */
	public void ritiraCalorifero(Heater heater, Map properties) {
		// Metodo ereditato dall' interfaccia
	}

	/** Component Lifecycle Method */
	public void stop() {
		System.out.println("Fine sis. Temp.");
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		List<Area> aree = gestoreAree.getAree();
		for(Area area : aree) {
			area.getTermostato().interrupt();
		}	
	}

	/** Component Lifecycle Method */
	public void start() {
		System.out.println("Inizio sis. Temp.");
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		List<Area> aree = gestoreAree.getAree();
		for(Area area : aree) {
			area.getTermostato().start();
		}
	}

}
