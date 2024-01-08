package dominio;

import java.util.ArrayList;
import java.util.List;

import fr.liglab.adele.icasa.device.light.BinaryLight;
import fr.liglab.adele.icasa.device.security.Siren;
import fr.liglab.adele.icasa.device.sprinkler.Sprinkler;

public class Area {
	
	protected List<BinaryLight> luci;
	protected List<Sprinkler> sprinklers;
	protected List<Siren> sirene;
	private String nome;
	
	public Area(String nome, ArrayList<BinaryLight> luci) {
		this.nome = nome;
		this.luci = luci;
	}
	
	
	// costruttore con irrigatori antincendio (sprinklers)
	public Area(String nome, ArrayList<BinaryLight> luci,  ArrayList<Sprinkler> sprinklers) {
		this(nome, luci);
		this.sprinklers = sprinklers;
	}
	
	
	public String getNome() {
		return nome;
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
