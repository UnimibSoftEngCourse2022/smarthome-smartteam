package listeners;

import dominio.Area;
import fr.liglab.adele.icasa.device.GenericDevice;
import fr.liglab.adele.icasa.device.button.PushButton;

public class PulsanteLuciListener extends GenericListener{

	@Override
	public boolean verificaTipologiaDispositivo(GenericDevice dispositivo) {
		return dispositivo instanceof PushButton;
	}

	@Override
	public void gestisciEvento(GenericDevice dispositivo, Area areaInteressata, String nomeProprieta,
			Object vecchioValore, Object nuovoValore) {
			
			PushButton pulsante = (PushButton) dispositivo;
			boolean pulsantePremuto = pulsante.getPropertyValue(PushButton.PUSH_AND_HOLD).equals("true");
			
			if(pulsantePremuto) {
				if(areaInteressata.isLuciAccese()) {
					areaInteressata.spegniLuci();
				}
				else {
					areaInteressata.accendiLuci();
				}
				
				// ripristiniamo il tasto come "non premuto"
				pulsante.setPropertyValue(PushButton.PUSH_AND_HOLD, "false");
			}
		
	}
	

}
