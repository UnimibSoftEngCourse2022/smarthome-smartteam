package interfacciaUtente;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import database.GestoreAree;

public class TerminaleIO {
	private BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
	private GestoreAree gestoreAree = GestoreAree.getIstanza();
	private static TerminaleIO istanza;
	
	
	public static TerminaleIO getIstanza() {
		if(istanza == null) {
			istanza = new TerminaleIO();
		}
		return istanza;
	}

	public void spegniAllarme() {
		System.out.println("Inserisci il codice per spegnere l'allarme:");
		String codice = "";
		try {
			codice = tastiera.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gestoreAree.spegniAllarme(codice);
	}

}
	
