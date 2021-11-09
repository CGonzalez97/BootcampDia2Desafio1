package com.bootcamp.desafio1.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContratoDaoImpl implements ContratoDaoI {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public Long insertarContrato(Contrato contrato) {
		Session session = entityManager.unwrap(Session.class);
		Long id =  (Long) session.save(contrato);
		session.close();
		return id;
	}

	@Override
	public List<Contrato> searchAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Contrato> listado = session.createQuery("FROM Contrato").list();
		session.close();
		return listado;
	}

	@Override
	public Contrato searchById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Contrato contrato = (Contrato) session.createQuery("FROM Contrato WHERE id="+id).uniqueResult();
		session.close();
		return contrato;
	}

	@Override
	@Transactional
	public void actualizarContrato(Contrato contrato) {
		Session session = entityManager.unwrap(Session.class);
		session.merge(contrato);
		session.close();
	}

	@Override
	@Transactional
	public void eliminarContrato(Contrato contrato) {
		entityManager.remove(entityManager.merge(contrato));			
	}
	
	

}
