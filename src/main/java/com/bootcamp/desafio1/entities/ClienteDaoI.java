package com.bootcamp.desafio1.entities;

import java.util.List;

public interface ClienteDaoI {
	
	public void insertarCliente(Cliente cliente);
	
	public List<Cliente> searchAll();
	
	public Cliente searchById(Long id);

}
