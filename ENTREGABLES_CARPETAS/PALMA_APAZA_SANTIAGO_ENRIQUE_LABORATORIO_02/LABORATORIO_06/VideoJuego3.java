package labFP2;

import java.util.ArrayList;

public class VideoJuego3 {
    public static void main(String[] args) {
        Soldado[][] tablero = new Soldado[10][10];
        ArrayList<Soldado> soldados = new ArrayList<>();
        int numeroSoldados = (int) (Math.random() * 11);
        int vidaTotal = 0;

        for (int i = 0; i < numeroSoldados; i++) {
            Soldado soldado;
            int vida, fila, columna;
            do {
                vida = (int) (Math.random() * 6) + 1;
                fila = (int) (Math.random() * 10);
                columna = (int) (Math.random() * 10);
                soldado = new Soldado("Soldado" + i, vida, fila, columna);
            } while (verificar(tablero, soldado));
            tablero[fila][columna] = soldado;
            soldados.add(soldado);
            vidaTotal += vida;
        }

        mostrar(tablero);
        soldadoMayorVida(soldados);
        mostrarDatosEjercito(soldados, vidaTotal);
        rankingSoldadosBurbuja(soldados);
        rankingSoldadosSeleccion(soldados);
    }

    public static boolean verificar(Soldado[][] tablero, Soldado soldado) {
        return tablero[soldado.getFila()][soldado.getColumna()] != null;
    }

    public static void mostrar(Soldado[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == null) {
                    System.out.print("_________| ");
                } else {
                    System.out.print(tablero[i][j].getNombre() + " | ");
                }
            }
            System.out.println();
        }
    }

    public static void soldadoMayorVida(ArrayList<Soldado> soldados) {
        Soldado soldadoMayor = soldados.get(0);
        for (Soldado soldado : soldados) {
            if (soldado.getNivelVida() > soldadoMayor.getNivelVida()) {
                soldadoMayor = soldado;
            }
        }
        System.out.println("Soldado con mayor nivel de vida: " + soldadoMayor.getNombre() + 
                           " (Vida: " + soldadoMayor.getNivelVida() + ")");
    }

    public static void mostrarDatosEjercito(ArrayList<Soldado> soldados, int vidaTotal) {
        System.out.println("Vida total del ejército: " + vidaTotal);
        System.out.println("Promedio de vida del ejército: " + (vidaTotal / soldados.size()));
    }

    public static void rankingSoldadosBurbuja(ArrayList<Soldado> soldados) {
        Soldado[] soldadosArray = soldados.toArray(new Soldado[0]);
        for (int i = 0; i < soldadosArray.length - 1; i++) {
            for (int j = 0; j < soldadosArray.length - i - 1; j++) {
                if (soldadosArray[j].getNivelVida() < soldadosArray[j + 1].getNivelVida()) {
                    Soldado temp = soldadosArray[j];
                    soldadosArray[j] = soldadosArray[j + 1];
                    soldadosArray[j + 1] = temp;
                }
            }
        }

        System.out.println("Ranking de poder de los soldados (Burbuja):");
        for (Soldado soldado : soldadosArray) {
            System.out.println(soldado.getNombre() + " - Vida: " + soldado.getNivelVida());
        }
    }

    public static void rankingSoldadosSeleccion(ArrayList<Soldado> soldados) {
        Soldado[] soldadosArray = soldados.toArray(new Soldado[0]);

        for (int i = 0; i < soldadosArray.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < soldadosArray.length; j++) {
                if (soldadosArray[j].getNivelVida() > soldadosArray[maxIdx].getNivelVida()) {
                    maxIdx = j;
                }
            }
            Soldado temp = soldadosArray[maxIdx];
            soldadosArray[maxIdx] = soldadosArray[i];
            soldadosArray[i] = temp;
        }

        System.out.println("Ranking de poder de los soldados (Selección):");
        for (Soldado soldado : soldadosArray) {
            System.out.println(soldado.getNombre() + " - Vida: " + soldado.getNivelVida());
        }
    }
}
