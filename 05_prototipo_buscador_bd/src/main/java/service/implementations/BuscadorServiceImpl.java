package service.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import model.Resultado;
import service.interfaces.BuscadorService;

@Service
public class BuscadorServiceImpl implements BuscadorService { 
	@PersistenceContext//para inyectar el EntityManager
	EntityManager em;
	
	@Override
	public List<Resultado> buscar(String tematica) {
		String jpql="select r from Resultado r where r.tematica=?1";
		TypedQuery<Resultado> query=em.createQuery(jpql, Resultado.class);
		query.setParameter(1, tematica);
		return query.getResultList();
	}
	
	@Transactional//para que spring inicia y confirme la transacción automáticamente
	@Override
	public void agregar(Resultado resultado) {
		em.persist(resultado);		
	}
	
	

}
