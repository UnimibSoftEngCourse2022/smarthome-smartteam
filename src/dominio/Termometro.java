package dominio;

import controllers.SistemaTemperaturaImpl;
import database.GestoreAree;
import fr.liglab.adele.icasa.device.temperature.Thermometer;

public class Termometro extends Thread{
		
		public Thermometer termometro;
		private boolean tempAccesa = true;
		
		public Termometro(Thermometer termometro) {
			this.termometro = termometro;
		}

		public Thermometer getTermometro() {
			return termometro;
		}
		@Override
		public void run() {
			GestoreAree ga =  GestoreAree.getIstanza();
			//System.out.println("Termometro in " + termometro.getPropertyValue("Location") + " in ascolto");
			while(tempAccesa)
				controlloTemperatura(termometro, ga.getArea( (String) termometro.getPropertyValue("Location")));
			}
		
		public synchronized void controlloTemperatura(Thermometer termometroAllertato, Area area) {
			
		
			GestoreAree gestoreAree = GestoreAree.getIstanza();
			
			
			if(termometroAllertato.getTemperature() < gestoreAree.getTempMinima()) {
				area.accendiCalorifero(gestoreAree.getTempMinima());
				area.spegniCondizionatore();
				while(termometroAllertato.getTemperature() < gestoreAree.getTempMinima());
			}
			else if(termometroAllertato.getTemperature() > gestoreAree.getTempMassima()) {
				area.accendiCondizionatore(gestoreAree.getTempMassima());
				area.spegniCalorifero();
				while(termometroAllertato.getTemperature() > gestoreAree.getTempMassima());
			}
			area.spegniCalorifero();
			area.spegniCondizionatore();
		}

}
