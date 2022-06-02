package model;

import java.util.HashMap;

public class Equipos implements Identificable {

	//atributos
	private int id;
	private String nombre;
	private HashMap<Integer, Jugadores> jugadores = new HashMap<Integer, Jugadores>();
	private int victorias;
	private int derrotas;
	
	//constructores
	public Equipos(int id, String nombre, HashMap<Integer, Jugadores> jugadores, int victorias, int derrotas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.jugadores = jugadores;
		this.victorias = victorias;
		this.derrotas = derrotas;
	}
	
	public Equipos() {
		this.id = 0;
		this.nombre = "";		
		this.victorias = 0;
		this.derrotas = 0;
	}

	//getters and setters
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


	public HashMap<Integer, Jugadores> getJugadores() {
		return jugadores;
	}


	public void setJugadores(HashMap<Integer, Jugadores> jugadores) {
		this.jugadores = jugadores;
	}


	public int getVictorias() {
		return victorias;
	}


	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}


	public int getDerrotas() {
		return derrotas;
	}


	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}


	@Override
	public String toString() {
		return "Equipos [id=" + id + ", nombre=" + nombre + ", jugadores=" + jugadores + ", victorias=" + victorias
				+ ", derrotas=" + derrotas + "]";
	}
	
	
 
}
