package com.bootcamp.desafio1;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bootcamp.desafio1.entities.Cliente;
import com.bootcamp.desafio1.entities.Contrato;
import com.bootcamp.desafio1.services.ClienteServiceImpl;
import com.bootcamp.desafio1.services.ContratoServiceImpl;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner {
	
	@Autowired
	public ClienteServiceImpl clienteService;
	
	@Autowired
	public ContratoServiceImpl contratoService;

	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		Cliente cliente1 = new Cliente("Manuel","Ramos","Ruiz","12345678A");
		Cliente cliente2 = new Cliente("María","Lozano","Gallego","23456789B");
		Cliente cliente3 = new Cliente("Pablo","Martín","Real","34567890C");
		
		Contrato contrato1 = new Contrato(Date.valueOf("2020-05-05"),Date.valueOf("2022-05-05"),57.0);
		Contrato contrato2 = new Contrato(Date.valueOf("2020-06-06"),Date.valueOf("2022-06-06"),66.0);
		cliente1.setContratos(new ArrayList<Contrato>());
		cliente1.addContrato(contrato1);
		cliente1.addContrato(contrato2);
		
		Long cliente1Id = clienteService.insertarCliente(cliente1);
		Long cliente2Id = clienteService.insertarCliente(cliente2);
		Long cliente3Id = clienteService.insertarCliente(cliente3);
		
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
		
		String nuevoNombre = "Alberto";
		System.out.println("Actualicemos el primer cliente, cambiando su nombre(Manuel) por "+nuevoNombre);
		cliente1 = clienteService.buscarClientePorId(cliente1Id);
		cliente1.setNombre(nuevoNombre);
		System.out.println(cliente1);
		clienteService.actualizarCliente(cliente1);
		System.out.println("Cliente modificado:"+clienteService.buscarClientePorId(cliente1Id));
		
		System.out.println("\nBuscar cliente por apellidos.");
		String apellido1 = cliente2.getPrimerApellido();
		String apellido2 = cliente2.getSegundoApellido();
		List<Cliente> listadoClientes = clienteService.buscarPorApellidos(apellido1,apellido2);
		for (Cliente cliente : listadoClientes) {
			System.out.println(cliente);
		}
		
	}

}
