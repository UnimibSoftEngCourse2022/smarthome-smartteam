package controllers;

import java.util.List;

import dominio.Area;

public abstract class Sistema {
	
	List<Area> aree;
	
	protected Sistema(List<Area> aree) {
		this.aree = aree;
	}
	
	public abstract void start();
	
	public abstract void stop();
	
}
