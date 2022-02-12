package com.ehp.empresa.models;

import java.sql.Date;

public class TareaModel {
	
	private long id;
	private String titulo;
	private String estado;
	private Date fecha;
	private String descripcion;
	private EmpleadoModel empleadoModel;
	// Getters & Setters
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public EmpleadoModel getEmpleadoModel() {
		return empleadoModel;
	}
	public void setEmpleadoModel(EmpleadoModel empleadoModel) {
		this.empleadoModel = empleadoModel;
	}
	
	// Validations
	public boolean validation(TareaModel tm) {
		if (titulo.isBlank() || descripcion.isBlank() || estado.isBlank()) {
			return false;
		}
		return true;
	}
}
