package com.calculoedad.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Estudiante {
	
	private Integer id_estudiante;
	private String rut;
	private String apellido_pat;
	private String apellido_mat;
	private String direccion;
	private String fecha_nacimiento;
	
	//Empty constructor
	public Estudiante() {}

	//Constructor with fields
	public Estudiante(Integer id_estudiante, String rut, String apellido_pat, String apellido_mat, String direccion,
			String fecha_nacimiento) {
		super();
		this.id_estudiante = id_estudiante;
		this.rut = rut;
		this.apellido_pat = apellido_pat;
		this.apellido_mat = apellido_mat;
		this.direccion = direccion;
		this.fecha_nacimiento = fecha_nacimiento;
	}

	//GETTERS AND SETTERS
	public Integer getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(Integer id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getApellido_pat() {
		return apellido_pat;
	}

	public void setApellido_pat(String apellido_pat) {
		this.apellido_pat = apellido_pat;
	}

	public String getApellido_mat() {
		return apellido_mat;
	}

	public void setApellido_mat(String apellido_mat) {
		this.apellido_mat = apellido_mat;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	//CALCULAR METHOD
	public Integer calcular_edad() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");

		LocalDate dob = LocalDate.parse(this.getFecha_nacimiento(), dtf);

		LocalDate localDate = LocalDate.now();

		Period period = Period.between(dob, localDate);
		
		return period.getYears();
	}

}
