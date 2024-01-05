package dominio;

import fr.liglab.adele.icasa.device.light.BinaryLight;

import java.util.ArrayList;

public class Stanza extends Area {

	public Stanza(String nome, ArrayList<BinaryLight> luci) {
		super(nome, luci);
	}
}
