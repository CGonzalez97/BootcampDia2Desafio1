package com.bootcamp.desafio1.services;

import java.util.List;

import com.bootcamp.desafio1.entities.Contrato;

public interface ContratoServiceI {
	
	public Long insertarContratoe(Contrato contrato);
	
	public List<Contrato> buscarContratos();
	
	public Contrato buscarContratoPorId(Long id);
	
	public void actualizarContrato(Contrato contrato);
	
	public void eliminarContrato(Contrato contrato);

}
