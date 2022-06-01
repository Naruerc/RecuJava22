package model;

import java.util.HashMap;

public class DivisionesDao<T extends Identificable> implements Dao<T> {
	
private HashMap<Integer, T> divisiones = new HashMap<Integer, T>();
	
	public boolean guardar(T division){
		divisiones.put(division.getId(), division);
		return true;
	}

	public boolean eliminar(Integer id){

		if (divisiones.containsKey(id)){
			divisiones.remove(id);
			return true;
		}

		return false;
	}

	public T encontrar(Integer id){

		if (id == null || id == 0){
			return null;
		}

		return divisiones.get(id);
	}
	
	 public HashMap <Integer, T > obtenerLista(){
	        return divisiones;
	    }
	
	public void mostrarTodos(){

		System.out.println("-------------------");
		System.out.println("Todos los jugadores");
		System.out.println("-------------------");
		
		for (T jugadores : divisiones.values()) {
			jugadores.toString();
		    System.out.println("-------------------");
		}
	}

}

