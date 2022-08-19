package com.studentsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentsystem.model.Estudiante;
import com.studentsystem.service.IEstudianteService;

@RestController //Controlador de tipo rest
//@RequestMapping(value = "/api/v1", method = RequestMethod.GET) // endpoint, mapping o llave de entrada para el controlador
@RequestMapping("/api/v1") // endpoint, mapping o llave de entrada para el controlador
public class EstudianteRESTController {
	
	// Inyeccion de dependencias
	@Autowired
	private IEstudianteService estudianteService;
	
//	http://localhost:8080/api/v1/estudiantes
	@GetMapping("/estudiantes")
	public ResponseEntity<List<Estudiante>> getAllEstudiante() {
		
		try {
			List<Estudiante> estudiantes = new ArrayList<>();
			
			estudiantes = estudianteService.findAllEstudiantes();
			
			if (estudiantes.isEmpty()) {
				return new ResponseEntity<>(estudiantes, HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(estudiantes, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

//	http://localhost:8080/api/v1/estudiantesFilter?region=1&curso=A5
	@GetMapping("/estudiantesFilter")
	public ResponseEntity<List<Estudiante>> getEstudianteById(@RequestParam("region") int regionId, @RequestParam("curso") String codigoPlanFormativo) {
		try {

			List<Estudiante> response = new ArrayList<>();

			for (Estudiante estudiante : estudianteService.findAllEstudiantes()) {
				if (estudiante.getComuna().getCodigo_region() == regionId && estudiante.getCurso().getPlanFormativo().getCodigo_plan_formativo().equals(codigoPlanFormativo)) {
					response.add(estudiante);
				}
			}

			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
