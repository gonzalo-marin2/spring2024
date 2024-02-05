package service.interfaces;

import java.util.List;

import service.dtos.LibroDto;
import service.dtos.VentaDto;

public interface VentasService {
	List<VentaDto> informeVentasCliente(String usuario);
	
	void registrarCompra(String usuario, List<LibroDto> libros);
}
