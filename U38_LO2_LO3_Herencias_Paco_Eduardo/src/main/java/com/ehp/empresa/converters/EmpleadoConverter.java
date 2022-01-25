package com.ehp.empresa.converters;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ehp.empresa.entities.Empleado;
import com.ehp.empresa.entities.Tarea;
import com.ehp.empresa.models.EmpleadoModel;



@Component
public class EmpleadoConverter {
	
	//Conversor de entidad a modelo
	public EmpleadoModel entityToModel(Empleado empleado) {
		EmpleadoModel empleadoModel = new EmpleadoModel();
		empleadoModel.setEmail(empleado.getEmail());
		empleadoModel.setNombre(empleado.getNombre());
		empleadoModel.setApellidos(empleado.getApellidos());
		empleadoModel.setContraseña(empleado.getContraseña());
		empleadoModel.setTareas(empleado.getTareas());
		return empleadoModel;
	}
	
	//Conversor de modelo a entidad
	public Empleado modelToEntity (EmpleadoModel empleadoModel) {
		Empleado empleado = new Empleado();
		empleado.setEmail(empleadoModel.getEmail());
		empleado.setNombre(empleadoModel.getNombre());
		empleado.setApellidos(empleadoModel.getApellidos());
		empleado.setContraseña(empleadoModel.getContraseña());
		List<Tarea> tareas = null;
		empleado.setTareas(tareas);
		return empleado;
	}
}