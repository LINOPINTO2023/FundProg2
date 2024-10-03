import java.util.*;
public class DemoBatalla {
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

    public static Nave mostrarMayorPuntos(Nave[] flota) {
        Nave naveMayor = flota[0];

        for (int i = 1; i < flota.length; i++) {
            Nave nave = flota[i];
            if (nave.getPuntos() > naveMayor.getPuntos()) {
                naveMayor = nave;
            }
        }

        return naveMayor;
    }
    public static Nave[] desordenarNaves(Nave[] flota) {
        Nave[] desordenadas = new Nave[flota.length]; 
        System.arraycopy(flota, 0, desordenadas, 0, flota.length); 
        Random rand = new Random();
        for (int i = desordenadas.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Nave temp = desordenadas[i];
            desordenadas[i] = desordenadas[j];
            desordenadas[j] = temp;
        }

        return desordenadas; 
    }
}
