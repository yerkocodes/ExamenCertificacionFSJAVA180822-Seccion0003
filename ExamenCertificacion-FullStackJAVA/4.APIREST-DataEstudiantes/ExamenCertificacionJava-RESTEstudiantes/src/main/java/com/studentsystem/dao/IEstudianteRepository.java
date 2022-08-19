package com.studentsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.studentsystem.model.Estudiante;
import com.studentsystem.model.EstudiantesForMonitor;

public interface IEstudianteRepository extends CrudRepository<Estudiante, Integer> {
	
	@Query(value = "SELECT * FROM Estudiante WHERE rut = ?1", nativeQuery = true)
	public Estudiante findByRutEstudiante(String rutEstudiante);
	
	@Query(value = "SELECT Estudiante.rut, Estudiante.nombre, Estudiante.apellido_pat, Estudiante.apellido_mat, Estudiante.codigo_curso, Plan_Formativo.descripcion FROM Estudiante INNER JOIN Curso ON Curso.codigo_curso = Estudiante.codigo_curso INNER JOIN Plan_Formativo ON Plan_Formativo.codigo_plan_formativo = Curso.codigo_plan_formativo INNER JOIN Comuna ON Comuna.codigo_comuna = Estudiante.codigo_comuna INNER JOIN Region ON Region.codigo_region = Comuna.codigo_region", nativeQuery = true)
	public List<EstudiantesForMonitor> findEstudiantesForMonitor();
	
	@Query(value = "SELECT * FROM Estudiante e INNER JOIN Curso c ON c.codigo_curso = e.codigo_curso WHERE c.codigo_region = ?1", nativeQuery = true)
	public List<Estudiante> findEstudiantesPeerRegion(Integer codigoRegion);

}
