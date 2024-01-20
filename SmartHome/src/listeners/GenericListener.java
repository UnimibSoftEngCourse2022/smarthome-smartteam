package listeners;

import database.GestoreAree;
import dominio.Area;
import fr.liglab.adele.icasa.device.DeviceListener;
import fr.liglab.adele.icasa.device.GenericDevice;

public abstract class GenericListener implements DeviceListener{

	@Override
	public void deviceAdded(GenericDevice arg0) {
		// Metodo ereditato dall'interfaccia
	}

	@Override
	public void deviceEvent(GenericDevice arg0, Object arg1) {
		// Metodo ereditato dall'interfaccia
	}

	@Override
	public void devicePropertyAdded(GenericDevice arg0, String arg1) {
		// Metodo ereditato dall'interfaccia
	}

	@Override
	public void devicePropertyModified(GenericDevice dispositivo, String nomeProprieta, Object vecchioValore, Object nuovoValore) {
		
		if(!verificaTipologiaDispositivo(dispositivo)) {
			System.out.println("Errore, il dispositivo non è della tipologia richiesta");
		}
		
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		Area areaInteressata = gestoreAree.getArea((String) dispositivo.getPropertyValue("Location"));
		
		gestisciEvento(dispositivo, areaInteressata, nomeProprieta, vecchioValore, nuovoValore);
		
	}

	@Override
	public void devicePropertyRemoved(GenericDevice arg0, String arg1) {
		// Metodo ereditato dall'interfaccia
	}

	@Override
	public void deviceRemoved(GenericDevice arg0) {
		// Metodo ereditato dall'interfaccia
	}
	
	public abstract boolean verificaTipologiaDispositivo(GenericDevice dispositivo);

	public abstract void gestisciEvento(GenericDevice dispositivo, Area areaInteressata, String nomeProprieta, Object vecchioValore, Object nuovoValore);
	
}
