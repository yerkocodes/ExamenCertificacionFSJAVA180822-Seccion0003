package com.studentsystem.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseMonitor {
	
//	private List<Estudiante> estudiantes;
//	private List<Curso> cursos;
//	private List<PlanFormativo> planesFormativos;
	
	private String rut;
	private String nombre;
	private String apellido_pat;
	private String apellido_mat;
	private String codigo_curso;
	private String descripcion;

}
