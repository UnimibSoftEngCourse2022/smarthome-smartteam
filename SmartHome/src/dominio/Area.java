package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
		this.nome = builder.nome;
		this.sensorePresenza = builder.sensorePresenza;
		this.fotometro = builder.fotometro;
		this.luci = builder.luci;
		this.rilevatoreCO2 = builder.rilevatoreCO2;
		this.sprinklers = builder.sprinklers;
		this.sirene = builder.sirene;
		this.sensoreAllagamento = builder.sensoreAllagamento;
		this.caloriferi = builder.caloriferi;
		this.condizionatori = builder.condizionatori;
		this.termostato = builder.termostato;
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
	
	public void accendiLuci() {
		for (int i = 0; i < luci.size(); i++) {
			luci.get(i).turnOn();
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Area other = (Area) obj;
		return nome.equals(other.nome);
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


	public FloodSensor getSensoreAllagamento() {
		return sensoreAllagamento;
	}


	public CarbonDioxydeSensor getRilevatoreCO2() {
		return rilevatoreCO2;
	}


	public PresenceSensor getSensorePresenza() {
		return sensorePresenza;
	}


	public String getNome() {
		return nome;
	}


	public Photometer getFotometro() {
		return fotometro;
	}
	
}
