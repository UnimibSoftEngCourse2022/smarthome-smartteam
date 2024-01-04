package dominio;

import java.util.Map;
import fr.liglab.adele.icasa.device.presence.PresenceSensor;
import java.util.ArrayList;
import java.util.List;
import fr.liglab.adele.icasa.device.light.BinaryLight;

public class Stanza extends Area {

	private PresenceSensor sensorePresenza;

	public Stanza(String nome, ArrayList<BinaryLight> luci) {
		super(nome, luci);
	}

	public void accendiLuci(){
		for(int i = 0; i < luci.size(); i++){
			luci.get(i).turnOn();
		}
	}

	public void spegniLuci() {
		for(int i = 0; i < luci.size(); i++){
			luci.get(i).turnOff();
		}
	}

}
