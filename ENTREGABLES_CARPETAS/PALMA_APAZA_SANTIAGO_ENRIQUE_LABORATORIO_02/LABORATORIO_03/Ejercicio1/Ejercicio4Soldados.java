import java.util.Scanner;

public class Ejercicio4Soldados {
    public static void main(String[] args) {
        Soldado[] soldados = new Soldado[5];
        Scanner sc = new Scanner(System.in);
      
        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese el nombre del Soldado " + (i + 1) + ": ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese el nivel de vida del Soldado " + (i + 1) + ": ");
            int nivelVida = sc.nextInt();
            sc.nextLine(); 
            soldados[i] = new Soldado(nombre, nivelVida);
        }
        System.out.println("\nDatos de los soldados:");
        for (Soldado soldado : soldados) {
            System.out.println("Soldado: " + soldado.getNombre() + ", Nivel de vida: " + soldado.getNivelVida());
        }

        sc.close();
    }
}
