package listeners;
import fr.liglab.adele.icasa.device.presence.PresenceSensor;
import dominio.Area;
import fr.liglab.adele.icasa.device.GenericDevice;
import fr.liglab.adele.icasa.device.light.Photometer;

public class SensorePresenzaListener extends GenericListener{

	@Override
	public boolean verificaTipologiaDispositivo(GenericDevice dispositivo) {
		return dispositivo instanceof PresenceSensor;
	}

	@Override
	public void gestisciEvento(GenericDevice dispositivo, Area areaInteressata, String nomeProprieta, Object vecchioValore,
			Object nuovoValore) {
		
		PresenceSensor sensorePresenza = (PresenceSensor) dispositivo;
		
		//se il sensore rileva una presenza
		if (nomeProprieta.equals(PresenceSensor.PRESENCE_SENSOR_SENSED_PRESENCE)) {
			Photometer fotometro = areaInteressata.getFotometro();
			//controllo la luminosita' nella stanza, e se e' inferiore ad un certo valore
			//accendo la luce, se la stanza si svuota o c'e' abbastanza luce naturale la spengo
			if(fotometro.getIlluminance() < 1075.0 && sensorePresenza.getSensedPresence()){
				areaInteressata.accendiLuci();
			}else {
				areaInteressata.spegniLuci();
			}
		}
		
	}
	
}
