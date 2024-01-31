package service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LibrosDao;
import dao.TemasDao;
import model.Libro;
import model.Tema;
import service.interfaces.LibrosService;

@Service
public class LibrosServiceImpl implements LibrosService {

	@Autowired
	LibrosDao librosDao;
	
	@Autowired
	TemasDao temasDao;
	
	@Override
	public List<Tema> getTemas() {
		return temasDao.findAll();
	}

	@Override
	public List<Libro> librosTema(int idTema) {
		if(idTema==0) {
			return librosDao.findAll();
			}
		return librosDao.findByIdTema(idTema);
	}

	@Override
	public Libro getLibro(int isbn) {
		//el método finfById devuelve un Optional
		Optional<Libro> resultado=librosDao.findById(isbn);
		//return resultado.isPresent()?resultado.get():null;
		return resultado.orElse(null);
	}

	@Override
	public Tema getTema(int idTema) {
		//igual que el anterior pero sin variable
		return temasDao.findById(idTema).orElse(null);
	}

}
