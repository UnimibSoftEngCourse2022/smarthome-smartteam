package dominio;

import java.util.List;

import fr.liglab.adele.icasa.device.gasSensor.CarbonDioxydeSensor;
import fr.liglab.adele.icasa.device.light.BinaryLight;
import fr.liglab.adele.icasa.device.light.Photometer;
import fr.liglab.adele.icasa.device.presence.PresenceSensor;
import fr.liglab.adele.icasa.device.security.Siren;
import fr.liglab.adele.icasa.device.sprinkler.Sprinkler;

public class AreaBuilder {
	
	private String nome;
	private PresenceSensor sensorePresenza;
	private Photometer fotometro;
	private List<BinaryLight> luci;
	private CarbonDioxydeSensor rilevatoreCO2;
	private List<Sprinkler> sprinklers;
	private List<Siren> sirene;
	
	
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
	
}
