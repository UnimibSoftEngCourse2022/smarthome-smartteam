package controllers;

import fr.liglab.adele.icasa.device.GenericDevice;
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
import fr.liglab.adele.icasa.device.security.Camera;
import fr.liglab.adele.icasa.device.doorWindow.DoorWindowSensor;

public class InizializzaSistemaImpl {

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
	/** Field for telecamere dependency */
	private Camera[] telecamere;
	/** Field for sensoriPorteFinestre dependency */
	private DoorWindowSensor[] sensoriPorteFinestre;

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

	private ArrayList<? extends GenericDevice> cercaDispositiviArea(GenericDevice dispositivi[], String posizione) {
		ArrayList<GenericDevice> dispositiviArea = new ArrayList<>();
		for (GenericDevice dispositivo : dispositivi) {
			if (dispositivo.getPropertyValue(PROPRIETA).equals(posizione)) {
				dispositiviArea.add(dispositivo);
			}
		}
		return dispositiviArea;
	}

	private GenericDevice cercaDispositivoArea(GenericDevice dispositivi[], String posizione) {
		for (GenericDevice dispositivo : dispositivi) {
			if (dispositivo.getPropertyValue(PROPRIETA).equals(posizione)) {
				return dispositivo;
			}
		}
		return null;
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

	/** Component Lifecycle Method */
	public void stop() {
		// Metodo ereditato dall' interfaccia
	}

	/** Component Lifecycle Method */
	public void start() {

		System.out.println("Inizializzazione Stanze partita!");
		// INIZIALIZZAZIONE STANZE
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		List<Area> aree = new ArrayList<>();

		// assumiamo che in ogni area (stanza o corridoio) ci sia un sensore di presenza
		// prendiamo quindi la Location di ciascun sensore per individuare tutti i dispositivi in un'area
		for (PresenceSensor sensorePresenza : sensoriPresenza) {
			String posizioneSensore = (String) sensorePresenza.getPropertyValue("Location");
			// ELEMENTI GESTIONE LUCI

			List<BinaryLight> luciInArea = (List<BinaryLight>) cercaDispositiviArea(luci, posizioneSensore);
			Photometer fotometroInArea = (Photometer) cercaDispositivoArea(fotometri, posizioneSensore);

			// ELEMENTI SISTEMA ANTINCENDIO E SISTEMA ANTIALLAGAMENTO

			CarbonDioxydeSensor rilevatoreInArea = (CarbonDioxydeSensor) cercaDispositivoArea(rilevatoriCO2,
					posizioneSensore);
			List<Sprinkler> sprinklersInArea = (List<Sprinkler>) cercaDispositiviArea(sprinklers, posizioneSensore);
			List<Siren> sireneInArea = (List<Siren>) cercaDispositiviArea(sirene, posizioneSensore);
			FloodSensor sensoreAllagamentoInArea = (FloodSensor) cercaDispositivoArea(sensoriAllagamento,
					posizioneSensore);

			// ELEMENTI SISTEMA TEMPERATURA

			List<Heater> caloriferiInArea = (List<Heater>) cercaDispositiviArea(caloriferi, posizioneSensore);
			List<Cooler> condizionatoriInArea = (List<Cooler>) cercaDispositiviArea(condizionatori, posizioneSensore);
			Thermometer termometroInArea = (Thermometer) cercaDispositivoArea(termometri, posizioneSensore);
			Termostato termostatoInArea = new Termostato(termometroInArea);

			// ELEMENTI SISTEMA SICUREZZA

			List<Camera> camereInArea = (List<Camera>) cercaDispositiviArea(telecamere, posizioneSensore);
			DoorWindowSensor sensorePorteFinestreInArea = (DoorWindowSensor) cercaDispositivoArea(sensoriPorteFinestre,
					posizioneSensore);

			// INIZIALIZZAZIONE AREA
			AreaBuilder builder = new AreaBuilder();
			System.out.println("STO CREANDO UN'AREA");
			builder.nome(posizioneSensore).sensorePresenza(sensorePresenza).fotometro(fotometroInArea).luci(luciInArea)
					.rilevatoreCO2(rilevatoreInArea).sprinklers(sprinklersInArea).sirene(sireneInArea)
					.sensoreAllagamento(sensoreAllagamentoInArea).caloriferi(caloriferiInArea)
					.condizionatori(condizionatoriInArea).termostato(termostatoInArea).telecamere(camereInArea)
					.sensorePortaFinestra(sensorePorteFinestreInArea);

			Area nuovaArea = new Area(builder);

			gestoreAree.aggiungiArea(nuovaArea);
			aree.add(nuovaArea);
		}

		// da questo punto possiamo istanziare SistemaLuciStanzaImpl e SistemaAntincendioImpl
		SistemaLuciStanzaImpl sistemaLuci = new SistemaLuciStanzaImpl(aree);
		sistemaLuci.start();
		SistemaAntincendioImpl sistemaAntincendio = new SistemaAntincendioImpl(aree);
		sistemaAntincendio.start();
		SistemaAntiallagamentoImpl sistemaAntiallagamentoImpl = new SistemaAntiallagamentoImpl(aree);
		sistemaAntiallagamentoImpl.start();
		SistemaTemperaturaImpl sistemaTemperatura = new SistemaTemperaturaImpl(aree);
		sistemaTemperatura.start();
		SistemaSicurezza sistemaSicurezza = new SistemaSicurezza(aree);
		sistemaSicurezza.start();
	}

	/** Bind Method for sensoriPorteFinestre dependency */
	public void assegnaSensorePortaFinestra(DoorWindowSensor doorWindowSensor, Map properties) {
		// TODO: Add your implementation code here
	}

	/** Unbind Method for sensoriPorteFinestre dependency */
	public void ritiraSensorePortaFinestra(DoorWindowSensor doorWindowSensor, Map properties) {
		// TODO: Add your implementation code here
	}

	/** Bind Method for telecamere dependency */
	public void assegnaTelecamera(Camera camera, Map properties) {
		// TODO: Add your implementation code here
	}

	/** Unbind Method for telecamere dependency */
	public void ritiraTelecamera(Camera camera, Map properties) {
		// TODO: Add your implementation code here
	}

}
