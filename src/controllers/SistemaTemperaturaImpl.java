package controllers;


import fr.liglab.adele.icasa.device.temperature.Cooler;
import fr.liglab.adele.icasa.device.temperature.Heater;
import fr.liglab.adele.icasa.device.temperature.Thermometer;
import interfacciaUtente.SensorePresenzaListener;
import dominio.Termometro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.GestoreAree;
import dominio.Area;

public class SistemaTemperaturaImpl {

	/** Field for condizionatori dependency */
	private Cooler[] condizionatori;
	/** Field for caloriferi dependency */
	private Heater[] caloriferi;
	/** Field for termometri dependency */
	private Thermometer[] termometri;
	
	private List<Termometro> termometriList = new ArrayList<Termometro>();

	/** Bind Method for termometri dependency */
	public void assegnaTermometro(Thermometer termometro, Map properties) {
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		Termometro lastT = null;
		for(int i = 0; i < termometri.length; i++) {
			if(lastT == null || lastT.getTermometro() != termometro) {
				gestoreAree.getArea((String) termometro.getPropertyValue("Location")).setCondizionatore(cercaCondizionatore(condizionatori, termometro));
				gestoreAree.getArea((String) termometro.getPropertyValue("Location")).setCalorifero(cercaCalorifero(caloriferi, termometro));
				Termometro t = new Termometro(termometro);
				termometriList.add(t);
				lastT = t;
			}
		}
	
	}
	
	

	public Cooler cercaCondizionatore(Cooler[] condizionatori, Thermometer termometro) {
		for(Cooler condizionatore : condizionatori) {
			if(condizionatore.getPropertyValue("Location").equals(termometro.getPropertyValue("Location"))) {
				return condizionatore;
			}
		}
		return null;
	}
	
	public Heater cercaCalorifero(Heater[] caloriferi, Thermometer termometro) {
		for(Heater calorifero : caloriferi) {
			if(calorifero.getPropertyValue("Location").equals(termometro.getPropertyValue("Location"))) {
				return calorifero;
			}
		}
		return null;
	}
	
	
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
		for(Termometro t: termometriList)
			t.interrupt();		
	}

	/** Component Lifecycle Method */
	public void start() {
		// TODO: Add your implementation code here
		System.out.println("Inizio sis. Temp.");
		for(Termometro t : termometriList) {
			t.start();
		}
	}

}
