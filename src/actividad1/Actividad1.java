/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad1;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vicente
 */
public class Actividad1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        boolean error;
        System.out.println("ACTIVIDAD 1");
        do {
            error = false;
            //Damos la opción de listar el directorio actual o elegir uno nosotros
            System.out.println("Elige una opción: ");
            System.out.println("1- Listar este directorio.");
            System.out.println("2- Elegir el directorio a listar.");
            int num = sc.nextInt();
            //Si la opción és correcta...
            //Listamos el directorio actual
            if (num == 1) {
                String dir = ".";
                File f = new File(dir);
                File[] archivos = f.listFiles();
                System.out.println("El directorio actual es: " + f.getAbsolutePath());
                System.out.println("El directorio actual contiene: " + archivos.length + " archivos.");
                System.out.println("Los archivos son: ");
                for (File archivo : archivos) {
                    System.out.println(archivo.getName());
                }
                //Listamos un directorio que introduciremos por consola
            } else if (num == 2) {
                System.out.println("Escribe la ruta del directorio: ");
                String dir = sc2.next();
                File f = new File(dir);
                if (f.exists()) {
                    File[] archivos = f.listFiles();
                    System.out.println("El directorio actual es: " + f.getAbsolutePath());
                    System.out.println("El directorio actual contiene: " + archivos.length + " archivos.");
                    System.out.println("Los archivos son: ");
                    for (File archivo : archivos) {
                        System.out.println(archivo.getName());
                    }
                } else {
                    System.out.println("El directorio no existe.");
                    error = true;
                }
            } else {
                System.out.println("La opción elegida no és correcta");
                error = true;
            }
            //El bucle se repetirá mientras introduzcamos una opción incorrecta
        } while (error);
        //-----------------------------------------------------------------------------------------------------------
        System.out.println("ACTIVIDAD 2");
        //Vamos a crear el directorio NUEVODIR
        File f = new File(".NUEVODIR");
        if (f.exists()) {
            System.out.println("El directorio ya existe");
        } else {
            boolean resultado = f.mkdir();
            if (resultado) {
                System.out.println("Directorio creado");
                System.out.println(f.getAbsolutePath());
                //Ahora creamos dentro del nuevo directorio 2 archivos
                File f2 = new File(".NUEVODIR/Archivo1");
                File f3 = new File(".NUEVODIR/Archivo2");
                File f4 = new File(".NUEVODIR/Renombrado");
                try {
                    boolean a1 = f2.createNewFile();
                    System.out.println("Archivo 1 creado");
                } catch (IOException ex) {
                    Logger.getLogger(Actividad1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    boolean a1 = f3.createNewFile();
                    System.out.println("Archivo 2 creado");
                } catch (IOException ex) {
                    Logger.getLogger(Actividad1.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Ahora renombramos el "Archivo1" a "Renombrado"
                boolean r2 = f2.renameTo(f4);
                if (r2) {
                    System.out.println("Archivo1 renombrado");
                } else {
                    System.out.println("Error al renombrar el archivo");
                }
            } else {
                System.out.println("Error al crear el directorio");
            }
        }
        //-----------------------------------------------------------------------------------------------------------
        System.out.println("ACTIVIDAD 3");
        /*Usando directamente f.delete() el directorio no se borraba, al parecer porque tenía archivos
          dentro, ya que sin los archivos si que lo borraba, por lo tanto recorremos con un for los archivos 
          del directorio y los vamos borrando uno a uno
         */
        for (File f5 : f.listFiles()) {
            f5.delete();
            System.out.println(f5.getName()+" borrado");
        }
        //Una vez vacío ya se puede borrar el directorio
        f.delete();
        System.out.println(" Directorio borrado");
    }

}
