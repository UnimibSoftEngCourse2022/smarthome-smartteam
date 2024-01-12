package controllers;

import fr.liglab.adele.icasa.device.gasSensor.CarbonDioxydeSensor;
import fr.liglab.adele.icasa.device.presence.PresenceSensor;
import fr.liglab.adele.icasa.device.sprinkler.Sprinkler;
import fr.liglab.adele.icasa.device.security.Siren;
import fr.liglab.adele.icasa.device.light.Photometer;
import fr.liglab.adele.icasa.device.light.BinaryLight;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import database.GestoreAree;
import dominio.Area;
import dominio.AreaBuilder;

public class InizializzaSistemaImpl {

	boolean sistemaInizializzato = false;
	
	// Componenti sottosistemi
	private SistemaLuciStanzaImpl sistemaLuci;
	private SistemaAntincendioImpl sistemaAntincendio;
	
	/** Field for rilevatoriCO2 dependency */
	private CarbonDioxydeSensor[] rilevatoriCO2;
	/** Field for sensoriPresenza dependency */
	private PresenceSensor[] sensoriPresenza;
	/** Field for sprinklers dependency */
	private Sprinkler[] sprinklers;
	/** Field for sirene dependency */
	private Siren[] sirene;
	/** Field for fotometri dependency */
	private Photometer[] fotometri;
	/** Field for luci dependency */
	private BinaryLight[] luci;


	/** Bind Method for rilevatoriCO2 dependency */
	public void assegnaRilevatoreCO2(CarbonDioxydeSensor carbonDioxydeSensor, Map properties) {
		// TODO: Add your implementation code here
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

	/** Bind Method for fotometri dependency */
	public void assegnaFotometro(Photometer photometer, Map properties) {
		// TODO: Add your implementation code here
	}

	/** Unbind Method for fotometri dependency */
	public void ritiraFotometro(Photometer photometer, Map properties) {
		// TODO: Add your implementation code here
	}

	/** Bind Method for sensoriPresenza dependency */
	public void assegnaSensorePresenza(PresenceSensor sensorePresenza, Map proprieta) {
		/**
		System.out.println(sensorePresenza.getPropertyValue("Location"));
		if(sistemaInizializzato == true && !sensorePresenza.getPropertyValue("Location").equals("unknown")) {
			System.out.println("assegnamento partito!");
			sistemaLuci.assegnaSensorePresenza(sensorePresenza);
		}*/
	}

	
	/** Unbind Method for sensoriPresenza dependency */
	public void ritiraSensorePresenza(PresenceSensor sensorePresenza, Map proprieta) {
		//sistemaLuci.ritiraSensorePresenza(sensorePresenza);
	}
	
	
	// ricerca di tutti i dispositivi presenti in una determinata area (stanza o corridoio)
	
	// luci
	public ArrayList<BinaryLight> cercaLuciArea(BinaryLight luci[], String posizione){
		ArrayList<BinaryLight> luciArea = new ArrayList<BinaryLight>();
		for (BinaryLight luce : luci) {
			if (luce.getPropertyValue("Location").equals(posizione)) {
				luciArea.add(luce);
			}
		}
		return luciArea;
	}


	// fotometro
	public Photometer cercaFotometroArea(Photometer[] fotometri, String posizione){
		Photometer fotometroArea = null;
		for (Photometer fotometro : fotometri) {
			if (fotometro.getPropertyValue("Location").equals(posizione)) {
				fotometroArea = fotometro;
			}
		}
		return fotometroArea;
	}

	
	// rilevatore CO2
		public CarbonDioxydeSensor cercaRilevatoreArea(CarbonDioxydeSensor[] rilevatoriCO2, String posizione){
			CarbonDioxydeSensor rilevatoreCO2Area = null;
			for (CarbonDioxydeSensor rilevatore : rilevatoriCO2) {
				if (rilevatore.getPropertyValue("Location").equals(posizione)) {
					rilevatoreCO2Area = rilevatore;
				}
			}
			return rilevatoreCO2Area;
		}
		

	// sprinklers
	public ArrayList<Sprinkler> cercaSprinklersArea(Sprinkler[] sprinklers, String posizione){
		ArrayList<Sprinkler> sprinklersArea = new ArrayList<Sprinkler>();
		for (Sprinkler sprinkler : sprinklers) {
			if (sprinkler.getPropertyValue("Location").equals(posizione)) {
				sprinklersArea.add(sprinkler);
			}
		}
		return sprinklersArea;
	}
	
	
	// sirene
	public ArrayList<Siren> cercaSireneArea(Siren[] sirene, String posizione){
		ArrayList<Siren> sireneArea = new ArrayList<Siren>();
		for (Siren sirena : sirene) {
			if (sirena.getPropertyValue("Location").equals(posizione)) {
				sireneArea.add(sirena);
			}
		}
		return sireneArea;
	}
	

	/** Bind Method for luci dependency */
	public void assegnaLuce(BinaryLight binaryLight, Map properties) {
		// TODO: Add your implementation code here
	}

	/** Unbind Method for luci dependency */
	public void ritiraLuce(BinaryLight binaryLight, Map properties) {
		// TODO: Add your implementation code here
	}

	/** Component Lifecycle Method */
	public void stop() {
		// TODO: Add your implementation code here
	}

	/** Component Lifecycle Method */
	public void start() {
		
		System.out.println("Inizializzazione Stanze partita!");
		// INIZIALIZZAZIONE STANZE
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		
		// assumiamo che in ogni area (stanza o corridoio) ci sia un sensore di presenza
		// prendiamo quindi la Location di ciascun sensore per individuare tutti i dispositivi in un'area
		for(PresenceSensor sensorePresenza : sensoriPresenza) {
			String posizioneSensore = (String) sensorePresenza.getPropertyValue("Location");
			// ELEMENTI GESTIONE LUCI
			ArrayList<BinaryLight> luciInArea = cercaLuciArea(luci, posizioneSensore);
			Photometer fotometroInArea = cercaFotometroArea(fotometri, posizioneSensore);
			// ELEMENTI SISTEMA ANTINCENDIO
			CarbonDioxydeSensor rilevatoreInArea = cercaRilevatoreArea(rilevatoriCO2, posizioneSensore);
			List<Sprinkler> sprinklersInArea = cercaSprinklersArea(sprinklers, posizioneSensore);
			List<Siren> sireneInArea = cercaSireneArea(sirene, posizioneSensore);
			// INIZIALIZZAZIONE AREA
			AreaBuilder builder = new AreaBuilder();
			builder.nome(posizioneSensore).sensorePresenza(sensorePresenza).fotometro(fotometroInArea).luci(luciInArea).rilevatoreCO2(rilevatoreInArea).sprinklers(sprinklersInArea).sirene(sireneInArea);
			Area nuovaArea = new Area(builder);
			gestoreAree.aggiungiArea(nuovaArea);
			System.out.println(nuovaArea.getNome() + "creata");
			gestoreAree.stampaAree();
		}
		
		// da questo punto possiamo istanziare SistemaLuciStanzaImpl e SistemaAntincendioImpl
		sistemaLuci = new SistemaLuciStanzaImpl();
		sistemaLuci.start();
		sistemaAntincendio = new SistemaAntincendioImpl();
		sistemaAntincendio.start();
		sistemaInizializzato = true;
	}

}
