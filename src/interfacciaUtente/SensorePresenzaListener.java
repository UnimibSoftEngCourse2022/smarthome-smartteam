package interfacciaUtente;
import fr.liglab.adele.icasa.device.presence.PresenceSensor;

import java.util.ArrayList;
import java.util.List;

import controllers.SistemaLuciStanzaImpl;
import database.GestoreAree;
import dominio.Stanza;
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
		assert dispositivo instanceof PresenceSensor : "è richiesto un sensore di presenza";
		  
		PresenceSensor sensoreInCambiamento = (PresenceSensor) dispositivo;

		//se il sensore rileva una presenza
		if (nomeProprieta.equals(PresenceSensor.PRESENCE_SENSOR_SENSED_PRESENCE)) {
		   
		   //recupero l'area (stanza) in cui si trova il sensore
		   String areaRilevata = (String) sensoreInCambiamento.getPropertyValue("Location");
		   System.out.println("Il dispositivo con il numero seriale " + sensoreInCambiamento.getSerialNumber() + " è cambiato");
		   System.out.println("Questo sensore e' nella stanza:" + areaRilevata);  
		   
			GestoreAree gestoreAree = GestoreAree.getIstanza();
			Stanza stanza = (Stanza) gestoreAree.getArea(areaRilevata);
			if(fotometro.getIlluminance() < 1075.0){
				if(sensoreInCambiamento.getSensedPresence()){
					stanza.accendiLuci();
				}else{
					//timer TODO
					//if(!sensoreInCambiamento.getSensedPresence()){
					stanza.spegniLuci();
					//}
				}
			}else {
				stanza.spegniLuci();
			}
		}

	}
	
	@Override
	public void devicePropertyRemoved(GenericDevice arg0, String arg1) {
	}

	
	@Override
	public void deviceRemoved(GenericDevice arg0) {
	}
	
}
