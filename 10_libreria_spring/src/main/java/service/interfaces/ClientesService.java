package service.interfaces;

import model.Cliente;

public interface ClientesService {
	Cliente autenticarUsuario(String usuario, String password);
	boolean altaCliente(Cliente cliente);
}
