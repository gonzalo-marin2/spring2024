package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Cliente;

public interface ClientesDao extends JpaRepository<Cliente,Integer> {
	 Cliente findByUsuarioAndPassword(String u, String p);
	 Cliente findByUsuario(String usuario);
	 //heredados:save(Cliente cliente)
}
