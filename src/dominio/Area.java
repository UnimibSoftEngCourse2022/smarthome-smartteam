package dominio;

import java.util.ArrayList;
import java.util.List;

import fr.liglab.adele.icasa.device.light.BinaryLight;
import fr.liglab.adele.icasa.device.temperature.Cooler;
import fr.liglab.adele.icasa.device.temperature.Heater;

public class Area {
	
	protected List<BinaryLight> luci;
	private String nome;
	private Heater calorifero;
	private Cooler condizionatore;
	public Area(String nome, ArrayList<BinaryLight> luci) {
		this.nome = nome;
		this.luci = luci; 
	}
	
	public void setCondizionatore(Cooler condizionatore) {
		this.condizionatore = condizionatore;
	}
	
	public void setCalorifero(Heater calorifero) {
		this.calorifero = calorifero;
	}
	
	public String getNome() {
		return nome;
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
	
	
	public void accendiCalorifero(double temp) {
		//double powerLevel = (temp - 293.15)/10;
		this.calorifero.setPowerLevel(1);
	}
	public void spegniCalorifero() {
		this.calorifero.setPowerLevel(0);
	}
	
	public void accendiCondizionatore(double temp) {
		//double powerLevel = (293.15 - temp)/10;
		this.condizionatore.setPowerLevel(1);
	}
	public void spegniCondizionatore() {
		this.condizionatore.setPowerLevel(0);
	}
}
