package com.ehp.empresa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ehp.empresa.errors.BadRequestException;
import com.ehp.empresa.errors.NotFoundException;
import com.ehp.empresa.models.TareaModel;
import com.ehp.empresa.services.TareaService;

@RestController
public class TareaController {
	
	
	@Autowired
	private TareaService tareaService;
	
	@GetMapping(path="/tareas")
	public List<TareaModel> getTareas(){
		return tareaService.getTareas();
	}
	
	@GetMapping(path="/tareas/{estado}")
	public List<TareaModel> getTareasPorEstado(@PathVariable(name="estado") String estado){
		return tareaService.getTareasPorEstado(estado);
	}
	
	@PostMapping(path="/tarea")
	public void postTarea(@RequestBody TareaModel tareaModel) {
		if(!tareaService.addTarea(tareaModel)) {
			throw new BadRequestException();
		}
	}
	
	@PutMapping(path="/tarea/{id}")
	public TareaModel modificarEstadoTarea(@PathVariable(name="id") long id) {
		Optional<TareaModel> tareaModel = tareaService.buscarTarea(id);
		if(tareaModel.isPresent()) {
			if(tareaService.modifyTarea(tareaModel.get())) {
				return  tareaService.buscarTarea(id).get();
			} else {
				throw new BadRequestException();
			}
		} else {
			throw new NotFoundException();
		}
	}
	
	
	@DeleteMapping(path="/tarea/{id}")
	public TareaModel tareaModel(@PathVariable(name="id") long id) {
		//Incluir validaciones
		Optional<TareaModel> result = tareaService.deleteTarea(id);
		if(result.isPresent()) {
			return result.get();
		} else {
			throw new NotFoundException();
		}
	}
}