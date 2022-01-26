package com.ehp.empresa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehp.empresa.TareaRepository;
import com.ehp.empresa.converters.TareaConverter;
import com.ehp.empresa.entities.Tarea;
import com.ehp.empresa.models.TareaModel;

@Service
public class TareaService {
	
	@Autowired
	private TareaRepository tareaRepository;
	
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
	
	
	//public boolean cambiarEstadoTarea() {}
	
	public boolean addTarea(TareaModel tareaModel) {
		Tarea tarea = tareaConverter.modelToEntity(tareaModel);
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
