package service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.interfaces.ProductosDao;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import model.Producto;
import service.interfaces.ProductosService;

@Service
public class ProductosServiceImpl implements ProductosService {
	@Autowired
	ProductosDao productosDao;

	@Override
	public boolean agregarProducto(Producto producto) {
		if(productosDao.findByNombre(producto.getNombre())!=null) {
			return false;
		}
		productosDao.save(producto);
		return true;	
	}

	@Override
	public List<Producto> buscarPorCategoria(String categoria) {
		return productosDao.findByCategoria(categoria);
	}

	@Override
	public void modificarPrecio(String nombre, double nuevoPrecio) {
		Producto prod=productosDao.findByNombre(nombre);
		if(prod!=null) {
			prod.setPrecio(nuevoPrecio);
			productosDao.save(prod);
		}
	}

	@Override
	public Producto eliminarProducto(String nombre) {
		Producto prod=productosDao.findByNombre(nombre);
		if(prod==null) {
			return null;
		}
		//productosDao.delete(prod);
		productosDao.deleteByNombre(nombre);
		return prod;
	}

	@Override
	public List<Producto> todos() {
		return productosDao.findAll();
	}
	
	
	
}
