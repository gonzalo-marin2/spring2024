package service.implementations;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientesDao;
import dao.VentasDao;
import model.Cliente;
import model.Venta;
import service.dtos.LibroDto;
import service.dtos.VentaDto;
import service.interfaces.VentasService;
import service.mappers.Mapeador;

@Service
public class VentasServiceImpl implements VentasService {
	@Autowired
	VentasDao ventasDao;
	@Autowired
	ClientesDao clientesDao;
	@Autowired
	Mapeador mapeador;

	@Override
	public List<VentaDto> informeVentasCliente(String usuario) {
		return ventasDao.findByClienteIdCliente(clientesDao.findByUsuario(usuario).getIdCliente())
				.stream()
				.map(v->mapeador.ventaEntityToDto(v))
				.toList();
	}

	@Override
	public void registrarCompra(String usuario, List<LibroDto> libros) {
		Cliente cliente=clientesDao.findByUsuario(usuario);
		for(LibroDto dto:libros) {
			Venta venta=new Venta(0, new Date(), cliente, mapeador.libroDtoToEntity(dto));
			ventasDao.save(venta);
		}
		
	}
	
	

}
