package com.ehp.empresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ehp.empresa.errors.BadRequestException;
import com.ehp.empresa.errors.NotFoundException;
import com.ehp.empresa.models.EmpleadoModel;
import com.ehp.empresa.services.EmpleadoService;

@RestController
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping(path="/empleados")
	public List<EmpleadoModel> getEmpleados() {
		return empleadoService.getEmpleados();
	}
	
	@PostMapping(path="/empleado")
	public void postEmpleado(@RequestBody EmpleadoModel empleadoModel) {
		if(!empleadoModel.validation(empleadoModel)
				|| !empleadoService.addEmpleado(empleadoModel)) {
			throw new BadRequestException();
		}
	}
}