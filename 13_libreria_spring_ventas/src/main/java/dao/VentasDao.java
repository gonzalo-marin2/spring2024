package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Venta;

public interface VentasDao extends JpaRepository<Venta,Integer> {
	List<Venta> findByClienteIdCliente(int idCliente);
	//findByClienteIdCliente Cliente es la entidad y idCliente es la propiedad
	List<Venta> findByFechaBetween(Date f1, Date f2);
	
	//la query no es necesaria, se pone por claridad
	@Query("select v from Venta v where v.libro.isbn=?1")
	List<Venta> findByLibroIsbn(int isbn);
}
