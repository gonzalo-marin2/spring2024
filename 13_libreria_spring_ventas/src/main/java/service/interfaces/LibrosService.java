package service.interfaces;

import java.util.List;

import service.dtos.LibroDto;
import service.dtos.TemaDto;

public interface LibrosService {
	List<TemaDto> getTemas();
	List<LibroDto> librosTema(int idTema);
	LibroDto getLibro(int isbn);
	TemaDto getTema(int idTema);
}
