package listeners;


import dominio.Area;
import dominio.Termostato;
import fr.liglab.adele.icasa.device.GenericDevice;
import fr.liglab.adele.icasa.device.button.PushButton;
import fr.liglab.adele.icasa.device.temperature.Thermometer;

public class PulsanteTemperaturaListener extends GenericListener{
	
	@Override
	public boolean verificaTipologiaDispositivo(GenericDevice dispositivo) {
		return dispositivo instanceof PushButton;
	}

	@Override
	public void gestisciEvento(GenericDevice dispositivo, Area areaInteressata, String nomeProprieta,
			Object vecchioValore, Object nuovoValore) {
		PushButton pulsanteTemperatura = (PushButton) dispositivo;
		
		boolean pulsantePremuto = pulsanteTemperatura.getPropertyValue(PushButton.PUSH_AND_HOLD).equals("true");
		Termostato termostatoInStanza = areaInteressata.getTermostato();
		boolean tempAccesa = termostatoInStanza.isTempAccesa();
		Thermometer termometro = termostatoInStanza.getTermometro();
		if(pulsantePremuto && tempAccesa) {
			termostatoInStanza.setTempAccesa(false);
		}
		else if(pulsantePremuto){
			Termostato nuovoTermostato = new Termostato(termometro);
			areaInteressata.setTermostato(nuovoTermostato);
			nuovoTermostato.start();
		}
		
		pulsanteTemperatura.setPropertyValue(PushButton.PUSH_AND_HOLD, "false");
		
	}
}
