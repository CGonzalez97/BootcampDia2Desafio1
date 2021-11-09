package com.bootcamp.desafio1.entities;

import java.util.List;

public interface ContratoDaoI {
	
public Long insertarContrato(Contrato contrato);
	
	public List<Contrato> searchAll();
	
	public Contrato searchById(Long id);
	
	public void actualizarContrato(Contrato contrato);
	
	public void eliminarContrato(Contrato contrato);
	
	

}
