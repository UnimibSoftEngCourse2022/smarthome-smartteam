package interfaccia_utente;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import database.GestoreAree;
import dominio.Area;

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
		String codice = "";
		int numeroErrori = 0;
		boolean codiceCorretto = false;
		while(numeroErrori<=3) {
			System.out.println("Inserisci il codice per spegnere l'allarme:");
			try {
				codice = tastiera.readLine();
			} catch (IOException e) {
				System.err.println("Errore avvenuto con l'inserimento del codice");
			}
			codiceCorretto = gestoreAree.spegniAllarme(codice);
			if(!codiceCorretto) {
				numeroErrori++;
				if(numeroErrori == 3) {
					List<Area> aree = gestoreAree.getAree();
					for(Area area : aree) {
						area.chiamaAllarme();
					}
					break;
				}
				System.out.println("Codice errato, tentativo numero: " + numeroErrori + " MAX 3 TENTATIVI!");
			}else {
				System.out.println("Allarme disattivato correttamente");
				break;
			}
		}
	}
}

