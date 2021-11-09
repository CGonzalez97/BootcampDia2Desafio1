package com.bootcamp.desafio1.services;

import java.util.List;

import com.bootcamp.desafio1.entities.Cliente;

public interface ClienteServiceI {
	
	public Long insertarCliente(Cliente cliente);
	
	public List<Cliente> buscarClientes();
	
	public Cliente buscarClientePorId(Long id);
	
	public void actualizarCliente(Cliente cliente);
	
	public List<Cliente>buscarPorApellidos(String apellido1, String apellido2);
	
	public void eliminarCliente(Cliente cliente);

}
