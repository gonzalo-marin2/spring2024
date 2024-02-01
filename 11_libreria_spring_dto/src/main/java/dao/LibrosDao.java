package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Libro;

public interface LibrosDao extends JpaRepository<Libro, Integer> {
	Libro findByTitulo(String titulo);
	List<Libro> findByAutor(String autor);
	List<Libro> findByIdTema(int idTema);
	//heredados: findById(int isbn), findAll()
}
