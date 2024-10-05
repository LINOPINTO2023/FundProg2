/*
  Autor: Chipana Jeronimo German Arturo
  Proposito: Ejercicio 01
*/
package ejercicio01lab03;

import java.util.*;
public class Ejercicio01Lab03 {

    public static void main(String[] args) {
        Nave [] misNaves = new Nave[10];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;
        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i+1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.println("Fila ");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.next();
            System.out.print("Estado: ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();
            misNaves[i] = new Nave(); //Se crea un objeto Nave y se asigna su referencia a misNaves
            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
        }
        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);
        mostrarPorNombre(misNaves);
        mostrarPorPuntos(misNaves);
        System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));        
        Nave[] navesDesordenadas=desordenarNaves(misNaves);
        System.out.println("Naves desordenadas: ");
        for(Nave nave : navesDesordenadas){
            System.out.println(nave.toString());
        }
    }
    //Método para mostrar todas las naves
    public static void mostrarNaves(Nave [] flota){
        for(Nave nave : flota){
            System.out.println(nave.toString());
        }
    }
    //Método para mostrar todas las naves de un nombre que se pide por teclado
    public static void mostrarPorNombre(Nave [] flota){
        Scanner scan=new Scanner(System.in);
        System.out.println("Ingrese nombre de la nave a buscar: ");
        String naveBuscar=scan.next();
        System.out.println("Naves encontradas con el nombre "+naveBuscar+" : ");
        for(Nave nave : flota){
            if(nave.getNombre().equals(naveBuscar)){
                System.out.println(nave.toString());
            }
        }
    }
    //Método para mostrar todas las naves con un número de puntos inferior o igual
    //al número de puntos que se pide por teclado
    public static void mostrarPorPuntos(Nave [] flota){
        Scanner scan=new Scanner(System.in);
        System.out.println("Ingrese el numero max de puntos: ");
        int maxPuntos=scan.nextInt();
        System.out.println("Naves con puntos inferiores a "+maxPuntos);
        for(Nave nave : flota){
            if(nave.getPuntos()<=maxPuntos){
                System.out.println(nave.toString());
            }
        }       
    }
    //Método que devuelve la Nave con mayor número de Puntos
    public static Nave mostrarMayorPuntos(Nave [] flota){
        Nave naveMaxPuntos=flota[0];
        for(Nave nave : flota){
            if(nave.getPuntos()>naveMaxPuntos.getPuntos()){
                naveMaxPuntos=nave;
            }
        }   
        return naveMaxPuntos;       
    }    
    //Crear un método que devuelva un nuevo arreglo de objetos con todos los objetos previamente ingresados
    //pero aleatoriamente desordenados
    public static Nave[] desordenarNaves(Nave[] flota) {
        for (int i=flota.length-1;i>0;i--) {
            // Generar un número aleatorio entre 0 y i
            int j=(int)(Math.random()*(i+1)); 
            // Intercambiar flota[i] con flota[j]
            Nave temp=flota[i];
            flota[i]=flota[j];
            flota[j]=temp;
        }
        return flota; // Devolver el arreglo desordenado
    }  
}
