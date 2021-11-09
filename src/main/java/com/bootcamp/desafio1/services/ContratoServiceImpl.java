package com.bootcamp.desafio1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.desafio1.entities.Contrato;
import com.bootcamp.desafio1.entities.ContratoDaoI;

@Service
public class ContratoServiceImpl implements ContratoServiceI {
	
	@Autowired
	ContratoDaoI contratoDao;

	@Override
	public Long insertarContratoe(Contrato contrato) {
		return contratoDao.insertarContrato(contrato);
	}

	@Override
	public List<Contrato> buscarContratos() {
		return contratoDao.searchAll();
	}

	@Override
	public Contrato buscarContratoPorId(Long id) {
		return contratoDao.searchById(id);
	}

	@Override
	public void actualizarContrato(Contrato contrato) {
		contratoDao.actualizarContrato(contrato);
	}

	@Override
	public void eliminarContrato(Contrato contrato) {
		contratoDao.eliminarContrato(contrato);
	}

}
