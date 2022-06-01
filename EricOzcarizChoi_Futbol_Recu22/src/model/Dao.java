package model;

import java.util.HashMap;

public interface Dao<T> {

	public boolean guardar(T obj);
	public boolean eliminar (Integer id);
	public Object encontrar (Integer id);
	public HashMap<Integer, T> obtenerLista();
	public void mostrarTodos();
}
