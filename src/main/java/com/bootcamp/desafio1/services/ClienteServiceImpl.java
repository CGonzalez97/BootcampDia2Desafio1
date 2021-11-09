package com.bootcamp.desafio1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.desafio1.entities.Cliente;
import com.bootcamp.desafio1.entities.ClienteDaoI;

@Service
public class ClienteServiceImpl implements ClienteServiceI {
	
	@Autowired
	ClienteDaoI clienteDao;

	@Override
	public Long insertarCliente(Cliente cliente) {
		return clienteDao.insertarCliente(cliente);		
	}

	@Override
	public List<Cliente> buscarClientes() {
		return clienteDao.searchAll();
	}

	@Override
	public Cliente buscarClientePorId(Long id) {
		return clienteDao.searchById(id);
	}

	@Override
	public void actualizarCliente(Cliente cliente) {
		clienteDao.actualizarCliente(cliente);		
	}

	@Override
	public List<Cliente> buscarPorApellidos(String apellido1, String apellido2) {
		return clienteDao.buscarPorApellidos(apellido1, apellido2);		
	}
	
	

}
