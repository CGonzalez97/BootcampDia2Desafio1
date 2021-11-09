package com.bootcamp.desafio1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bootcamp.desafio1.entities.Cliente;
import com.bootcamp.desafio1.services.ClienteServiceImpl;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner {
	
	@Autowired
	public ClienteServiceImpl clienteService;

	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		Cliente cliente1 = new Cliente("Manuel","Ramos","Ruiz","12345678A");
		Cliente cliente2 = new Cliente("María","Lozano","Gallego","23456789B");
		Cliente cliente3 = new Cliente("Pablo","Martín","Real","34567890C");
		
		clienteService.insertarCliente(cliente1);
		clienteService.insertarCliente(cliente2);
		clienteService.insertarCliente(cliente3);
		
		System.out.println("Listado de clientes:");
		List<Cliente> listado = clienteService.buscarClientes();
		for (Cliente cliente : listado) {
			System.out.println(cliente);
		}
		
		
		System.out.println("\nBuscar ahora cada uno por su Id");
		for (Cliente cliente : listado) {
			Cliente buscado = clienteService.buscarClientePorId(cliente.getId());
			System.out.println(buscado);
		}
		
				
	}

}
