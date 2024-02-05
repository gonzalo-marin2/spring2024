package service.mappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Cliente;
import model.Libro;
import model.Tema;
import model.Venta;
import service.dtos.ClienteDto;
import service.dtos.LibroDto;
import service.dtos.TemaDto;
import service.dtos.VentaDto;
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
				service.getTema(libro.getTema().getIdTema()));
		//hemos llamado al constructor para que nos dé el idTema
	}
	
	public Libro libroDtoToEntity(LibroDto libro) {
		return new Libro(libro.getIsbn(),
				libro.getTitulo(),
				libro.getAutor(),
				libro.getPrecio(),
				libro.getPaginas(),null);//como no necesitamos el tema, lo ponemos null
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
				cliente.getTelefono(),
				null);//no necesitamos proporcionar las ventas del cliente para crear el ClienteDto
	}
	
	public VentaDto ventaEntityToDto(Venta venta) {
		return new VentaDto(
				venta.getIdVenta(),
				venta.getCliente().getUsuario(),
				venta.getLibro().getTitulo(),
				convertirDateALocalDate(venta.getFecha())
				);
	}
	
	public LocalDate convertirDateALocalDate(Date date) {
		//return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		 return Instant.ofEpochMilli(date.getTime())
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
		
	}
}
