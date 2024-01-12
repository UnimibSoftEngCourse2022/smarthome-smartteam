package dominio;

import java.util.ArrayList;
import java.util.List;

import fr.liglab.adele.icasa.device.gasSensor.CarbonDioxydeSensor;
import fr.liglab.adele.icasa.device.light.BinaryLight;
import fr.liglab.adele.icasa.device.light.Photometer;
import fr.liglab.adele.icasa.device.presence.PresenceSensor;
import fr.liglab.adele.icasa.device.security.Siren;
import fr.liglab.adele.icasa.device.sprinkler.Sprinkler;
import fr.liglab.adele.icasa.device.security.FloodSensor;

public class Area {
	
	private String nome;
	protected PresenceSensor sensorePresenza;
	protected Photometer fotometro;
	protected List<BinaryLight> luci;
	protected CarbonDioxydeSensor rilevatoreCO2;
	protected List<Sprinkler> sprinklers;
	protected List<Siren> sirene;
	protected FloodSensor sensoreAllagamento;
	
	
	public Area(AreaBuilder builder) {
		this.nome = builder.getNome();
		this.sensorePresenza = builder.getSensorePresenza();
		this.fotometro = builder.getFotometro();
		this.luci = builder.getLuci();
		this.rilevatoreCO2 = builder.getRilevatoreCO2();
		this.sprinklers = builder.getSprinklers();
		this.sirene = builder.getSirene();
		this.sensoreAllagamento = builder.getSensoreAllagamento();
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
	
	
	public boolean equals(Area area){
		if(this.getNome().equals(area.nome))
			return true;
		return false;
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
}
