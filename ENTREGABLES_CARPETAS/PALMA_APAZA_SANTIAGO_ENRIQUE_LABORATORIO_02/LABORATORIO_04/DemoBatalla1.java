package labFP2;

import java.util.*;

public class DemoBatalla1 {
    public static void main(String[] args) {
        Nave[] misNaves = new Nave[10];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;

        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.print("Fila: ");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.next();
            System.out.print("Estado (true/false): ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();

            misNaves[i] = new Nave();
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
        System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves).getNombre());
        
        System.out.println("Ingrese un nombre de nave para buscar:");
        sc.nextLine();  
        String nombreNave = sc.nextLine();
        
        int pos = busquedaLinealNombre(misNaves, nombreNave);
        if (pos != -1) {
            System.out.println("Nave encontrada en posición: " + pos);
        } else {
            System.out.println("Nave no encontrada.");
        }

        ordenarPorPuntosBurbuja(misNaves);
        mostrarNaves(misNaves);
        
        ordenarPorNombreBurbuja(misNaves);
        mostrarNaves(misNaves);

        pos = busquedaBinariaNombre(misNaves, nombreNave);
        if (pos != -1) {
            System.out.println("Nave encontrada en posición: " + pos);
        } else {
            System.out.println("Nave no encontrada.");
        }

        ordenarPorPuntosSeleccion(misNaves);
        mostrarNaves(misNaves);
        
        ordenarPorNombreSeleccion(misNaves);
        mostrarNaves(misNaves);
        
        ordenarPorPuntosInsercion(misNaves);
        mostrarNaves(misNaves);
        
        ordenarPorNombreInsercion(misNaves);
        mostrarNaves(misNaves);
    }

    public static void mostrarNaves(Nave[] flota) {
        for (Nave nave : flota) {
            if (nave != null) {
                System.out.println("Nombre: " + nave.getNombre() + ", Fila: " + nave.getFila() +
                        ", Columna: " + nave.getColumna() + ", Estado: " + nave.getEstado() +
                        ", Puntos: " + nave.getPuntos());
            }
        }
    }

    public static int busquedaLinealNombre(Nave[] flota, String s) {
        for (int i = 0; i < flota.length; i++) {
            if (flota[i] != null && flota[i].getNombre().equalsIgnoreCase(s)) {
                return i;
            }
        }
        return -1;
    }

    public static void ordenarPorPuntosBurbuja(Nave[] flota) {
        for (int i = 0; i < flota.length - 1; i++) {
            for (int j = 0; j < flota.length - i - 1; j++) {
                if (flota[j] != null && flota[j + 1] != null && flota[j].getPuntos() > flota[j + 1].getPuntos()) {
                    Nave temp = flota[j];
                    flota[j] = flota[j + 1];
                    flota[j + 1] = temp;
                }
            }
        }
    }

    public static void ordenarPorNombreBurbuja(Nave[] flota) {
        for (int i = 0; i < flota.length - 1; i++) {
            for (int j = 0; j < flota.length - i - 1; j++) {
                if (flota[j] != null && flota[j + 1] != null && flota[j].getNombre().compareToIgnoreCase(flota[j + 1].getNombre()) > 0) {
                    Nave temp = flota[j];
                    flota[j] = flota[j + 1];
                    flota[j + 1] = temp;
                }
            }
        }
    }

    public static int busquedaBinariaNombre(Nave[] flota, String s) {
        Arrays.sort(flota, Comparator.comparing(Nave::getNombre)); 
        int baja = 0;
        int alta = flota.length - 1;

        while (baja <= alta) {
            int media = (baja + alta) / 2;
            if (flota[media] != null && flota[media].getNombre().equalsIgnoreCase(s)) {
                return media;
            } else if (flota[media] != null && flota[media].getNombre().compareToIgnoreCase(s) < 0) {
                baja = media + 1;
            } else {
                alta = media - 1;
            }
        }
        return -1;
    }

    public static void ordenarPorPuntosSeleccion(Nave[] flota) {
        for (int i = 0; i < flota.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < flota.length; j++) {
                if (flota[j] != null && flota[minIndex] != null && flota[j].getPuntos() < flota[minIndex].getPuntos()) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Nave temp = flota[i];
                flota[i] = flota[minIndex];
                flota[minIndex] = temp;
            }
        }
    }

    public static void ordenarPorNombreSeleccion(Nave[] flota) {
        for (int i = 0; i < flota.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < flota.length; j++) {
                if (flota[j] != null && flota[minIndex] != null && flota[j].getNombre().compareToIgnoreCase(flota[minIndex].getNombre()) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Nave temp = flota[i];
                flota[i] = flota[minIndex];
                flota[minIndex] = temp;
            }
        }
    }

    public static void ordenarPorPuntosInsercion(Nave[] flota) {
        for (int i = 1; i < flota.length; i++) {
            Nave key = flota[i];
            int j = i - 1;
            while (j >= 0 && flota[j] != null && key != null && flota[j].getPuntos() > key.getPuntos()) {
                flota[j + 1] = flota[j];
                j--;
            }
            flota[j + 1] = key;
        }
    }

    public static void ordenarPorNombreInsercion(Nave[] flota) {
        for (int i = 1; i < flota.length; i++) {
            Nave key = flota[i];
            int j = i - 1;
            while (j >= 0 && flota[j] != null && key != null && flota[j].getNombre().compareToIgnoreCase(key.getNombre()) > 0) {
                flota[j + 1] = flota[j];
                j--;
            }
            flota[j + 1] = key;
        }
    }

    public static Nave mostrarMayorPuntos(Nave[] flota) {
        Nave naveMayor = flota[0];
        for (int i = 1; i < flota.length; i++) {
            Nave nave = flota[i];
            if (nave != null && nave.getPuntos() > naveMayor.getPuntos()) {
                naveMayor = nave;
            }
        }
        return naveMayor;
    }

    public static void mostrarPorNombre(Nave[] flota) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese el nombre de la nave a buscar: ");
        String nombreBuscado = sc.next();

        boolean encontrado = false;
        for (Nave nave : flota) {
            if (nave != null && nave.getNombre().equalsIgnoreCase(nombreBuscado)) {
                System.out.println("Nave encontrada: " + nave.getNombre() + ", Fila: " + nave.getFila() +
                        ", Columna: " + nave.getColumna() + ", Estado: " + nave.getEstado() +
                        ", Puntos: " + nave.getPuntos());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ninguna nave con ese nombre.");
        }
    }

    public static void mostrarPorPuntos(Nave[] flota) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese el número de puntos: ");
        int puntosBuscados = sc.nextInt();

        System.out.println("Naves con puntos menores o iguales a " + puntosBuscados + ":");
        boolean encontrado = false;
        for (Nave nave : flota) {
            if (nave != null && nave.getPuntos() <= puntosBuscados) {
                System.out.println("Nombre: " + nave.getNombre() + ", Fila: " + nave.getFila() +
                        ", Columna: " + nave.getColumna() + ", Estado: " + nave.getEstado() +
                        ", Puntos: " + nave.getPuntos());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron naves con esos puntos.");
        }
    }
}
