package model;

import java.util.HashMap;

public class Jugadores implements Identificable {

	private int id;
	private String nombre;
	private int dorsal;
	private Posicion posicion;
	private int golesMarcados;
	private String nacionalidad;
	
	
	public Jugadores(int id, String nombre, int dorsal, Posicion posicion, int golesMarcados, String nacionalidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.posicion = posicion;
		this.golesMarcados = golesMarcados;
		this.nacionalidad = nacionalidad;
	}
	
	public Jugadores() {
		this.id = 0;
		this.nombre = "";
		this.dorsal = 0;
		this.posicion = Posicion.PORTERO;
		this.golesMarcados = 0;
		this.nacionalidad = "";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getDorsal() {
		return dorsal;
	}


	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}


	public Posicion getPosicion() {
		return posicion;
	}


	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}


	public int getGolesMarcados() {
		return golesMarcados;
	}


	public void setGolesMarcados(int golesMarcados) {
		this.golesMarcados = golesMarcados;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	@Override
	public String toString() {
		return "Jugadores [id=" + id + ", nombre=" + nombre + ", dorsal=" + dorsal + ", posicion=" + posicion
				+ ", golesMarcados=" + golesMarcados + ", nacionalidad=" + nacionalidad + "]";
	}
	
	
	
}
