package com.bootcamp.desafio1.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONTRATO")
public class Contrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "FECHA_VIGENCIA")
	private Date fechaVigencia;
	
	@Column(name = "FECHA_CADUCIDAD")
	private Date fechaCaducidad;
	
	@Column(name = "PRECIO")
	private Double precioMensual;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Cliente cliente;

	public Contrato() {
		super();
	}

	public Contrato(Date fechaVigencia, Date fechaCaducidad, Double precioMensual, Cliente cliente) {
		super();
		this.fechaVigencia = fechaVigencia;
		this.fechaCaducidad = fechaCaducidad;
		this.precioMensual = precioMensual;
		this.cliente = cliente;
	}

	public Contrato(Long id, Date fechaVigencia, Date fechaCaducidad, Double precioMensual, Cliente cliente) {
		super();
		this.id = id;
		this.fechaVigencia = fechaVigencia;
		this.fechaCaducidad = fechaCaducidad;
		this.precioMensual = precioMensual;
		this.cliente = cliente;
	}
	

	public Contrato(Date fechaVigencia, Date fechaCaducidad, Double precioMensual) {
		super();
		this.fechaVigencia = fechaVigencia;
		this.fechaCaducidad = fechaCaducidad;
		this.precioMensual = precioMensual;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public Double getPrecioMensual() {
		return precioMensual;
	}

	public void setPrecioMensual(Double precioMensual) {
		this.precioMensual = precioMensual;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", fechaVigencia=" + fechaVigencia + ", fechaCaducidad=" + fechaCaducidad
				+ ", precioMensual=" + precioMensual + "]";
	}
	
	
}
