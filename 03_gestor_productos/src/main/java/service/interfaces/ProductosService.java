package service.interfaces;

import java.util.List;

import model.Producto;

public interface ProductosService {
	void agregarProducto(Producto producto);
	List<Producto> buscarPorCategoria(String categoria);
	void eliminarProducto(String nombre);
}
