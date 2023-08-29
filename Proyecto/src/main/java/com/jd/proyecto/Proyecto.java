/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jd.proyecto;

import Mundo.Alumno;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juand
 */
public class Proyecto {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        boolean activo = true;
        ArrayList<Alumno> misAlumnos = new ArrayList<Alumno>();
        
        try {
            FileReader archivo = new FileReader("./data/listaEstudiantes.txt");
            if (archivo.ready()) {
                BufferedReader lector = new BufferedReader(archivo);
                String cadena;
                while ((cadena = lector.readLine())!= null) {
                    String[] partes = cadena.split(",");
                    if (partes.length == 6) {
                        Alumno a = new Alumno();
                        a.setCedula(partes[0]);
                        a.setNombre(partes[1]);
                        a.setApellido(partes[2]);
                        a.setSemestre(Integer.parseInt(partes[3]));
                        a.setCorreo(partes[4]);
                        a.setCelular(partes[5]);

                        misAlumnos.add(a);
                    }
                }
                
                      
                lector.close();
            }
            
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        
        
        do {            
           System.out.println("------------------- Menu de opciones -------------------");
           System.out.println("1. Insertar alumno");
           System.out.println("2. Modificar alumno");
           System.out.println("3. Eliminar alum no");
           System.out.println("4. Consultar alumno");
           System.out.println("5. Imprimir reporte de semestre");
           System.out.println("6. terminar Programa");
           System.out.println("---------------------------------------------------------");
           
           int opcion = sc.nextInt();
            switch (opcion) {
                case 1 ->{
                    try {
                        System.out.println("Bienvenid@ a registro de nuevo alumno");
                        System.out.println("Introduce cedula del almunno");
                        String cedula = sc.next();
                        System.out.println("Introduce nombre del almunno");
                        String nombre = sc.next();
                        System.out.println("Introduce apellido del almunno");
                        String apellido = sc.next();
                        System.out.println("Introduce semestre del almunno");
                        int semestre = sc.nextInt();
                        System.out.println("Introduce correo del almunno");
                        String correo = sc.next();
                        System.out.println("Introduce celular del almunno");
                        String celular = sc.next();

                        Alumno a = new Alumno();
                        a.setCedula(cedula);
                        a.setNombre(nombre);
                        a.setApellido(apellido);
                        a.setSemestre(semestre);
                        a.setCorreo(correo);
                        a.setCelular(celular);

                        misAlumnos.add(a);
                    
                    } catch (Exception e) {
                        System.out.println("Datos erroneos");
                    }
                    
                }
                case 2 -> {
                    
                    System.out.println("Bienvenid@ a modificar información de alumno");
                    System.out.println("Introduce cédula del alumno");
                    String cedula = sc.next();
                    int lugar = -1;
                    for (int i = 0; i < misAlumnos.size(); i++) {
                        if (cedula.equals(misAlumnos.get(i).getCedula())) {
                            lugar = i;
                            break;
                        }
                    }

                    if (lugar != -1) {
                        Alumno alumnoModificado = misAlumnos.get(lugar);

                        System.out.println("Introduce el nuevo nombre del alumno");
                        String nuevoNombre = sc.next();
                        alumnoModificado.setNombre(nuevoNombre);

                        System.out.println("Introduce el nuevo apellido del alumno");
                        String nuevoApellido = sc.next();
                        alumnoModificado.setApellido(nuevoApellido);

                        System.out.println("Introduce el nuevo semestre del alumno");
                        int nuevoSemestre = sc.nextInt();
                        alumnoModificado.setSemestre(nuevoSemestre);

                        System.out.println("Introduce el nuevo correo del alumno");
                        String nuevoCorreo = sc.next();
                        alumnoModificado.setCorreo(nuevoCorreo);

                        System.out.println("Introduce el nuevo celular del alumno");
                        String nuevoCelular = sc.next();
                        alumnoModificado.setCelular(nuevoCelular);

                    } else {
                        System.out.println("No se encontró ningún alumno con la cédula ingresada.");
                    }
                    break;
                    
                }
                case 3 -> {
                    int lugar = -1;
                    System.out.println("Bienvenid@ a eliminar alumno");
                    System.out.println("Introduce la cédula del alumno que deseas eliminar:");
                    String cedulaEliminar = sc.next();
                    
    
                    for (int i = 0; i < misAlumnos.size(); i++) {
                        if (cedulaEliminar.equals(misAlumnos.get(i).getCedula())) {
                            lugar = i;
                            break;
                        }
                    }
    
                    if (lugar != -1) {
                        Alumno alumnoEliminado = misAlumnos.remove(lugar);
                        System.out.println("Alumno eliminado:");
                        
                    } else {
                        System.out.println("No se encontró ningún alumno con la cédula ingresada.");
                    }
                    break;
                    
                    
                }
                case 4 -> {
                    System.out.println("Bienvenid@ a Consulta de alumno");
                    for(int i = 0; i < misAlumnos.size(); i++){
                        System.out.println("Cedula: " + misAlumnos.get(i).getCedula());
                        System.out.println("Nombre: " + misAlumnos.get(i).getNombre());
                        System.out.println("Apellido: " + misAlumnos.get(i).getApellido());
                        System.out.println("Semestre: " + misAlumnos.get(i).getSemestre());
                        System.out.println("Correo: " + misAlumnos.get(i).getCorreo());
                        System.out.println("Celular: " + misAlumnos.get(i).getCelular());
                        System.out.println("");
                    }
                }
                case 5 ->{
                    System.out.println("Bienvenid@ a generador de reportes");
                    System.out.println("Inserte el semestre que desea generar reporte");
                    int semestreBusqueda = sc.nextInt();
                    File archivo = new File("./data/reporteSemestre.txt");
                    PrintWriter pluma = new PrintWriter(archivo);
                    pluma.println("--------------Reporte de " + semestreBusqueda + " semestre--------------");
                    for(int i = 0; i < misAlumnos.size(); i++) {
                        if (semestreBusqueda == misAlumnos.get(i).getSemestre()){
                            pluma.println("Cedula: " + misAlumnos.get(i).getCedula());
                            pluma.println("Nombre: " + misAlumnos.get(i).getNombre());
                            pluma.println("Apellido: " + misAlumnos.get(i).getApellido());
                            pluma.println("Semestre: " + misAlumnos.get(i).getSemestre());
                            pluma.println("Correo: " + misAlumnos.get(i).getCorreo());
                            pluma.println("Celular: " + misAlumnos.get(i).getCelular());
                            pluma.println("");
                        }
                    }
                    pluma.close();
                }
                case 6 ->{
                    System.out.println("Salir de programa ");
                    File archivo = new File("./data/listaEstudiantes.txt");
                    PrintWriter pluma = new PrintWriter(archivo);
                    for(int i = 0; i < misAlumnos.size(); i++) {
                        
                        pluma.print(misAlumnos.get(i).getCedula()+ ",");
                        pluma.print(misAlumnos.get(i).getNombre()+ ",");
                        pluma.print(misAlumnos.get(i).getApellido()+ ",");
                        pluma.print(misAlumnos.get(i).getSemestre()+ ",");
                        pluma.print(misAlumnos.get(i).getCorreo()+ ",");
                        pluma.print(misAlumnos.get(i).getCelular());
                        pluma.println("");
                    }
                    pluma.close();
                    activo = false;
                }  
                default -> System.out.println("Opción invalda");
            }
           
        } while (activo);
        
        sc.close();
    }
}
