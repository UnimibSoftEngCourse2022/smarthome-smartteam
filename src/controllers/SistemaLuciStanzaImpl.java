package controllers;

import fr.liglab.adele.icasa.device.presence.PresenceSensor;
import interfacciaUtente.SensorePresenzaListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import fr.liglab.adele.icasa.device.light.BinaryLight;
import fr.liglab.adele.icasa.device.light.Photometer;

import java.util.Map;

import database.GestoreAree;
import dominio.Area;
import dominio.Stanza;
import fr.liglab.adele.icasa.device.motion.MotionSensor;

public class SistemaLuciStanzaImpl {

	private PresenceSensor[] sensoriPresenza;
	private BinaryLight[] luci;
	private Photometer[] fotometri;
	private Map<PresenceSensor, SensorePresenzaListener> listenersSensori = new HashMap<PresenceSensor, SensorePresenzaListener>();

	public BinaryLight[] getLuci() {
		return luci;
	}


	/** metodo per assegnare le dipendenze ai fotometri */
	public void assegnaFotometro(Photometer fotometro, Map proprieta) {

	}


	/** metodo per rimuovere le dipendenze dai fotometri */
	public void ritiraFotometro(Photometer fotometro, Map proprieta) {

	}


	/** metodo per assegnare le dipendenze alle luci */
	public void assegnaLuce(BinaryLight luce, Map proprieta) {

	}


	/** metodo per rimuovere le dipendenze dalle luci */
	public void ritiraLuce(BinaryLight luce, Map proprieta) {

	}


	/** metodo per assegnare le dipendenze ai sensori di presenza. 
	* Collega le aree create nel simulatore a quelle del sistema.
	* Assegnando ad ogni area le rispettive luci e sensori*/
	public void assegnaSensorePresenza(PresenceSensor sensorePresenza, Map proprieta) {

		GestoreAree gestoreAree = GestoreAree.getIstanza();
		ArrayList<BinaryLight> luciArea = cercaLuciArea(luci, sensorePresenza);
		Photometer fotometroArea = cercaFotometroArea(fotometri, sensorePresenza);
		assegnaListener(fotometroArea, sensorePresenza);
		Area nuovaArea = new Area((String) sensorePresenza.getPropertyValue("Location"), luciArea);
		gestoreAree.aggiungiArea(nuovaArea);
	}


	/** ricerca tutte le luci (binary lights) presenti in un'area (stanza o corridoio)*/
	public ArrayList<BinaryLight> cercaLuciArea(BinaryLight luci[], PresenceSensor sensorePresenza){
		ArrayList<BinaryLight> luciArea = new ArrayList<BinaryLight>();
		for (BinaryLight luce : luci) {
			if (luce.getPropertyValue("Location").equals(sensorePresenza.getPropertyValue("Location"))) {
				luciArea.add(luce);
			}
		}
		return luciArea;
	}


	/** ricerca di un fotometro nell'area in cui si trova il sensore di presenza */
	public Photometer cercaFotometroArea(Photometer[] fotometri, PresenceSensor sensorePresenza){
		Photometer fotometroArea = null;
		for (Photometer fotometro : fotometri) {
			if (fotometro.getPropertyValue("Location").equals(sensorePresenza.getPropertyValue("Location"))) {
				fotometroArea = fotometro;
			}
		}
		return fotometroArea;
	}


	/** metodo per assegnare un listener ad un sensore di presenza per regolare il comportamento
	 * 	a seconda della rilevazione di un fotometro
	*/
	public void assegnaListener(Photometer fotometroArea, PresenceSensor sensorePresenza){
		if (fotometroArea != null) {
			SensorePresenzaListener listenerSensore = new SensorePresenzaListener(fotometroArea);
			sensorePresenza.addListener(listenerSensore);
			listenersSensori.put(sensorePresenza, listenerSensore);
		}
	}


	/** metodo per rimuovere un listener da un sensore di presenza non piu' usato*/
	public void rimuoviListener(PresenceSensor sensorePresenza){
		sensorePresenza.removeListener(listenersSensori.get(sensorePresenza));
		listenersSensori.remove(sensorePresenza);
	}


	/** metodo per rimuovere le dipendenze dai sensori di presenza */
	public void ritiraSensorePresenza(PresenceSensor sensorePresenza, Map proprieta) {
		rimuoviListener(sensorePresenza);
	}


	/** Metodo di fine ciclo di vita del componente */
	public void stop() {
		System.out.println("Fine");

		for (PresenceSensor sensorePresenza : sensoriPresenza) {
			rimuoviListener(sensorePresenza);
		}
	}


	/** Metodo di inizio ciclo di vita del componente */
	public void start() {
		System.out.println("Inizio");
	}
	
}