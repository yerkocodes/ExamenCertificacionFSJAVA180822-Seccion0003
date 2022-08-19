package com.studentsystem.service;

import java.util.List;

import com.studentsystem.model.Estudiante;
import com.studentsystem.model.EstudiantesForMonitor;

public interface IEstudianteService {
	
	//CREATE
	public Estudiante add(Estudiante estudiante);

	//READ
	public List<Estudiante> findAllEstudiantes();
	public Estudiante findById(Integer id);
	public Estudiante findByRut(String rut);
	public List<EstudiantesForMonitor> findEstudiantesForMonitor();
	
	public List<Estudiante> findEstudiantesPeerRegion(Integer codigoRegion);

	//UPDATE
	public Estudiante update(Estudiante estudiante);

	//DELETE
	public Boolean deleteEstudiante(Integer id);
	

}
