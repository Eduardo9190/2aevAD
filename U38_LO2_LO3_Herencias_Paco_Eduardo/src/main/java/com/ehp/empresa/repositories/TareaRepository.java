package com.ehp.empresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ehp.empresa.entities.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long>{
	
	//Recuperar tareas segun su estado
	public List<Tarea> findByEstado(String estado);
	
	
}
