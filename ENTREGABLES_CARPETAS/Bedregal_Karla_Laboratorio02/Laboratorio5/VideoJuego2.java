/* Autor: Karla Bedregal Coaguila
Laboratorio 05 */
package laboratorio05_karlabedregal;
import java.util.*;
public class VideoJuego2 {
    public static void main(String[] args) {
        Random rand = new Random();
        
        int numSoldados = rand.nextInt(9) + 1;
        Soldado [][] soldados = new Soldado [numSoldados][]; 
        int cont = 0;
        
        for (int i = 0; i < soldados.length; i++) {
            int numColumnas = rand.nextInt(9) + 1; 
            soldados[i] = new Soldado[numColumnas]; 

            for (int j = 0; j < soldados[i].length; j++) {
                String nombre = "Soldado" + cont;
                cont++;
                
                int nivelVida = rand.nextInt(4) + 1;
                int fila;
                
                String columna;

                do {
                    fila = rand.nextInt(9) + 1;
                    char letraRandom = (char) ('a' + rand.nextInt(10));
                    columna = Character.toString(letraRandom);
                } while (posicionOcupada(soldados, fila, columna));

                        soldados [i][j] = new Soldado();

                        soldados [i][j].setNombre(nombre);
                        soldados [i][j].setNivelVida(nivelVida);
                        soldados [i][j].setFila(fila);
                        soldados [i][j].setColumna(columna);               
            }
        }
        System.out.println("Soldados creados: ");
        mostrarSoldados(soldados);
        mayorVida(soldados);      
        promedioVida(soldados);
        nivelVida(soldados);
        datosOrden(soldados);
        rankingPoder(soldados);
        rankingPoder2(soldados);
    }
    public static boolean posicionOcupada (Soldado[][] soldados, int fila, String columna) {
        for (Soldado [] c : soldados) {
            if (c != null) {
                for (Soldado s : c) {
                    if (s != null && s.getFila() == fila && s.getColumna().equals(columna)) {
                        return true;
                    }
                }
            }
        }    
        return false;
    }
    
    public static void mostrarSoldados(Soldado [][] sold) {
        System.out.println("\nSoldados: ");
        for (Soldado[] c : sold) { 
            for (Soldado s : c) {
                System.out.println(s);
            }
        }
    }
    
    public static void mayorVida (Soldado [][] sold) {
        System.out.println("\nSoldado con mayor nivel de vida: ");
        Soldado mayor = sold[0][0];
        for (int i = 0; i < sold.length; i++) {
            for (int j = 0; j < sold[i].length; j++) {
                if (sold[i][j].getNivelVida() > mayor.getNivelVida()) {
                    mayor = sold[i][j];
                }
            }
        }
        System.out.println(mayor);
    }
    
    public static double promedioVida (Soldado [][] sold) {
        System.out.println("\nPromedio de nivel de vida de soldados creados: ");
        int suma = 0;
        int c = 0;
        for (int i = 0; i < sold.length; i++) {
            for (int j = 0; j < sold[i].length; j++) {
                suma += sold [i][j].getNivelVida();
                c = c + 1;
            }
        }
        double promedio = (double) suma / c;
        System.out.println(promedio);
        return promedio;
    }
    
    public static int nivelVida (Soldado [][] sold) {
        System.out.println("\nNivel de vida del ejército: ");
        int suma = 0;
        int contador = 0; 
        for (int i = 0; i < sold.length; i++) {
            for (int j = 0; j < sold[i].length; j++) {
                if (sold[i][j] != null) { 
                    suma += sold[i][j].getNivelVida();
                    contador++; 
                }
            }
        }
        System.out.println("Total Nivel de Vida: " + suma);
        System.out.println("Número de Soldados: " + contador);
        return suma;  
    }
    
    public static void datosOrden (Soldado [][] sold) {
        System.out.println("\nOrden en que fueron creados: ");
        int contador = 1; // Contador para imprimir el número
        for (Soldado[] fila : sold) {
            for (Soldado s : fila) {
                System.out.println(contador + " -> " + s);
                contador++; 
            }
        }
    }
    
    public static void rankingPoder (Soldado [][] sold) {
        System.out.println("\nRanking de poder por ordenamiento burbuja: ");
        for (int i = 0; i < sold.length; i++) {
            for (int j = 0; j < sold[i].length -1; j++) {
                for (int k = 0; k < sold[i].length - j - 1; k++) {
                    if (sold[i][k].getNivelVida() < sold[i][k + 1].getNivelVida()) {
                        Soldado temp = sold[i][k];
                        sold[i][k] = sold[i][k + 1];
                        sold[i][k + 1] = temp;
                    }
                }
            }
        }
        mostrarSoldados(sold);
    }
    
    public static void rankingPoder2 (Soldado [][] sold) {
        System.out.println("\nRanking de poder por ordenamiento selección: ");
        for (int i = 0; i < sold.length; i++) {
            for (int j = 0; j < sold[i].length -1; j++) {
                int max = j;                
                for (int k = j + 1; k < sold[i].length; k++) {
                    if (sold[i][k].getNivelVida() > sold[i][max].getNivelVida()) {
                        max = k;
                    }
                }    
                Soldado temp = sold[i][max];
                sold[i][max] = sold[i][j];
                sold[i][j] = temp;
            }
        }
        mostrarSoldados(sold);
    }
}    