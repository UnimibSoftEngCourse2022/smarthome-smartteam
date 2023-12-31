package database;

import dominio.Area;
import java.util.List;
import java.util.ArrayList;

public class GestoreAree {

    private List<Area> aree;
    private static GestoreAree istanza;

    public static GestoreAree getIstanza(){
        if(istanza == null){
            istanza = new GestoreAree();
        }
        return istanza;
    }

    public GestoreAree(){
    	aree = new ArrayList<Area>();
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
    
}