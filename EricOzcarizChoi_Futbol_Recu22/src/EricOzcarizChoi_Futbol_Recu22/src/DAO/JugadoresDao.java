package DAO;

import java.util.HashMap;

import model.Identificable;
import model.Jugadores;

public class JugadoresDao implements Identificable, Dao<Jugadores> {

	private HashMap<Integer, Jugadores> jugadores = new HashMap<Integer, Jugadores>();

	//guardar
	public boolean guardar(Jugadores jugador){
		jugadores.put(jugador.getId(), jugador);
		return true;
	}

	//eliminar
	public boolean eliminar(Integer id){

		if (jugadores.containsKey(id)){
			jugadores.remove(id);
			return true;
		}

		return false;
	}

	//encontrar
	public Jugadores encontrar(Integer id){

		if (id == null || id == 0){
			return null;
		}

		return jugadores.get(id);
	}

	//devolver mapa
	public HashMap <Integer, Jugadores> obtenerLista(){
		return jugadores;
	}

	//mostrar
	public void mostrarTodos(){

		System.out.println("-------------------");
		System.out.println("Todos los jugadores");
		System.out.println("-------------------");


		for (Jugadores jugadores : jugadores.values()) {
			System.out.println(jugadores.toString());
			System.out.println("-------------------");
		}
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
