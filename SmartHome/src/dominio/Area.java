package dominio;

import java.util.ArrayList;
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

public class Area {
	
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
	private double tempMinima = 296.5;
    private double tempMassima = 299.5;
	private Termostato termostato;
	
	
	public Termostato getTermostato() {
		return termostato;
	}


	public void setTermostato(Termostato termostato) {
		this.termostato = termostato;
	}


	public Area(AreaBuilder builder) {
		this.nome = builder.getNome();
		this.sensorePresenza = builder.getSensorePresenza();
		this.fotometro = builder.getFotometro();
		this.luci = builder.getLuci();
		this.rilevatoreCO2 = builder.getRilevatoreCO2();
		this.sprinklers = builder.getSprinklers();
		this.sirene = builder.getSirene();
		this.sensoreAllagamento = builder.getSensoreAllagamento();
		this.caloriferi = builder.getCaloriferi();
		this.condizionatori = builder.getCondizionatori();
		this.termostato = builder.getTermostato();
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


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setSensorePresenza(PresenceSensor sensorePresenza) {
		this.sensorePresenza = sensorePresenza;
	}


	public void setFotometro(Photometer fotometro) {
		this.fotometro = fotometro;
	}


	public void setLuci(List<BinaryLight> luci) {
		this.luci = luci;
	}

	
	public void setRilevatoreCO2(CarbonDioxydeSensor rilevatoreCO2) {
		this.rilevatoreCO2 = rilevatoreCO2;
	}
	

	public void setSprinklers(List<Sprinkler> sprinklers) {
		this.sprinklers = sprinklers;
	}
	
	
	public void setSirene(List<Siren> sirene) {
		this.sirene = sirene;
	}
	
	
	public double getTempMinima() {
		return tempMinima;
	}

	public void setTempMinima(double tempMinima) {
		this.tempMinima = tempMinima;
	}

	public double getTempMassima() {
		return tempMassima;
	}

	public void setTempMassima(double tempMassima) {
		this.tempMassima = tempMassima;
	}
	
	@Override
	public boolean equals(Area area){
		return this.getNome().equals(area.nome);
	}

	
	public void accendiLuci() {
		for (int i = 0; i < luci.size(); i++) {
			luci.get(i).turnOn();
		}
	}

	
	public void spegniLuci() {
		for(int i = 0; i < luci.size(); i++){
			luci.get(i).turnOff();
		}
	}
	
	
	public void accendiSprinklers() {
		for (int i = 0; i < sprinklers.size(); i++) {
			sprinklers.get(i).turnOn();
		}
	}
	
	
	public void spegniSprinklers() {
		for (int i = 0; i < sprinklers.size(); i++) {
			sprinklers.get(i).turnOff();
		}
	}
	
	
	public void accendiSirene() {
		for (int i = 0; i < sirene.size(); i++) {
			sirene.get(i).turnOn();
		}
	}

	
	public void spegniSirene() {
		for(int i = 0; i < sirene.size(); i++){
			sirene.get(i).turnOff();
		}
	}
	
	
	public void accendiCaloriferi() {
		for(Heater calorifero : caloriferi) {
			calorifero.setPowerLevel(1);
		}
	}
	
	
	public void spegniCaloriferi() {
		for(Heater calorifero : caloriferi) {
			calorifero.setPowerLevel(0);
		}
	}
	
	
	public void accendiCondizionatori() {
		for(Cooler condizionatore : condizionatori) {
			condizionatore.setPowerLevel(1);
		}
	}
	
	
	public void spegniCondizionatori() {
		for(Cooler condizionatore : condizionatori) {
			condizionatore.setPowerLevel(0);
		}
	}
	
}
