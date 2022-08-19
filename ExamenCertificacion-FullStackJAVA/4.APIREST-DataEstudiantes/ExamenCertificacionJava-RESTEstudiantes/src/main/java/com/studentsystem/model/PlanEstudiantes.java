package com.studentsystem.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlanEstudiantes {
	
	private List<Estudiante> estudiantes;
	private List<Curso> cursos;
	private List<PlanFormativo> planes;

}
