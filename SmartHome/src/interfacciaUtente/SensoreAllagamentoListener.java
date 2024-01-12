package interfacciaUtente;

import database.GestoreAree;
import dominio.Area;
import fr.liglab.adele.icasa.device.security.FloodSensor;
import fr.liglab.adele.icasa.device.DeviceListener;
import fr.liglab.adele.icasa.device.GenericDevice;

public class SensoreAllagamentoListener implements DeviceListener{

	@Override
	public void deviceAdded(GenericDevice arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deviceEvent(GenericDevice arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void devicePropertyAdded(GenericDevice arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void devicePropertyModified(GenericDevice dispositivo, String nomeProprieta, Object vecchioValore, Object nuovoValore) {
		//ci accertiamo che il device sia un sensore di allagamento
		assert dispositivo instanceof FloodSensor : "e' richiesto un sensore di allagamento";
				  
		FloodSensor sensoreAllagamento = (FloodSensor) dispositivo;
		boolean areaAllagata = false;
		if(sensoreAllagamento.getPropertyValue(FloodSensor.FLOOD_SENSOR_ALARM).equals("true")) {
			areaAllagata = true;
		}
		
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		Area areaInteressata = gestoreAree.getArea((String) sensoreAllagamento.getPropertyValue("Location"));
		
		if(areaAllagata) {
			System.out.println("L'AREA " + areaInteressata.getNome().toUpperCase() + " E' ALLAGATA");
			areaInteressata.accendiSirene();
		}else {
			System.out.println("L'AREA " + areaInteressata.getNome().toUpperCase() + " NON E' PIU' ALLAGATA");
			areaInteressata.spegniSirene();
		}
		
	}

	@Override
	public void devicePropertyRemoved(GenericDevice arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deviceRemoved(GenericDevice arg0) {
		// TODO Auto-generated method stub
		
	}

}
