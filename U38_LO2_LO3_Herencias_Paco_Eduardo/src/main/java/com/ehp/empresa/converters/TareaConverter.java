package com.ehp.empresa.converters;

import org.springframework.stereotype.Component;

import com.ehp.empresa.entities.Empleado;
import com.ehp.empresa.entities.Tarea;
import com.ehp.empresa.models.TareaModel;

@Component
public class TareaConverter {

	//Conversor de entidad a modelo
	public TareaModel entityToModel (Tarea tarea) {
		TareaModel tareaModel = new TareaModel();
		tareaModel.setId(tarea.getId());
		tareaModel.setTitulo(tarea.getTitulo());
		tareaModel.setDescripcion(tarea.getDescripcion());
		tareaModel.setFecha(tarea.getFechaI());
		tareaModel.setEstado(tarea.getEstado());
		return tareaModel;
	}
	
	//Conversor de modelo a entidad
	public Tarea modelToEntity (TareaModel tareaModel) {
		Tarea tarea = new Tarea();
		tarea.setId(tareaModel.getId());
		tarea.setTitulo(tareaModel.getTitulo());
		tarea.setDescripcion(tareaModel.getDescripcion());
		tarea.setFechaI(tareaModel.getFecha());
		tarea.setEstado(tareaModel.getEstado());
		Empleado empleado = new Empleado();
		tarea.setEmpleado(empleado);
		return tarea;
	}
}