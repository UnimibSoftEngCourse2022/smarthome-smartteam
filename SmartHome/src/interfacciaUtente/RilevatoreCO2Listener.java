package interfacciaUtente;

import java.util.ArrayList;
import java.util.List;

import controllers.SistemaAntincendioImpl;
import database.GestoreAree;
import dominio.Area;
import fr.liglab.adele.icasa.device.DeviceListener;
import fr.liglab.adele.icasa.device.GenericDevice;
import fr.liglab.adele.icasa.device.gasSensor.CarbonDioxydeSensor;
import fr.liglab.adele.icasa.device.presence.PresenceSensor;

public class RilevatoreCO2Listener implements DeviceListener{
	
	@Override
	public void deviceAdded(GenericDevice arg0) {
		// Metodo ereditato dall' interfaccia
	}

	@Override
	public void deviceEvent(GenericDevice arg0, Object arg1) {
		// Metodo ereditato dall' interfaccia
	}

	@Override
	public void devicePropertyAdded(GenericDevice arg0, String arg1) {
		// Metodo ereditato dall' interfaccia
	}

	@Override
	public void devicePropertyModified(GenericDevice dispositivo, String nomeProprieta, Object vecchioValore, Object nuovoValore) {
	
		//ci accertiamo che il device sia un rilevatore di CO2
		assert dispositivo instanceof CarbonDioxydeSensor : "e' richiesto un rilevatore di CO2";
				  
		CarbonDioxydeSensor rilevatoreCO2 = (CarbonDioxydeSensor) dispositivo;
		double concentrazioneCO2 = rilevatoreCO2.getCO2Concentration();
		
		System.out.println("Ho misurato qualcosa: " + concentrazioneCO2);
		
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		Area areaInteressata = gestoreAree.getArea((String) rilevatoreCO2.getPropertyValue("Location"));
		if(concentrazioneCO2 >= 2) {
			// allarme
			areaInteressata.accendiSirene();
			System.out.println("CONCENTRAZIONE DI ANIDRIDE CARBONICA IN AUMENTO IN " + areaInteressata.getNome().toUpperCase() + "!!!");
			
			if(concentrazioneCO2 > 500) {
				//attivazione sprinkler
				areaInteressata.accendiSprinklers();
				System.out.println("SISTEMA ANTINCENDIO ATTIVATO IN " + areaInteressata.getNome().toUpperCase() + "!!!");
			}
			else {
				areaInteressata.spegniSprinklers();
				System.out.println("INCENDIO IN " + areaInteressata.getNome().toUpperCase() + " DOMATO!");
			}
		}
		else {
			areaInteressata.spegniSirene();
			System.out.println("CONCENTRAZIONE DI ANIDRIDE CARBONICA IN " + areaInteressata.getNome().toUpperCase() + " RIENTRATA NEI PARAMETRI ACCETTABILI");
			if((double) vecchioValore > 500.0) {
				areaInteressata.spegniSprinklers();
				System.out.println("INCENDIO IN " + areaInteressata.getNome().toUpperCase() + " DOMATO!");
			}
		}
		
		
	}

	@Override
	public void devicePropertyRemoved(GenericDevice arg0, String arg1) {
		// Metodo ereditato dall' interfaccia		
	}

	@Override
	public void deviceRemoved(GenericDevice arg0) {
		// Metodo ereditato dall' interfaccia		
	}
	 
}
