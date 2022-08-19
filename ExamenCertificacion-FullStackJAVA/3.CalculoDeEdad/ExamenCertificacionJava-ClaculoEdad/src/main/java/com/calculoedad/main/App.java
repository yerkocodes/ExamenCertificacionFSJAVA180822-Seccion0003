package com.calculoedad.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.calculoedad.model.Estudiante;

/**
 * Hello world!
 *
 */
public class App {
	
	
    public static void main( String[] args ) {
    	
	Scanner sc = new Scanner(System.in);

    	ArrayList<Estudiante> listaEstudiante = new ArrayList<Estudiante>();
    	
    	Estudiante estudiante1 = new Estudiante(1, "123456-7", "Cortes", "Baeza", "calleCero 123", null);
    	Estudiante estudiante2 = new Estudiante(2, "123456-8", "Perez", "Gonzales", "calleUno 123", null);
    	Estudiante estudiante3 = new Estudiante(3, "123456-1", "Juanito", "Ibaceta", "calleDos 123", null);
    	Estudiante estudiante4 = new Estudiante(4, "123456-2", "Mancilla", "Stark", "calleTres 123", null);
    	Estudiante estudiante5 = new Estudiante(5, "123456-3", "Jackson", "Tyrell", "calleCuatro 123", null);
    	
    	listaEstudiante.add(estudiante1);
    	listaEstudiante.add(estudiante2);
    	listaEstudiante.add(estudiante3);
    	listaEstudiante.add(estudiante4);
    	listaEstudiante.add(estudiante5);
    	
    	for (Estudiante estudiante : listaEstudiante) {
    		System.out.println("Por favor ingrese la fecha de nacimiento para " + estudiante.getApellido_pat());
    		System.out.println("Formato de fecha: DD/MM/AAAA");
    		estudiante.setFecha_nacimiento(sc.nextLine());
    		System.out.println("El estudiante " + estudiante.getApellido_pat() + " nacio el " + estudiante.getFecha_nacimiento() + " y su edad es " + estudiante.calcular_edad() + " años");
    		System.out.println();
		}

    	sc.close();
    	
    }
}
