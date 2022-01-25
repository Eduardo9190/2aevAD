package com.ehp.empresa.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="tareas")
public class Tarea {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="titulo", length = 50)
	private String titulo;
	
	@Column(name="descripción", length = 500)
	private String descripcion;
	
	@Column(name="fecha_creacion")
	private Date fechaI;
	
	@Column(name="estado")
	private String estado;
	
	@ManyToOne(optional = false)
	@JsonBackReference
	private Empleado empleado;
	
	// Getters & Setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaI() {
		return fechaI;
	}

	public void setFechaI(Date fechaI) {
		this.fechaI = fechaI;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}
	
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
}