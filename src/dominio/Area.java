package dominio;

import java.util.ArrayList;
import java.util.List;

import fr.liglab.adele.icasa.device.light.BinaryLight;

public class Area {
	
	protected List<BinaryLight> luci;
	private String nome;
	
	public Area(String nome, ArrayList<BinaryLight> luci) {
		this.nome = nome;
		this.luci = luci;
	}
	
	public String getNome() {
		return nome;
	}
	
	public boolean equals(Area area){
		if(this.getNome().equals(area.nome))
			return true;
		return false;
	}
	
}
