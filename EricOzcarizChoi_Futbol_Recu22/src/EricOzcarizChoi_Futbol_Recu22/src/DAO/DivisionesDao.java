package DAO;

import java.util.HashMap;

import model.Identificable;
import model.Divisiones;

public class DivisionesDao implements Identificable, Dao<Divisiones> {

	private HashMap<Integer, Divisiones> divisiones = new HashMap<Integer, Divisiones>();

	//guardar
	public boolean guardar(Divisiones division){
		divisiones.put(division.getId(), division);
		return true;
	}

	//eliminar
	public boolean eliminar(Integer id){

		if (divisiones.containsKey(id)){
			divisiones.remove(id);
			return true;
		}

		return false;
	}

	//encontrar
	public Divisiones encontrar(Integer id){

		if (id == null || id == 0){
			return null;
		}

		return divisiones.get(id);
	}

	//devolver mapa
	public HashMap <Integer, Divisiones> obtenerLista(){
		return divisiones;
	}

	//mostrar
	public void mostrarTodos(){

		System.out.println("-------------------");
		System.out.println("Todas las divisiones");
		System.out.println("-------------------");


		for (Divisiones divisiones : divisiones.values()) {
			System.out.println(divisiones.toString());
			System.out.println("-------------------");
		}
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
