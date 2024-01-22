package controllers;


import fr.liglab.adele.icasa.device.button.PushButton;
import fr.liglab.adele.icasa.device.doorWindow.DoorWindowSensor;
import fr.liglab.adele.icasa.device.temperature.Cooler;
import fr.liglab.adele.icasa.device.temperature.Heater;
import fr.liglab.adele.icasa.device.temperature.Thermometer;
import listeners.PulsanteTemperaturaListener;
import listeners.SensorePresenzaListener;
import dominio.Termostato;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.GestoreAree;
import dominio.Area;

public class SistemaTemperaturaImpl {
	
	private List<Area> aree;
	private PulsanteTemperaturaListener listenerPulsante = new PulsanteTemperaturaListener();
	
	public SistemaTemperaturaImpl(List<Area> aree) {
		this.aree = aree;
	}
	
	public void assegnaListener(PushButton pulsante) {
		if(pulsante != null) {
			pulsante.addListener(listenerPulsante);
		}
	}

	public void rimuoviListener(PushButton pulsante) {
		if(pulsante != null) {
			pulsante.removeListener(listenerPulsante);
		}
	}

	/** Component Lifecycle Method */
	public void stop() {		
		for(Area area : aree) {
			area.getTermostato().setTempAccesa(false);
			rimuoviListener(area.getPulsanteTemperatura());
		}	
		
		System.out.println("Il sistema gestione-temperatura e' terminato");
	}

	/** Component Lifecycle Method */
	public void start() {
		for(Area area : aree) {
			area.getTermostato().start();
			assegnaListener(area.getPulsanteTemperatura());
		}
		
		System.out.println("Il sistema gestione-temperatura e' partito");
	}

}
