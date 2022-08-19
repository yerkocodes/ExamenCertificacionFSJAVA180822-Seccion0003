package com.studentsystem.model;

import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
//@AllArgsConstructor
@Data
@Table
public class EstudiantesForMonitor {
	
	private String rut;
	private String nombre;
	private String apellido_pat;
	private String apellido_mat;
	private String codigo_curso;
	private String descripcion;
	public EstudiantesForMonitor(String rut, String nombre, String apellido_pat, String apellido_mat,
			String codigo_curso, String descripcion) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.apellido_pat = apellido_pat;
		this.apellido_mat = apellido_mat;
		this.codigo_curso = codigo_curso;
		this.descripcion = descripcion;
	}
	
	

}
