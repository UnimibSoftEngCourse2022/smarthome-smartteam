package controllers;

import fr.liglab.adele.icasa.device.gasSensor.CarbonDioxydeSensor;
import fr.liglab.adele.icasa.device.sprinkler.Sprinkler;
import interfacciaUtente.RilevatoreCO2Listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import database.GestoreAree;
import dominio.Area;
import fr.liglab.adele.icasa.device.security.Siren;

public class SistemaAntincendioImpl {

	/** Field for rilevatoriCO2 dependency */
	private CarbonDioxydeSensor[] rilevatoriCO2;
	/** Field for sprinklers dependency */
	private Sprinkler[] sprinklers;
	/** Field for sirene dependency */
	private Siren[] sirene;

	/** Bind Method for rilevatoriCO2 dependency */
	public void assegnaRilevatoreCO2(CarbonDioxydeSensor sensoreCO2, Map properties) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		String nomeArea = (String) sensoreCO2.getPropertyValue("Location");
		gestoreAree.stampaAree();
		System.out.println("Sto cercando " + nomeArea);
		List<Sprinkler> sprinklersInArea = new ArrayList<Sprinkler>();

		// cerca gli sprinkler appartenenti ad un'area del simulatore
		Area area = gestoreAree.getArea(nomeArea);
		for (Sprinkler sprinkler : sprinklers) {
			if (nomeArea.equals(sprinkler.getPropertyValue("Location"))) {
				sprinklersInArea.add(sprinkler);
			}
		}
		area.setSprinklers(sprinklersInArea);
		
		List<Siren> sireneInArea = new ArrayList<Siren>();
		for (Siren sirena : sirene) {
			if (nomeArea.equals(sirena.getPropertyValue("Location"))) {
				sireneInArea.add(sirena);
			}
		}
		area.setSirene(sireneInArea);

		RilevatoreCO2Listener listenerRilevatori = new RilevatoreCO2Listener();
		sensoreCO2.addListener(listenerRilevatori);
	}

	/** Unbind Method for rilevatoriCO2 dependency */
	public void ritiraRilevatoreCO2(CarbonDioxydeSensor carbonDioxydeSensor, Map properties) {
		// TODO: Add your implementation code here
	}

	/** Bind Method for sprinklers dependency */
	public void assegnaSprinkler(Sprinkler sprinkler, Map properties) {
		// TODO: Add your implementation code here
	}

	/** Unbind Method for sprinklers dependency */
	public void ritiraSprinkler(Sprinkler sprinkler, Map properties) {
		// TODO: Add your implementation code here
	}

	
	/** Bind Method for sirene dependency */
	public void assegnaSirena(Siren siren, Map properties) {
		// TODO: Add your implementation code here
	}

	
	/** Unbind Method for sirene dependency */
	public void ritiraSirena(Siren siren, Map properties) {
		// TODO: Add your implementation code here
	}

	
	/** Component Lifecycle Method */
	public void stop() {
		System.out.println("Fine sistema ANTINCENDIO");
	}

	/** Component Lifecycle Method */
	public void start() {
		System.out.println("Inizio sistema ANTINCENDIO");
	}

	
}
