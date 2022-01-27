package com.ehp.empresa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehp.empresa.converters.EmpleadoConverter;
import com.ehp.empresa.entities.Empleado;
import com.ehp.empresa.models.EmpleadoModel;
import com.ehp.empresa.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private EmpleadoConverter empleadoConverter;
	
	public ArrayList<EmpleadoModel> getEmpleados() {
		List<Empleado> empleados = empleadoRepository.findAll();
		ArrayList<EmpleadoModel> empleadosModel = new ArrayList<>();
		for (Empleado empleado:empleados) {
			EmpleadoModel empleadoModel = empleadoConverter.entityToModel(empleado);
			empleadosModel.add(empleadoModel);
		}
		return empleadosModel;
	}
	
	public boolean addEmpleado(EmpleadoModel empleadoModel) {
		Empleado empleado = empleadoConverter.modelToEntity(empleadoModel);
		empleadoRepository.save(empleado);
		return true;
	}
}
