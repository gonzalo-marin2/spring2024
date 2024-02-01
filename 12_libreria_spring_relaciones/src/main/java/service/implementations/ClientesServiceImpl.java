package service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientesDao;
import model.Cliente;
import service.dtos.ClienteDto;
import service.interfaces.ClientesService;
import service.mappers.Mapeador;

@Service
public class ClientesServiceImpl implements ClientesService {

	@Autowired
	ClientesDao clientesDao;
	@Autowired
	Mapeador mapeador;
	
	@Override
	public ClienteDto autenticarUsuario(String usuario, String password) {
		Cliente cliente=clientesDao.findByUsuarioAndPassword(usuario, password);
		return cliente!=null?mapeador.clienteEntityToDto(cliente):null;
		
		
	}

	@Override
	public boolean altaCliente(ClienteDto cliente) {
		if(clientesDao.findByUsuario(cliente.getUsuario())==null) {
			clientesDao.save(mapeador.clienteDtoToEntity(cliente));
			return true;
		}
		return false;
	}


}
