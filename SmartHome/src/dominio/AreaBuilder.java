package dominio;

import java.util.List;

import fr.liglab.adele.icasa.device.gasSensor.CarbonDioxydeSensor;
import fr.liglab.adele.icasa.device.light.BinaryLight;
import fr.liglab.adele.icasa.device.light.Photometer;
import fr.liglab.adele.icasa.device.presence.PresenceSensor;
import fr.liglab.adele.icasa.device.security.Siren;
import fr.liglab.adele.icasa.device.sprinkler.Sprinkler;
import fr.liglab.adele.icasa.device.temperature.Cooler;
import fr.liglab.adele.icasa.device.temperature.Heater;
import fr.liglab.adele.icasa.device.temperature.Thermometer;
import fr.liglab.adele.icasa.device.security.FloodSensor;

public class AreaBuilder {
	
	private String nome;
	private PresenceSensor sensorePresenza;
	private Photometer fotometro;
	private List<BinaryLight> luci;
	private CarbonDioxydeSensor rilevatoreCO2;
	private List<Sprinkler> sprinklers;
	private List<Siren> sirene;
	private FloodSensor sensoreAllagamento;
	private List<Heater> caloriferi;
	private List<Cooler> condizionatori;
	private Termostato termostato;
	
	
	public AreaBuilder nome(String nome) {
		this.nome = nome;
		return this;
	}
	
	
	public AreaBuilder sensorePresenza(PresenceSensor sensore) {
		this.sensorePresenza = sensore;
		return this;
	}
	
	
	public AreaBuilder fotometro(Photometer fotometro) {
		this.fotometro = fotometro;
		return this;
	}
	
	
	public AreaBuilder luci(List<BinaryLight> luci){
	    this.luci = luci;
	    return this;
	}
	
	
	public AreaBuilder rilevatoreCO2(CarbonDioxydeSensor rilevatoreCO2) {
		this.rilevatoreCO2 = rilevatoreCO2;
		return this;
	}

	
	public AreaBuilder sprinklers(List<Sprinkler> sprinklers){
	    this.sprinklers = sprinklers;
	    return this;
	}

	
	public AreaBuilder sirene(List<Siren> sirene){
	    this.sirene = sirene;
	    return this;
	}
	
	
	public AreaBuilder sensoreAllagamento(FloodSensor sensoreAllagamento) {
		this.sensoreAllagamento = sensoreAllagamento;
		return this;
	}
	
	
	public AreaBuilder caloriferi(List<Heater> caloriferi) {
		this.caloriferi = caloriferi;
		return this;
	}
	
	
	public AreaBuilder condizionatori(List<Cooler> condizionatori) {
		this.condizionatori = condizionatori;
		return this;
	}
	

	public String getNome() {
		return nome;
	}


	public PresenceSensor getSensorePresenza() {
		return sensorePresenza;
	}


	public Photometer getFotometro() {
		return fotometro;
	}


	public List<BinaryLight> getLuci() {
		return luci;
	}

	
	public CarbonDioxydeSensor getRilevatoreCO2() {
		return rilevatoreCO2;
	}

	
	public List<Sprinkler> getSprinklers() {
		return sprinklers;
	}


	public List<Siren> getSirene() {
		return sirene;
	}
	
	
	public FloodSensor getSensoreAllagamento() {
		return sensoreAllagamento;
	}


	public List<Heater> getCaloriferi() {
		return caloriferi;
	}


	public List<Cooler> getCondizionatori() {
		return condizionatori;
	}


	public AreaBuilder termostato(Termostato termostato) {
		this.termostato = termostato;
		return this;
	}


	public Termostato getTermostato() {
		return termostato;
	}
	
	
}
