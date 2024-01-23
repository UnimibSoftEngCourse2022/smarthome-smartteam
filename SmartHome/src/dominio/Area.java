package dominio;

import java.util.List;

import database.GestoreAree;
import fr.liglab.adele.icasa.device.button.PushButton;
import fr.liglab.adele.icasa.device.doorWindow.DoorWindowSensor;
import fr.liglab.adele.icasa.device.gasSensor.CarbonDioxydeSensor;
import fr.liglab.adele.icasa.device.light.BinaryLight;
import fr.liglab.adele.icasa.device.light.Photometer;
import fr.liglab.adele.icasa.device.presence.PresenceSensor;
import fr.liglab.adele.icasa.device.security.Siren;
import fr.liglab.adele.icasa.device.sprinkler.Sprinkler;
import fr.liglab.adele.icasa.device.temperature.Cooler;
import fr.liglab.adele.icasa.device.temperature.Heater;
import fr.liglab.adele.icasa.device.security.Camera;
import fr.liglab.adele.icasa.device.security.FloodSensor;

public class Area {
	
	private String nome;
	private PresenceSensor sensorePresenza;
	private Photometer fotometro;
	private List<BinaryLight> luci;
	private CarbonDioxydeSensor rilevatoreCO2;
	private List<Sprinkler> sprinklers;
	private List<Siren> sirene;
	private FloodSensor sensoreAllagamento;
	private List<Heater> caloriferi;
	private List<Cooler> condizionatori;
	private double tempMinima = 296.5;
    private double tempMassima = 299.5;
	private Termostato termostato;
	private List<Camera> telecamere;
	private DoorWindowSensor sensorePorteFinestre;
	private PushButton pulsanteAllarme;
	private PushButton pulsanteTemperatura;
	private PushButton pulsanteLuci;
	
	// variabile che assume il valore true solo se tutte le luci sono accese
	private boolean luciAccese = false;
	
	public Area(AreaBuilder builder) {
		this.nome = builder.nome;
		this.sensorePresenza = builder.sensorePresenza;
		this.fotometro = builder.fotometro;
		this.luci = builder.luci;
		this.rilevatoreCO2 = builder.rilevatoreCO2;
		this.sprinklers = builder.sprinklers;
		this.sirene = builder.sirene;
		this.sensoreAllagamento = builder.sensoreAllagamento;
		this.caloriferi = builder.caloriferi;
		this.condizionatori = builder.condizionatori;
		this.termostato = builder.termostato;
		this.telecamere = builder.telecamere;
		this.sensorePorteFinestre = builder.sensorePorteFinestre;
		this.pulsanteAllarme = builder.pulsanteAllarme;
		this.pulsanteTemperatura = builder.pulsanteTemperatura;
		this.pulsanteLuci = builder.pulsanteLuci;
	}
	
	public boolean isLuciAccese() {
		return luciAccese;
	}
	
	public Termostato getTermostato() {
		return termostato;
	}

	
	public List<Camera> getTelecamere() {
		return telecamere;
	}


	public DoorWindowSensor getSensorePorteFinestre() {
		return sensorePorteFinestre;
	}


	public double getTempMinima() {
		return tempMinima;
	}

	

	public double getTempMassima() {
		return tempMassima;
	}
	


	public FloodSensor getSensoreAllagamento() {
		return sensoreAllagamento;
	}


	public CarbonDioxydeSensor getRilevatoreCO2() {
		return rilevatoreCO2;
	}


	public PresenceSensor getSensorePresenza() {
		return sensorePresenza;
	}


	public String getNome() {
		return nome;
	}


	public Photometer getFotometro() {
		return fotometro;
	}
	
	
	public PushButton getPulsanteAllarme() {
		return pulsanteAllarme;
	}
	
	
	public PushButton getPulsanteTemperatura() {
		return pulsanteTemperatura;
	}

	
	public PushButton getPulsanteLuci() {
		return pulsanteLuci;
	}
	
	public void setTermostato(Termostato termostato) {
		this.termostato = termostato;
	}
	
	public void setTempMinima(double tempMinima) {
		this.tempMinima = tempMinima;
	}
	
	
	public void setTempMassima(double tempMassima) {
		this.tempMassima = tempMassima;
	}
	
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Area other = (Area) obj;
        return nome.equals(other.nome);
    }
	
	
	public void chiamaAllarme() {
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		List<Area> aree = gestoreAree.getAree();
		if(gestoreAree.isAllarmeAcceso()) {
			for(Area area : aree) {
				List<Camera> telecamereArea = area.getTelecamere();
				for(Camera telecamera : telecamereArea) {
					telecamera.startRecording();
				}
			}
			for(Siren sirena : sirene) {
				sirena.turnOn();
				System.out.println("E' ENTRATO QUALCUNO IN " + this.nome.toUpperCase());
			}
		}
	}


	public void spegniAllarme() {
		GestoreAree gestoreAree = GestoreAree.getIstanza();
		List<Area> aree = gestoreAree.getAree();
		for(Area area : aree) {
			List<Camera> telecamereArea = area.getTelecamere();
			for(Camera telecamera : telecamereArea) {
				telecamera.stopRecording();
			}
		}
		for(Siren sirena : sirene) {
			sirena.turnOff();
		}
		System.out.println("Allarme disattivato in " + this.nome);
	}

	public void accendiLuci() {
		for (int i = 0; i < luci.size(); i++) {
			luci.get(i).turnOn();
		}
		luciAccese = true;
	}
	
	
	public void accendiSprinklers() {
		for (int i = 0; i < sprinklers.size(); i++) {
			sprinklers.get(i).turnOn();
		}
	}
	
	
	public void accendiSirene() {
		for (int i = 0; i < sirene.size(); i++) {
			sirene.get(i).turnOn();
		}
	}
	
	
	public void accendiCaloriferi() {
		for(Heater calorifero : caloriferi) {
			calorifero.setPowerLevel(1);
		}
	}
	
	
	public void accendiCondizionatori() {
		for(Cooler condizionatore : condizionatori) {
			condizionatore.setPowerLevel(1);
		}
	}
	
	
	public void spegniLuci() {
		for(int i = 0; i < luci.size(); i++){
			luci.get(i).turnOff();
		}
		luciAccese = false;
	}

	
	public void spegniSprinklers() {
		for (int i = 0; i < sprinklers.size(); i++) {
			sprinklers.get(i).turnOff();
		}
	}
	
	
	public void spegniSirene() {
		for(int i = 0; i < sirene.size(); i++){
			sirene.get(i).turnOff();
		}
	}
	
	
	public void spegniCaloriferi() {
		for(Heater calorifero : caloriferi) {
			calorifero.setPowerLevel(0);
		}
	}
	
	
	public void spegniCondizionatori() {
		for(Cooler condizionatore : condizionatori) {
			condizionatore.setPowerLevel(0);
		}
	}
	

}
