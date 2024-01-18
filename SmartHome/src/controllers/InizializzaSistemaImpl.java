package controllers;

import fr.liglab.adele.icasa.device.gasSensor.CarbonDioxydeSensor;
import fr.liglab.adele.icasa.device.presence.PresenceSensor;
import fr.liglab.adele.icasa.device.sprinkler.Sprinkler;
import fr.liglab.adele.icasa.device.temperature.Cooler;
import fr.liglab.adele.icasa.device.temperature.Heater;
import fr.liglab.adele.icasa.device.temperature.Thermometer;
import fr.liglab.adele.icasa.device.security.FloodSensor;
import fr.liglab.adele.icasa.device.security.Siren;
import fr.liglab.adele.icasa.device.light.Photometer;
import fr.liglab.adele.icasa.device.light.BinaryLight;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import database.GestoreAree;
import dominio.Area;
import dominio.AreaBuilder;
import dominio.Termostato;

public class InizializzaSistemaImpl {

	// Componenti sottosistemi
	private SistemaLuciStanzaImpl sistemaLuci;
	private SistemaAntincendioImpl sistemaAntincendio;
	private SistemaAntiallagamentoImpl sistemaAntiallagamentoImpl;
	private SistemaTemperaturaImpl sistemaTemperatura;

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
	/** Field for sensoriAllagamento dependency */
	private FloodSensor[] sensoriAllagamento;
	/** Field for condizionatori dependency */
	private Cooler[] condizionatori;
	/** Field for caloriferi dependency */
	private Heater[] caloriferi;
	/** Field for termometri dependency */
	private Thermometer[] termometri;

	private final String PROPRIETA = "Location";

	/** Bind Method for rilevatoriCO2 dependency */
	public void assegnaRilevatoreCO2(CarbonDioxydeSensor carbonDioxydeSensor, Map properties) {
		// Metodo ereditato dall' interfaccia
	}

	/** Unbind Method for rilevatoriCO2 dependency */
	public void ritiraRilevatoreCO2(CarbonDioxydeSensor carbonDioxydeSensor, Map properties) {
		// Metodo ereditato dall' interfaccia
	}

	/** Bind Method for sprinklers dependency */
	public void assegnaSprinkler(Sprinkler sprinkler, Map properties) {
		// Metodo ereditato dall' interfaccia
	}

	/** Unbind Method for sprinklers dependency */
	public void ritiraSprinkler(Sprinkler sprinkler, Map properties) {
		// Metodo ereditato dall' interfaccia
	}

	/** Bind Method for sirene dependency */
	public void assegnaSirena(Siren siren, Map properties) {
		// Metodo ereditato dall' interfaccia
	}

	/** Unbind Method for sirene dependency */
	public void ritiraSirena(Siren siren, Map properties) {
		// Metodo ereditato dall' interfaccia
	}

	/** Bind Method for fotometri dependency */
	public void assegnaFotometro(Photometer photometer, Map properties) {
		// Metodo ereditato dall' interfaccia
	}

	/** Unbind Method for fotometri dependency */
	public void ritiraFotometro(Photometer photometer, Map properties) {
		// Metodo ereditato dall' interfaccia
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
	private ArrayList<BinaryLight> cercaLuciArea(BinaryLight luci[], String posizione) {
		ArrayList<BinaryLight> luciArea = new ArrayList<BinaryLight>();
		for (BinaryLight luce : luci) {
			if (luce.getPropertyValue(PROPRIETA).equals(posizione)) {
				luciArea.add(luce);
			}
		}
		return luciArea;
	}

	// fotometro
	private Photometer cercaFotometroArea(Photometer[] fotometri, String posizione) {
		Photometer fotometroArea = null;
		for (Photometer fotometro : fotometri) {
			if (fotometro.getPropertyValue(PROPRIETA).equals(posizione)) {
				fotometroArea = fotometro;
			}
		}
		return fotometroArea;
	}

	// rilevatore CO2
	private CarbonDioxydeSensor cercaRilevatoreArea(CarbonDioxydeSensor[] rilevatoriCO2, String posizione) {
		CarbonDioxydeSensor rilevatoreCO2Area = null;
		for (CarbonDioxydeSensor rilevatore : rilevatoriCO2) {
			if (rilevatore.getPropertyValue(PROPRIETA).equals(posizione)) {
				rilevatoreCO2Area = rilevatore;
			}
		}
		return rilevatoreCO2Area;
	}

	// sprinklers
	private ArrayList<Sprinkler> cercaSprinklersArea(Sprinkler[] sprinklers, String posizione) {
		ArrayList<Sprinkler> sprinklersArea = new ArrayList<Sprinkler>();
		for (Sprinkler sprinkler : sprinklers) {
			if (sprinkler.getPropertyValue(PROPRIETA).equals(posizione)) {
				sprinklersArea.add(sprinkler);
			}
		}
		return sprinklersArea;
	}

	// sirene
	private ArrayList<Siren> cercaSireneArea(Siren[] sirene, String posizione) {
		ArrayList<Siren> sireneArea = new ArrayList<Siren>();
		for (Siren sirena : sirene) {
			if (sirena.getPropertyValue(PROPRIETA).equals(posizione)) {
				sireneArea.add(sirena);
			}
		}
		return sireneArea;
	}

	private FloodSensor cercaSensoreAllagamento(FloodSensor[] sensoriAllagamento, String posizione) {
		FloodSensor sensoreAllagamento = null;
		for (FloodSensor sensore : sensoriAllagamento) {
			if (sensore.getPropertyValue(PROPRIETA).equals(posizione)) {
				sensoreAllagamento = sensore;
			}
		}
		return sensoreAllagamento;
	}

	public ArrayList<Cooler> cercaCondizionatori(Cooler[] condizionatori, String posizione) {
		ArrayList<Cooler> condizionatoriArea = new ArrayList<Cooler>();
		for (Cooler condizionatore : condizionatori) {
			if (condizionatore.getPropertyValue(PROPRIETA).equals(posizione)) {
				condizionatoriArea.add(condizionatore);
			}
		}
		return condizionatoriArea;
	}

	public ArrayList<Heater> cercaCaloriferi(Heater[] caloriferi, String posizione) {
		ArrayList<Heater> caloriferiArea = new ArrayList<Heater>();
		for (Heater calorifero : caloriferi) {
			if (calorifero.getPropertyValue(PROPRIETA).equals(posizione)) {
				caloriferiArea.add(calorifero);
			}
		}
		return caloriferiArea;
	}

	private Thermometer cercaTermometro(Thermometer[] termometri, String posizione) {
		Thermometer termometroArea = null;
		for (Thermometer termometro : termometri) {
			if (termometro.getPropertyValue(PROPRIETA).equals(posizione)) {
				termometroArea = termometro;
			}
		}
		return termometroArea;
	}

	/** Bind Method for luci dependency */
	public void assegnaLuce(BinaryLight binaryLight, Map properties) {
		// Metodo ereditato dall' interfaccia
	}

	/** Unbind Method for luci dependency */
	public void ritiraLuce(BinaryLight binaryLight, Map properties) {
		// Metodo ereditato dall' interfaccia
	}

	/** Bind Method for sensoriAllagamento dependency */
	public void assegnaSensoreAllagamento(FloodSensor sensoreAllagamento, Map properties) {
		// Metodo ereditato dall' interfaccia
	}

	/** Unbind Method for sensoriAllagamento dependency */
	public void ritiraSensoreAllagamento(FloodSensor sensoreAllagamento, Map properties) {
		// Metodo ereditato dall' interfaccia
	}

	/** Component Lifecycle Method */
	public void stop() {
		// Metodo ereditato dall' interfaccia
	}

	/** Component Lifecycle Method */
	public void start() {

		System.out.println("Inizializzazione Stanze partita!");
		// INIZIALIZZAZIONE STANZE
		GestoreAree gestoreAree = GestoreAree.getIstanza();

		// assumiamo che in ogni area (stanza o corridoio) ci sia un sensore di presenza
		// prendiamo quindi la Location di ciascun sensore per individuare tutti i dispositivi in un'area
		for (PresenceSensor sensorePresenza : sensoriPresenza) {
			String posizioneSensore = (String) sensorePresenza.getPropertyValue("Location");
			// ELEMENTI GESTIONE LUCI
			ArrayList<BinaryLight> luciInArea = cercaLuciArea(luci, posizioneSensore);
			Photometer fotometroInArea = cercaFotometroArea(fotometri, posizioneSensore);
			// ELEMENTI SISTEMA ANTINCENDIO E SISTEMA ANTIALLAGAMENTO
			CarbonDioxydeSensor rilevatoreInArea = cercaRilevatoreArea(rilevatoriCO2, posizioneSensore);
			List<Sprinkler> sprinklersInArea = cercaSprinklersArea(sprinklers, posizioneSensore);
			List<Siren> sireneInArea = cercaSireneArea(sirene, posizioneSensore);
			FloodSensor sensoreAllagamentoInArea = cercaSensoreAllagamento(sensoriAllagamento, posizioneSensore);

			// ELEMENTI SISTEMA TEMPERATURA
			ArrayList<Heater> caloriferiInArea = cercaCaloriferi(caloriferi, posizioneSensore);
			ArrayList<Cooler> condizionatoriInArea = cercaCondizionatori(condizionatori, posizioneSensore);
			Thermometer termometroInArea = cercaTermometro(termometri, posizioneSensore);
			Termostato termostatoInArea = new Termostato(termometroInArea);

			// INIZIALIZZAZIONE AREA
			AreaBuilder builder = new AreaBuilder();
			builder.nome(posizioneSensore).sensorePresenza(sensorePresenza).fotometro(fotometroInArea).luci(luciInArea)
					.rilevatoreCO2(rilevatoreInArea).sprinklers(sprinklersInArea).sirene(sireneInArea)
					.sensoreAllagamento(sensoreAllagamentoInArea).caloriferi(caloriferiInArea)
					.condizionatori(condizionatoriInArea).termostato(termostatoInArea);

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
		sistemaAntiallagamentoImpl = new SistemaAntiallagamentoImpl();
		sistemaAntiallagamentoImpl.start();
		sistemaTemperatura = new SistemaTemperaturaImpl();
		sistemaTemperatura.start();
	}

	/** Bind Method for termometri dependency */
	public void assegnaTermometro(Thermometer thermometer, Map properties) {
		// Metodo ereditato dall' interfaccia
	}

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

}
