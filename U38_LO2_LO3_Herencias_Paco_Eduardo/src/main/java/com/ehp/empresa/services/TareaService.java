package com.ehp.empresa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehp.empresa.converters.TareaConverter;
import com.ehp.empresa.entities.Tarea;
import com.ehp.empresa.models.TareaModel;
import com.ehp.empresa.repositories.EmpleadoRepository;
import com.ehp.empresa.repositories.TareaRepository;

@Service
public class TareaService {
	
	@Autowired
	private TareaRepository tareaRepository;
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private TareaConverter tareaConverter;
	
	public ArrayList<TareaModel> getTareas() {
		List<Tarea> tareas = tareaRepository.findAll();
		ArrayList<TareaModel> tareasModel = new ArrayList<>();
		for (Tarea tarea:tareas) {
			TareaModel tareaModel = tareaConverter.entityToModel(tarea);
			tareasModel.add(tareaModel);
		}
		return tareasModel;
	}
	
	public List<TareaModel> getTareasPorEstado(String estado) {
		List<Tarea> tareas = tareaRepository.findByEstado(estado);
		List<TareaModel> tareasModel = new ArrayList<>();
		for(Tarea tarea:tareas) {
			TareaModel tareaModel = tareaConverter.entityToModel(tarea);
			tareasModel.add(tareaModel);
		}
		return tareasModel;
	}
	
	public List<TareaModel> getTareasIndividuales(String email) {
		List<Tarea> tareas = tareaRepository.findByEmail(email);
		List<TareaModel> tareasModel = new ArrayList<>();
		for (Tarea tarea:tareas) {
			TareaModel tareaModel = tareaConverter.entityToModel(tarea);
			tareasModel.add(tareaModel);
		}
		return tareasModel;
	}
	
	public boolean findEmpleado(String email) {
		if(!empleadoRepository.findByEmail(email)) {
			return false;
		}
		return true;
	}
	
	public Optional<TareaModel> buscarTarea(long id) {
		Optional<Tarea> tarea = tareaRepository.findById(id);
		Optional<TareaModel> tareaModel = Optional.empty();
		if (tarea.isPresent()) {
			tareaModel = Optional.of(tareaConverter.entityToModel(tarea.get()));
		}
		return tareaModel;
	}
	
	
	public boolean addTarea(TareaModel tareaModel) {
		Tarea tarea = tareaConverter.modelToEntity(tareaModel);
		long id = tarea.getId();
		if (tareaRepository.findById(id).isPresent()) {
			return false;
		}
		tareaRepository.save(tarea);
		return true;
	}
	
	public boolean modifyTarea(TareaModel tareaModel) {
		Tarea tarea = tareaConverter.modelToEntity(tareaModel);
		String estado = tarea.getEstado();
		if(estado.matches("pendiente")) {
			tarea.setEstado("en progreso");
		} else if (estado.matches("en progreso")) {
			tarea.setEstado("completada");
		} else {
			return false;
		}
		tareaRepository.save(tarea);
		return true;
	}
	
	public Optional<TareaModel> deleteTarea(long id) {
		Optional<TareaModel> resultTareaModel = Optional.empty();
		Optional<Tarea> resultTarea = tareaRepository.findById(id);
		if (resultTarea.isPresent()) {
			tareaRepository.deleteById(id);
			TareaModel tareaModel = tareaConverter.entityToModel(resultTarea.get());
			resultTareaModel = Optional.of(tareaModel);
		}
		return resultTareaModel;
	}
}
