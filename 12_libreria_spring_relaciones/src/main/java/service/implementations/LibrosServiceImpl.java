package service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LibrosDao;
import dao.TemasDao;
import model.Libro;
import service.dtos.LibroDto;
import service.dtos.TemaDto;
import service.interfaces.LibrosService;
import service.mappers.Mapeador;

@Service
public class LibrosServiceImpl implements LibrosService {

	@Autowired
	LibrosDao librosDao;
	@Autowired
	TemasDao temasDao;
	@Autowired
	Mapeador mapeador;
	
	@Override
	public List<TemaDto> getTemas() {
		return temasDao.findAll()
				.stream()
				.map(e->mapeador.temaEntityToDto(e))
				.toList();
	}

	@Override
	public List<LibroDto> librosTema(int idTema) {
		if(idTema==0) {
			return librosDao.findAll()
					.stream()
					.map(e->mapeador.libroEntityToDto(e))
					.toList();
			}
		return librosDao.findByIdTema(idTema)
				.stream()
				.map(e->mapeador.libroEntityToDto(e))
				.toList();
	}

	@Override
	public LibroDto getLibro(int isbn) {
		//el método finfById devuelve un Optional
		Optional<Libro> resultado=librosDao.findById(isbn);
		//return resultado.isPresent()?resultado.get():null;
		return resultado
				.map(l->mapeador.libroEntityToDto(l))//Optional de libroDto
				.orElse(null);
	}

	@Override
	public TemaDto getTema(int idTema) {
		//igual que el anterior pero sin variable
		return temasDao.findById(idTema)
				.map(t->mapeador.temaEntityToDto(t))
				.orElse(null);
	}

}
