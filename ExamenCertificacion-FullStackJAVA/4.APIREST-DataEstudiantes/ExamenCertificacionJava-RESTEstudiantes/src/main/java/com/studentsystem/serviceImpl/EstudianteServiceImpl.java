package com.studentsystem.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentsystem.Application;
import com.studentsystem.dao.IEstudianteRepository;
import com.studentsystem.model.Estudiante;
import com.studentsystem.model.EstudiantesForMonitor;
import com.studentsystem.service.IEstudianteService;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository dao;
	
	private Logger log = LoggerFactory.getLogger(Application.class);

	@Override
	@Transactional
	public Estudiante add(Estudiante estudiante) {
		Estudiante estudianteToAdd = new Estudiante();
		try {
			estudianteToAdd = dao.save(estudiante);
		} catch (Exception e) {
			log.error("Ocurred an error in 'add'. Location: 'com.studentsystem.serviceImpl'. Error: " + e.getMessage());
		}
		return estudianteToAdd;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Estudiante> findAllEstudiantes() {
		List<Estudiante> estudiantesList = new ArrayList<>();
		try {
			estudiantesList = (List<Estudiante>) dao.findAll();
		} catch (Exception e) {
			log.error("Ocurred an error in 'findAllEstudiantes'. Location: 'com.studentsystem.serviceImpl'. Error: " + e.getMessage());
		}
		return estudiantesList;
	}

	@Override
	@Transactional(readOnly = true)
	public Estudiante findById(Integer id) {
		Estudiante estudiante = new Estudiante();
		try {
			estudiante = dao.findById(id).get();
		} catch (Exception e) {
			log.error("Ocurred an error in 'findById'. Location: 'com.studentsystem.serviceImpl'. Error: " + e.getMessage());
		}
		
		return estudiante;
	}

	@Override
	@Transactional(readOnly = true)
	public Estudiante findByRut(String rut) {
		Estudiante estudiante = new Estudiante();
		try {
			estudiante = dao.findByRutEstudiante(rut);
		} catch (Exception e) {
			log.error("Ocurred an error in 'findByRut'. Location: 'com.studentsystem.serviceImpl'. Error: " + e.getMessage());
		}
		
		return estudiante;
	}

	@Override
	@Transactional
	public Estudiante update(Estudiante estudiante) {
		Estudiante estudianteToUpdate = new Estudiante();
		try {
			estudianteToUpdate = dao.save(estudiante);
		} catch (Exception e) {
			log.error("Ocurred an error in 'update'. Location: 'com.studentsystem.serviceImpl'. Error: " + e.getMessage());
		}
		return estudianteToUpdate;
	}

	@Override
	@Transactional
	public Boolean deleteEstudiante(Integer id) {
		try {
			if (dao.findById(id) != null) {
				dao.deleteById(id);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			log.error("Ocurred an error in 'deleteEstudiante'. Location: 'com.studentsystem.serviceImpl'. Error: " + e.getMessage());
		}
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public List<EstudiantesForMonitor> findEstudiantesForMonitor() {
		List<EstudiantesForMonitor> lista = new ArrayList<>();
		try {
			lista = dao.findEstudiantesForMonitor();
			System.out.println(lista);
		} catch (Exception e) {
			log.error("Ocurred an error in 'findEstudianteForMonitor'. Location: 'com.studentsystem.serviceImpl'. Error: " + e.getMessage());
		}
		return lista;
	}

	@Override
	public List<Estudiante> findEstudiantesPeerRegion(Integer codigoRegion) {
		List<Estudiante> lista = new ArrayList<>();
		try {
			lista = dao.findEstudiantesPeerRegion(codigoRegion);
			System.out.println(lista);
		} catch (Exception e) {
			log.error("Ocurred an error in 'findEstudianteForMonitor'. Location: 'com.studentsystem.serviceImpl'. Error: " + e.getMessage());
		}
		return lista;
	}

}
