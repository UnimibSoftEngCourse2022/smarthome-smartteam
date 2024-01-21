package listeners;

import dominio.Area;
import fr.liglab.adele.icasa.device.GenericDevice;
import fr.liglab.adele.icasa.device.doorWindow.DoorWindowSensor;


public class SensorePortaFinestraListener extends GenericListener{

	@Override
	public boolean verificaTipologiaDispositivo(GenericDevice dispositivo) {
		return dispositivo instanceof DoorWindowSensor;
	}

	@Override
	public void gestisciEvento(GenericDevice dispositivo, Area areaInteressata, String nomeProprieta,
			Object vecchioValore, Object nuovoValore) {
		
		DoorWindowSensor sensorePortaFinestra = (DoorWindowSensor) dispositivo;
		
		boolean finestraPortaAperta = sensorePortaFinestra.getPropertyValue(DoorWindowSensor.DOOR_WINDOW_SENSOR_OPENING_DETECTCION).equals("true");
		if(finestraPortaAperta && nomeProprieta.equals(sensorePortaFinestra.DOOR_WINDOW_SENSOR_OPENING_DETECTCION)) {
			areaInteressata.chiamaAllarme();
		}
	}

}
