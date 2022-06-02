package DAO;

import java.util.HashMap;

//interfaz para declarar metodos base para el resto de DAO
public interface Dao<T> {
	public boolean guardar(T obj);
	public boolean eliminar (Integer id);
	public Object encontrar (Integer id);
	public HashMap<Integer, T> obtenerLista();
	public void mostrarTodos();
}
