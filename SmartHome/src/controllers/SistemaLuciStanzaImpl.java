package controllers;

import fr.liglab.adele.icasa.device.presence.PresenceSensor;
import interfacciaUtente.SensorePresenzaListener;

import java.util.List;

import database.GestoreAree;
import dominio.Area;

public class SistemaLuciStanzaImpl {

	SensorePresenzaListener listenerSensore = new SensorePresenzaListener();
	
	/** metodo per assegnare le dipendenze ai sensori di presenza. 
	* Collega le aree create nel simulatore a quelle del sistema.
	* Assegnando ad ogni area le rispettive luci e sensori
	public void assegnaSensorePresenza(PresenceSensor sensorePresenza) {

		GestoreAree gestoreAree = GestoreAree.getIstanza();
		String nomeArea = (String) sensorePresenza.getPropertyValue("Location");
		Area area = gestoreAree.getArea(nomeArea);
		// avendo assunto che ogni stanza debba avere un sensore di presenza
		// se un'area non ha più un sensore di presenza, viene riaggiunto
		if(area.getSensorePresenza() == null) {
			area.setSensorePresenza(sensorePresenza);
			assegnaListener(sensorePresenza);
		}
		
	}
	
	
	// metodo per rimuovere le dipendenze dai sensori di presenza
	public void ritiraSensorePresenza(PresenceSensor sensorePresenza) {
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		String nomeArea = (String) sensorePresenza.getPropertyValue("Location");
		Area area = gestoreAree.getArea(nomeArea);
		if(area.getSensorePresenza() != null) {
			area.setSensorePresenza(null);
			rimuoviListener(sensorePresenza);
		}
	}
	*/	
	

	/** metodo per assegnare un listener ad un sensore di presenza per regolare il comportamento
	 * 	a seconda della rilevazione di un fotometro
	*/
	public void assegnaListener(PresenceSensor sensorePresenza){
		sensorePresenza.addListener(listenerSensore);
	}


	// metodo per rimuovere un listener da un sensore di presenza non piu' usato
	public void rimuoviListener(PresenceSensor sensorePresenza){
		sensorePresenza.removeListener(listenerSensore);
	}

	
	/** Metodo di fine ciclo di vita del componente */
	public void stop() {
		System.out.println("Fine sistema gestione LUCI");

		GestoreAree gestoreAree = GestoreAree.getIstanza();
		List<Area> aree = gestoreAree.getAree();
		for(Area area : aree) {
			rimuoviListener(area.getSensorePresenza());
		}
	}


	/** Metodo di inizio ciclo di vita del componente */
	public void start() {
		System.out.println("Inizio sistema gestione LUCI");
		
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		List<Area> aree = gestoreAree.getAree();
		for(Area area : aree) {
			assegnaListener(area.getSensorePresenza());
		}
	}
	
}