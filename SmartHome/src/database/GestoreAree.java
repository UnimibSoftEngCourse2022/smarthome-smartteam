package database;

import dominio.Area;
import java.util.List;
import java.util.ArrayList;

public class GestoreAree {

    private List<Area> aree;
	private static GestoreAree istanza;
	private boolean allarmeAcceso = true;
	private String codice = "0123";
    

	public static GestoreAree getIstanza(){
        if(istanza == null){
            istanza = new GestoreAree();
        }
        return istanza;
    }

    public boolean isAllarmeAcceso() {
		return allarmeAcceso;
	}

	public GestoreAree(){
    	aree = new ArrayList<>();
    }

    
    public List<Area> getAree() {
		return aree;
	}
    
    
    public void aggiungiArea(Area area){
        for(int i = 0; i < aree.size(); i++){
            if(aree.get(i) != null && aree.get(i).equals(area)){
                return;
            }
        }
        aree.add(area);        
    }

    public void rimuoviArea(Area area){
        for(int i = 0; i < aree.size(); i++){
            if(aree.get(i).equals(area)){
                aree.remove(i);
            }
        }
    } 

    public Area getArea(String nomeArea){
        for(int i = 0; i < aree.size(); i++){
            if(aree.get(i).getNome().equals(nomeArea)){
                return aree.get(i);
            }
        }
        return null;
    }

	public boolean spegniAllarme(String codice) {
		if(this.codice.equals(codice)) {
			for(Area area : aree) {
				area.spegniAllarme();
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public void accendiAllarme() {
			allarmeAcceso = true;
	}
    
    
}