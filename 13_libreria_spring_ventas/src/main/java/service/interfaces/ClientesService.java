package service.interfaces;

import service.dtos.ClienteDto;

public interface ClientesService {
	ClienteDto autenticarUsuario(String usuario, String password);
	boolean altaCliente(ClienteDto cliente);
}
