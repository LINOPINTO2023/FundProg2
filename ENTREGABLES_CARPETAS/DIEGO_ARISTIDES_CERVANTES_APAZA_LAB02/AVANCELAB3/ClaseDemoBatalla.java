/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_diegocervantes;

/**
 *
 * @author Usuario24B
 */
import java.util.ArrayList;
import java.util.Scanner;
public class ClaseDemoBatalla {
        public static void main(String [] args){
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
            
        }
    //Método para mostrar todas las naves
    public static void mostrarNaves(Nave [] flota){
    }
    //Método para mostrar todas las naves de un nombre que se pide por teclado
    public static void mostrarPorNombre(Nave [] flota){
    }
    //Método para mostrar todas las naves con un número de puntos inferior o igual
    //al número de puntos que se pide por teclado
    public static void mostrarPorPuntos(Nave [] flota){
    }
    //Método que devuelve la Nave con mayor número de Puntos

        //Crear un método que devuelva un nuevo arreglo de objetos con todos los objetos previamente ingresados
        //pero aleatoriamente desordenados

}
