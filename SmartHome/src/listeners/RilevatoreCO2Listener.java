package listeners;


import dominio.Area;
import fr.liglab.adele.icasa.device.GenericDevice;
import fr.liglab.adele.icasa.device.gasSensor.CarbonDioxydeSensor;

public class RilevatoreCO2Listener extends GenericListener{

	@Override
	public boolean verificaTipologiaDispositivo(GenericDevice dispositivo) {
		return dispositivo instanceof CarbonDioxydeSensor;
	}

	@Override
	public void gestisciEvento(GenericDevice dispositivo, Area areaInteressata, String nomeProprieta, Object vecchioValore, Object nuovoValore) {
		CarbonDioxydeSensor rilevatoreCO2 = (CarbonDioxydeSensor) dispositivo;
		double concentrazioneCO2 = rilevatoreCO2.getCO2Concentration();
		
		if(concentrazioneCO2 >= 2) {
			// allarme
			areaInteressata.accendiSirene();
			System.out.println("CONCENTRAZIONE DI ANIDRIDE CARBONICA OLTRE I PARAMETRI ACCETTABILI IN " + areaInteressata.getNome().toUpperCase() + "!!!");
			
			if(concentrazioneCO2 > 500) {
				//attivazione sprinkler
				areaInteressata.accendiSprinklers();
				System.out.println("SISTEMA ANTINCENDIO ATTIVATO IN " + areaInteressata.getNome().toUpperCase() + "!!!");
			}
			else if((double) vecchioValore > 500){
				areaInteressata.spegniSprinklers();
				System.out.println("INCENDIO IN " + areaInteressata.getNome().toUpperCase() + " DOMATO!");
			}
		}
		else {
			if((double) vecchioValore > 1) {
				System.out.println("CONCENTRAZIONE DI ANIDRIDE CARBONICA IN " + areaInteressata.getNome().toUpperCase() + " RIENTRATA NEI PARAMETRI ACCETTABILI");
				if((double) vecchioValore > 500.0) {
					areaInteressata.spegniSprinklers();
					System.out.println("INCENDIO IN " + areaInteressata.getNome().toUpperCase() + " DOMATO!");
				}
				areaInteressata.spegniSirene();
			}
		}
		
	}
	 
}
