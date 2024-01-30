package dao.interfaces;

import java.util.List;

import model.Producto;

public interface ProductosDao {
	void save(Producto producto);
	Producto findByNombre(String nombre);
	List<Producto> findByCategoria(String categoria);
	void update(Producto producto);
	void delete(Producto producto);
	void deleteByNombre(String nombre);
}
