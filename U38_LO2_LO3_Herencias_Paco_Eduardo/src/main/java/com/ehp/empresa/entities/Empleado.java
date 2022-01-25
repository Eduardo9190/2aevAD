package com.ehp.empresa.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="empleados")
public class Empleado {
	
	@Id
	@Column(name="email", length = 50)
	private String email;
	
	@Column(name="nombre", length = 30)
	private String nombre;
	
	@Column(name="apellidos", length = 100)
	private String apellidos;
	
	@Column(name="password")
	private String contraseña;
	
	@OneToMany(mappedBy = "empleado")
	@JsonManagedReference
	private List<Tarea> tareas;
	
	// Getters & Setters

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}
}
