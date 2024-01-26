package service.implementations;

import java.util.ArrayList;
import java.util.List;

import model.Producto;
import service.interfaces.ProductosService;

public class ProductosServiceImpl implements ProductosService {
	
	private static List<Producto> productos=new ArrayList<>();
	
	@Override
	public void agregarProducto(String nombre, double precio, String categoria) {
		productos.add(new Producto(nombre,precio,categoria));
	}

	@Override
	public List<Producto> buscarPorCategoria(String categoria) {
		return productos.stream()
			.filter(p->p.getCategoria().equals(categoria))
			.toList();
	}

	@Override
	public void eliminarProducto(String nombre) {
		productos.removeIf(p->p.getNombre().equals(nombre));
	}

}
