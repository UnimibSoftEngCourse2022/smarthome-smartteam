package listeners;

import dominio.Area;
import fr.liglab.adele.icasa.device.security.FloodSensor;
import fr.liglab.adele.icasa.device.GenericDevice;

public class SensoreAllagamentoListener extends GenericListener{

	@Override
	public boolean verificaTipologiaDispositivo(GenericDevice dispositivo) {
		return dispositivo instanceof FloodSensor;
	}

	@Override
	public void gestisciEvento(GenericDevice dispositivo, Area areaInteressata, String nomeProprieta, Object vecchioValore,
			Object nuovoValore) {
		
		FloodSensor sensoreAllagamento = (FloodSensor) dispositivo;
		boolean areaAllagata = false;
		if(sensoreAllagamento.getPropertyValue(FloodSensor.FLOOD_SENSOR_ALARM).equals("true")) {
			areaAllagata = true;
		}
		
		if(areaAllagata) {
			System.out.println("L'AREA " + areaInteressata.getNome().toUpperCase() + " E' ALLAGATA");
			areaInteressata.accendiSirene();
		}else {
			System.out.println("L'AREA " + areaInteressata.getNome().toUpperCase() + " NON E' PIU' ALLAGATA");
			areaInteressata.spegniSirene();
		}
	}

}
