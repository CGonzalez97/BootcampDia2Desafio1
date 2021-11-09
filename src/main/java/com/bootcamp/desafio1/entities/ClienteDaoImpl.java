package com.bootcamp.desafio1.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDaoImpl implements ClienteDaoI{
	
	@Autowired
	EntityManager entityManager;

	@Override
	public Long insertarCliente(Cliente cliente) {
		Session session = entityManager.unwrap(Session.class);
		Long id =  (Long) session.save(cliente);
		session.close();
		return id;
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

	@Override
	@Transactional
	public void actualizarCliente(Cliente cliente) {
		Session session = entityManager.unwrap(Session.class);
		session.update(cliente);
		session.close();		
	}

	@Override
	public List<Cliente> buscarPorApellidos(String apellido1, String apellido2) {
		Session session = entityManager.unwrap(Session.class);
		List<Cliente> clientes = (List<Cliente>) session
		.createQuery("FROM Cliente WHERE PRIMER_APELLIDO='"+apellido1+"' AND SEGUNDO_APELLIDO='"+apellido2+"'")
		.list();
		session.close();
		return clientes;
	}

}
