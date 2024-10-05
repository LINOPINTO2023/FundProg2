/*
  Autor: Chipana Jeronimo German Arturo
  Proposito: Ejercicio 04
*/
package ejercicio4lab1;

import java.util.*;
public class Ejercicio4Lab1 {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        // Crea un arreglo de objetos Soldados con capacidad para 5 soldados
        Soldados[] soldado=new Soldados[5];
        // Bucle para inicializar cada soldado
        for(int i=0;i<soldado.length;i++){
            // Crea un nuevo objeto Soldados para cada posición del arreglo
            soldado[i]=new Soldados();
            // Solicita al usuario que ingrese el nombre del soldado
            System.out.println("Ingrese nombre soldado "+(i+1)+": ");
            String nombre=scan.next();
            // Solicita al usuario que ingrese la vida del soldado
            System.out.println("Ingrese vida de soldado "+(i+1)+": ");
            int vida=scan.nextInt();
            // Asigna el nombre y la vida al objeto Soldados
            soldado[i].setNombre(nombre);
            soldado[i].setVida(vida);
        }
        // Muestra los nombres y vidas de los soldados ingresados
        System.out.println("Nombres de soldados: ");
        for(int j=0;j<soldado.length;j++){
            System.out.println("Nombre soldado "+(j+1)+": "+soldado[j].getNombre()+
                    "\tVida soldado "+(j+1)+": "+soldado[j].getVida());
        }
    }   
}




