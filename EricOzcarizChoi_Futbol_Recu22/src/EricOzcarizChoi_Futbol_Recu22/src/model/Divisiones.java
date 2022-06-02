package model;

import java.util.HashMap;

public class Divisiones implements Identificable {

	//atributos
	private int id;
	private String nombre;
	private String estatus;
	private Categoria categoria;
	private HashMap<Integer, Equipos> equipos = new HashMap<Integer, Equipos>();
	
	//constructores
	public Divisiones(int id, String nombre, String estatus, Categoria categoria, HashMap<Integer, Equipos> equipos) {
		this.id = id;
		this.nombre = nombre;
		this.estatus = estatus;
		this.categoria = categoria;
		this.equipos = equipos;
	}
	
	public Divisiones() {		
		this.id = 0;
		this.nombre = "";
		this.estatus = "";
		this.categoria = Categoria.PRIMERA;
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


	public String getEstatus() {
		return estatus;
	}


	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public HashMap<Integer, Equipos> getEquipos() {
		return equipos;
	}


	public void setEquipos(HashMap<Integer, Equipos> equipos) {
		this.equipos = equipos;
	}


	@Override
	public String toString() {
		return "Division [id=" + id + ", nombre=" + nombre + ", estatus=" + estatus + ", categoria=" + categoria
				+ ", equipos=" + equipos + "]";
	}
	
	
}
