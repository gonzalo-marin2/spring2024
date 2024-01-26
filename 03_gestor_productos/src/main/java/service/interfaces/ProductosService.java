package service.interfaces;

import java.util.List;

import model.Producto;

public interface ProductosService {
	void agregarProducto(String nombre, double precio, String categoria);
	List<Producto> buscarPorCategoria(String categoria);
	void eliminarProducto(String nombre);
}
