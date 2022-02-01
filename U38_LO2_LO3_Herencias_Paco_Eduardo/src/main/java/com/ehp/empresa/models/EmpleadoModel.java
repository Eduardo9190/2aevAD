package com.ehp.empresa.models;

import java.util.List;

import com.ehp.empresa.entities.Tarea;

public class EmpleadoModel {
	
	private String email, nombre, apellidos, contraseña;
	private List<TareaModel> tareas;
	
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
	public List<TareaModel> getTareas() {
		return tareas;
	}
	public void setTareas(List<TareaModel> tareas) {
		this.tareas = tareas;
	}
	
	public EmpleadoModel getDatos() {
		EmpleadoModel eM = new EmpleadoModel();
		eM.setEmail(email);
		eM.setNombre(nombre);
		eM.setApellidos(apellidos);
		eM.setContraseña("**************");
		eM.setTareas(tareas);
		return eM;
	}
	
	public boolean validation(EmpleadoModel em) {
		if (email.isBlank() || nombre.isBlank() || apellidos.isBlank() || contraseña.isBlank()) {
			return false;
		}
		return true;
	}
}