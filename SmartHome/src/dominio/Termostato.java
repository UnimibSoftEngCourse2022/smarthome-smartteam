package dominio;

import database.GestoreAree;
import fr.liglab.adele.icasa.device.temperature.Thermometer;

public class Termostato extends Thread{
		
	private Thermometer termometro;
	private boolean tempAccesa = true;
	
	public Termostato(Thermometer termometro) {
		this.termometro = termometro;
	}
	
	public boolean isTempAccesa() {
		return tempAccesa;
	}


	public Thermometer getTermometro() {
		return termometro;
	}
	
	
	public void setTempAccesa(boolean tempAccesa) {
		this.tempAccesa = tempAccesa;
	}
	
	
	@Override
	public void run() {
		GestoreAree gestoreAree =  GestoreAree.getIstanza();
		Area area = gestoreAree.getArea((String) termometro.getPropertyValue("Location"));
		while(tempAccesa) {
			if(termometro.getTemperature() < area.getTempMinima()) {
				area.accendiCaloriferi();
				area.spegniCondizionatori();
				while(termometro.getTemperature() < area.getTempMinima());
			}
			else if(termometro.getTemperature() > area.getTempMassima()) {
				area.accendiCondizionatori();
				area.spegniCaloriferi();
				while(termometro.getTemperature() > area.getTempMassima());
			}
			area.spegniCaloriferi();
			area.spegniCondizionatori();
		}
	}
}
