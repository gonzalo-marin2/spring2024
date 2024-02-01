package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Libro;

public interface LibrosDao extends JpaRepository<Libro, Integer> {
	Libro findByTitulo(String titulo);
	List<Libro> findByAutor(String autor);
	
	//idTema ya no es un campo de la entidad libro, ahora es un objeto
	//por lo que necesita una query
	@Query("select l from Libro l where l.tema.idTema=?1")
	List<Libro> findByIdTema(int idTema);
	
	//heredados: findById(int isbn), findAll()
	
	//lista de libro por nombre de tema
	@Query("select l from Libro l where l.tema.tema=?1")//primer tema es el objeto y el segundo el objeto que contiene la propiedad
	List<Libro> findByTema(String tema);
}
