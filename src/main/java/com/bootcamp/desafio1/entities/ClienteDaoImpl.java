package com.bootcamp.desafio1.entities;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDaoImpl implements ClienteDaoI{
	
	@Autowired
	EntityManager entityManager;

	@Override
	public void insertarCliente(Cliente cliente) {
		Session session = entityManager.unwrap(Session.class);
		session.save(cliente);
		session.close();
	}

	@Override
	public List<Cliente> searchAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Cliente> listado = session.createQuery("FROM Cliente").list();
		session.close();
		return listado;
	}

	@Override
	public Cliente searchById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Cliente cliente = (Cliente) session.createQuery("FROM Cliente WHERE id="+id).uniqueResult();
		session.close();
		return cliente;
	}

}
