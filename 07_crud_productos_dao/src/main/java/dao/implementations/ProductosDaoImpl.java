package dao.implementations;

import java.util.List;

import org.springframework.stereotype.Repository;

import dao.interfaces.ProductosDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import model.Producto;

@Repository
public class ProductosDaoImpl implements ProductosDao {
	@PersistenceContext
	EntityManager em;
	@Transactional
	@Override
	public void save(Producto producto) {
		em.persist(producto);
	}

	@Override
	public Producto findByNombre(String nombre) {	
		String jpql="select p from Producto p where p.nombre=?1";
		TypedQuery<Producto> query=em.createQuery(jpql, Producto.class);
		query.setParameter(1, nombre);
		List<Producto> productos=query.getResultList();
		return productos.size()>0?productos.get(0):null;
	}

	@Override
	public List<Producto> findByCategoria(String categoria) {
		String jpql="select p from Producto p where p.categoria=?1";
		TypedQuery<Producto> query=em.createQuery(jpql, Producto.class);
		query.setParameter(1, categoria);
		return query.getResultList();
	}
	
	@Transactional
	@Override
	public void update(Producto producto) {
		em.merge(producto);
	}

	@Transactional
	@Override
	public void delete(Producto producto) {
		//el producto no está en el ámbito del entitymanager
		//por eso añadimos el find
		//em.remove(em.find(Producto.class, producto.getIdProducto()));
		em.remove(em.merge(producto));
	}

	@Transactional
	@Override
	public void deleteByNombre(String nombre) {
		String jpql="delete from Producto p where p.nombre=?1";
		Query query=em.createQuery(jpql);
		query.setParameter(1, nombre);
		query.executeUpdate();
	}

}
