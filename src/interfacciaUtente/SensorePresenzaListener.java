package interfacciaUtente;
import fr.liglab.adele.icasa.device.presence.PresenceSensor;

import java.util.ArrayList;
import java.util.List;

import controllers.SistemaLuciStanzaImpl;
import database.GestoreAree;
import dominio.Area;
import fr.liglab.adele.icasa.device.DeviceListener;
import fr.liglab.adele.icasa.device.GenericDevice;
import fr.liglab.adele.icasa.device.light.BinaryLight;
import fr.liglab.adele.icasa.device.light.Photometer;

public class SensorePresenzaListener implements DeviceListener{
	
	private Photometer fotometro;

	public SensorePresenzaListener(Photometer fotometro){
		this.fotometro = fotometro;
	}

	@Override
	public void deviceAdded(GenericDevice arg0) {		
	}

	
	@Override
	public void deviceEvent(GenericDevice arg0, Object arg1) {
	}

	
	@Override
	public void devicePropertyAdded(GenericDevice arg0, String arg1) {
	}

	
	@Override
	public void devicePropertyModified(GenericDevice dispositivo, String nomeProprieta, Object vecchioValore, Object nuovoValore) {
		 
		//ci accertiamo che il device sia un PresenceSensor
		assert dispositivo instanceof PresenceSensor : "e' richiesto un sensore di presenza";
		  
		PresenceSensor sensoreInCambiamento = (PresenceSensor) dispositivo;

		//se il sensore rileva una presenza
		if (nomeProprieta.equals(PresenceSensor.PRESENCE_SENSOR_SENSED_PRESENCE)) {
		   
		    //recupero l'area in cui si trova il sensore
			Area area = recuperoArea((String) sensoreInCambiamento.getPropertyValue("Location"), sensoreInCambiamento);

			//controllo la luminosita' nella stanza, e se e' inferiore ad un certo valore
			//accendo la luce, se la stanza si svuota o c'e' abbastanza luce naturale la spengo
			if(fotometro.getIlluminance() < 1075.0){
				if(sensoreInCambiamento.getSensedPresence()){
					area.accendiLuci();
				}else{
					area.spegniLuci();
				}
			}else {
				area.spegniLuci();
			}
		}

	}

	//metodo per il recupero dell' area in cui si trova sensoreInCambiamento
	public static Area recuperoArea(String areaRilevata, GenericDevice sensoreInCambiamento){
		System.out.println(
				"Il dispositivo con il numero seriale " + sensoreInCambiamento.getSerialNumber() + " e' cambiato");
		System.out.println("Questo sensore e' nell' area:" + areaRilevata);

		GestoreAree gestoreAree = GestoreAree.getIstanza();
		return gestoreAree.getArea(areaRilevata);
	}
	
	
	
	@Override
	public void devicePropertyRemoved(GenericDevice arg0, String arg1) {
	}

	
	@Override
	public void deviceRemoved(GenericDevice arg0) {
	}
	
}
