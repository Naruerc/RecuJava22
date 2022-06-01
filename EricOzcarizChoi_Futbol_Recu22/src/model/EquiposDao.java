package model;

import java.util.HashMap;

public class EquiposDao<T extends Identificable> implements Dao<T> {
	
private HashMap<Integer, T> equipos = new HashMap<Integer, T>();
	
	public boolean guardar(T equipo){
		equipos.put(equipo.getId(), equipo);
		return true;
	}

	public boolean eliminar(Integer id){

		if (equipos.containsKey(id)){
			equipos.remove(id);
			return true;
		}

		return false;
	}

	public T encontrar(Integer id){

		if (id == null || id == 0){
			return null;
		}

		return equipos.get(id);
	}
	
	 public HashMap <Integer, T > obtenerLista(){
	        return equipos;
	    }
	
	public void mostrarTodos(){

		System.out.println("-------------------");
		System.out.println("Todos los equipos");
		System.out.println("-------------------");
		
		for (T jugadores : equipos.values()) {
			jugadores.toString();
		    System.out.println("-------------------");
		}
	}

}
