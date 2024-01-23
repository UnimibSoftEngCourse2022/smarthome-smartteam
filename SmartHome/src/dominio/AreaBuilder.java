package dominio;

import java.util.List;

import fr.liglab.adele.icasa.device.button.PushButton;
import fr.liglab.adele.icasa.device.doorWindow.DoorWindowSensor;
import fr.liglab.adele.icasa.device.gasSensor.CarbonDioxydeSensor;
import fr.liglab.adele.icasa.device.light.BinaryLight;
import fr.liglab.adele.icasa.device.light.Photometer;
import fr.liglab.adele.icasa.device.presence.PresenceSensor;
import fr.liglab.adele.icasa.device.security.Siren;
import fr.liglab.adele.icasa.device.sprinkler.Sprinkler;
import fr.liglab.adele.icasa.device.temperature.Cooler;
import fr.liglab.adele.icasa.device.temperature.Heater;
import fr.liglab.adele.icasa.device.security.Camera;
import fr.liglab.adele.icasa.device.security.FloodSensor;

public class AreaBuilder {
	
	String nome;
	PresenceSensor sensorePresenza;
	Photometer fotometro;
	List<BinaryLight> luci;
	CarbonDioxydeSensor rilevatoreCO2;
	List<Sprinkler> sprinklers;
	List<Siren> sirene;
	FloodSensor sensoreAllagamento;
	List<Heater> caloriferi;
	List<Cooler> condizionatori;
	Termostato termostato;
	List<Camera> telecamere;
	DoorWindowSensor sensorePorteFinestre;
	PushButton pulsanteAllarme;
	PushButton pulsanteTemperatura;
	PushButton pulsanteLuci;
	
	
	public AreaBuilder nome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public AreaBuilder pulsanteAllarme(PushButton pulsante) {
		this.pulsanteAllarme = pulsante;
		return this;
	}
	
	public AreaBuilder pulsanteTemperatura(PushButton pulsante) {
		this.pulsanteTemperatura = pulsante;
		return this;
	}
	
	
	public AreaBuilder pulsanteLuci(PushButton pulsante) {
		this.pulsanteLuci = pulsante;
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


	public AreaBuilder termostato(Termostato termostato) {
		this.termostato = termostato;
		return this;
	}
	
	public AreaBuilder telecamere(List<Camera> telecamere) {
		this.telecamere = telecamere;
		return this;
	}

	public AreaBuilder sensorePortaFinestra(DoorWindowSensor sensorePorteFinestre) {
		this.sensorePorteFinestre = sensorePorteFinestre;
		return this;
	}

	
}
