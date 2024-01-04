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
import dominio.Stanza;

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

	/** metodo per assegnare le dipendenze ai sensori di presenza */
	/** Collega le stanze create nel simulatore al sistema*/
	public void assegnaSensorePresenza(PresenceSensor sensorePresenza, Map proprieta) {
		
		SensorePresenzaListener listenerSensore;
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		//cerca le luci della stanza
		ArrayList<BinaryLight> luciStanza = new ArrayList<BinaryLight>();
		for(BinaryLight luce : luci){
			if(luce.getPropertyValue("Location").equals(sensorePresenza.getPropertyValue("Location"))){
				luciStanza.add(luce);
			}
		}
		//cerca il fotometro della stanza
		Photometer fotometroStanza = null;
		for(int i = 0; i < fotometri.length; i++){
			Photometer fotometro = fotometri[i];
			if(fotometro.getPropertyValue("Location").equals(sensorePresenza.getPropertyValue("Location"))){
				fotometroStanza = fotometro;
			}
		}
		if(fotometroStanza != null) {
			listenerSensore = new SensorePresenzaListener(fotometroStanza);
			sensorePresenza.addListener(listenerSensore);
			listenersSensori.put(sensorePresenza, listenerSensore);
		}
		Stanza temp = new Stanza((String) sensorePresenza.getPropertyValue("Location"), luciStanza);
		gestoreAree.aggiungiArea(temp);
	}

	/** metodo per rimuovere le dipendenze dai sensori d */
	public void ritiraSensorePresenza(PresenceSensor sensorePresenza, Map proprieta) {
		sensorePresenza.removeListener(listenersSensori.get(sensorePresenza));
		listenersSensori.remove(sensorePresenza);
	}

	/** Metodo di fine ciclo di vita del componente */
	public void stop() {
		System.out.println("Fine");

		for(PresenceSensor sensorePresenza : sensoriPresenza){
			sensorePresenza.removeListener(listenersSensori.get(sensorePresenza));
			listenersSensori.remove(sensorePresenza);
		}
	}

	/** Metodo di inizio ciclo di vita del componente */
	public void start() {
		System.out.println("Inizio");
	}
	
}