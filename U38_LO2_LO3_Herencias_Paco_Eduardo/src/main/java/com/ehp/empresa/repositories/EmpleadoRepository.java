package com.ehp.empresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository

import com.ehp.empresa.entities.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String>{

}
