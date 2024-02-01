package service.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Cliente;
import model.Libro;
import model.Tema;
import service.dtos.ClienteDto;
import service.dtos.LibroDto;
import service.dtos.TemaDto;
import service.implementations.LibrosServiceImpl;
import service.interfaces.LibrosService;
@Component
public class Mapeador {
	@Autowired
	LibrosService service;
	public TemaDto temaEntityToDto(Tema tema) {
		return new TemaDto(tema.getIdTema(), tema.getTema());
	}
	
	public LibroDto libroEntityToDto(Libro libro) {
		return new LibroDto(libro.getIsbn(),
				libro.getTitulo(),
				libro.getAutor(),
				libro.getPrecio(),
				libro.getPaginas(),
				service.getTema(libro.getIdTema()));
	}
	
	public ClienteDto clienteEntityToDto(Cliente cliente) {
		return cliente!=null?new ClienteDto(
				cliente.getUsuario(),
				cliente.getPassword(),
				cliente.getEmail(),
				cliente.getTelefono()):null;
	}
	
	public Cliente clienteDtoToEntity(ClienteDto cliente) {
		return new Cliente(0,
				cliente.getUsuario(),
				cliente.getPassword(),
				cliente.getEmail(),
				cliente.getTelefono());
	}
}
