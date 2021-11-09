package com.bootcamp.desafio1.services;

import java.util.List;

import com.bootcamp.desafio1.entities.Cliente;

public interface ClienteServiceI {
	
	public void insertarCliente(Cliente cliente);
	
	public List<Cliente> buscarClientes();
	
	public Cliente buscarClientePorId(Long id);

}
