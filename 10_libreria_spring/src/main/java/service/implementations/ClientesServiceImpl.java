package service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientesDao;
import model.Cliente;
import service.interfaces.ClientesService;

@Service
public class ClientesServiceImpl implements ClientesService {

	@Autowired
	ClientesDao clientesDao;
	
	@Override
	public Cliente autenticarUsuario(String usuario, String password) {
		return clientesDao.findByUsuarioAndPassword(usuario, password);
	}

	@Override
	public boolean altaCliente(Cliente cliente) {
		if(clientesDao.findByUsuario(cliente.getUsuario())==null) {
			clientesDao.save(cliente);
			return true;
		}
		return false;
	}

}
