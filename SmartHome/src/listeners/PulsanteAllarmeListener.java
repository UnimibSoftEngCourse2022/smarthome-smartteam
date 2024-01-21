package listeners;

import database.GestoreAree;
import dominio.Area;
import fr.liglab.adele.icasa.device.GenericDevice;
import fr.liglab.adele.icasa.device.button.PushButton;
import interfaccia_utente.TerminaleIO;

public class PulsanteAllarmeListener extends GenericListener{

	private TerminaleIO terminaleIO = TerminaleIO.getIstanza();
	
	@Override
	public boolean verificaTipologiaDispositivo(GenericDevice dispositivo) {
		return dispositivo instanceof PushButton;
	}

	@Override
	public void gestisciEvento(GenericDevice dispositivo, Area areaInteressata, String nomeProprieta,
			Object vecchioValore, Object nuovoValore) {
		PushButton pulsanteAllarme = (PushButton) dispositivo;
		
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		boolean pulsantePremuto = pulsanteAllarme.getPropertyValue(PushButton.PUSH_AND_HOLD).equals("true");
		if(pulsantePremuto && gestoreAree.isAllarmeAcceso()) {
			terminaleIO.spegniAllarme();
		}
		else if(pulsantePremuto){
			System.out.println("STO ATTIVANDO L'ALLARME");
			gestoreAree.accendiAllarme();
		}
		
		pulsanteAllarme.setPropertyValue(PushButton.PUSH_AND_HOLD, "false");
		
	}

}
