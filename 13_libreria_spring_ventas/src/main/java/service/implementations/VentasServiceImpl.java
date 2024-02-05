package service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientesDao;
import dao.VentasDao;
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
	
	

}
