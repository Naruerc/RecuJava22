package DAO;

import java.util.HashMap;

import model.Identificable;
import model.Equipos;

public class EquiposDao implements Identificable, Dao<Equipos> {

	private HashMap<Integer, Equipos> equipos = new HashMap<Integer, Equipos>();

	//guardar
	public boolean guardar(Equipos equipo){
		equipos.put(equipo.getId(), equipo);
		return true;
	}

	//eliminar
	public boolean eliminar(Integer id){

		if (equipos.containsKey(id)){
			equipos.remove(id);
			return true;
		}

		return false;
	}

	//encontrar
	public Equipos encontrar(Integer id){

		if (id == null || id == 0){
			return null;
		}

		return equipos.get(id);
	}

	//devolver mapa
	public HashMap <Integer, Equipos> obtenerLista(){
		return equipos;
	}

	//mostrar
	public void mostrarTodos(){

		System.out.println("-------------------");
		System.out.println("Todos los equipos");
		System.out.println("-------------------");


		for (Equipos equipos : equipos.values()) {
			System.out.println(equipos.toString());
			System.out.println("-------------------");
		}
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
