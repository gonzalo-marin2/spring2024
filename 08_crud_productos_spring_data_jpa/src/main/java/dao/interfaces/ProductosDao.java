package dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import jakarta.transaction.Transactional;
import model.Producto;

public interface ProductosDao extends JpaRepository<Producto, Integer> {
	Producto findByNombre(String nombre);
	List<Producto> findByCategoria(String categoria);
	@Transactional
	@Modifying
	void deleteByNombre(String nombre);
}
