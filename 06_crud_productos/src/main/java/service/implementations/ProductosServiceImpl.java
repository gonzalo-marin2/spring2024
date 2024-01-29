package service.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import model.Producto;
import service.interfaces.ProductosService;

@Service
public class ProductosServiceImpl implements ProductosService {

	@PersistenceContext
	EntityManager em;
	
	private Producto buscarPorNombre(String nombre) {	
		return em.find(Producto.class, nombre);
	}
	
	@Transactional
	@Override
	public boolean agregarProducto(Producto producto) {
		Producto pr=buscarPorNombre(producto.getNombre());
		if(pr!=null) {
			return false;
		}else {
			em.persist(pr);
			return true;
		}	
	}

	@Override
	public List<Producto> buscarPorCategoria(String categoria) {
		String jpql="select p from Producto p where p.categoria=?1";
		TypedQuery<Producto> query=em.createQuery(jpql, Producto.class);
		query.setParameter(1, categoria);
		return query.getResultList();
	}

	@Transactional
	@Override
	public void modificarPrecio(String nombre, double nuevoPrecio) {
		/*String jpql="update Producto p set p.precio=?1 where p.nombre=?2";
		Query query=em.createQuery(jpql);
		query.setParameter(1, nuevoPrecio);
		query.setParameter(2, nombre);
		query.executeUpdate();*/
		
		Producto producto=buscarPorNombre(nombre);
		if(producto!=null) {
			producto.setPrecio(nuevoPrecio);
			em.merge(producto);
		}
	}

	@Transactional
	@Override
	public Producto eliminarProducto(String nombre) {
		Producto pr=buscarPorNombre(nombre);
		if(pr.getNombre().equals(nombre)) {
			String jpql="delete p from Producto p where p.nombre=?1";
			Query query=em.createQuery(jpql);
			query.setParameter(1, nombre);
			query.executeUpdate();
			return pr;
		}else {
			return null;
		}
	}
	
}
