import java.util.Random;

public class EjercicioEjercitos {
    public static void main(String[] args) {
        Random random = new Random();
        int numSoldadosEjercito1 = random.nextInt(5) + 1; 
        int numSoldadosEjercito2 = random.nextInt(5) + 1; 

        Ejercito ejercito1 = new Ejercito(numSoldadosEjercito1);
        Ejercito ejercito2 = new Ejercito(numSoldadosEjercito2);
        System.out.println("Ejército 1:");
        mostrarEjercito(ejercito1);

        System.out.println("\nEjército 2:");
        mostrarEjercito(ejercito2);

        mostrarEjercitoGanador(ejercito1.getNumeroSoldados(), ejercito2.getNumeroSoldados());
    }
    public static void mostrarEjercito(Ejercito ejercito) {
        for (Soldado soldado : ejercito.getSoldados()) {
            System.out.println("Nombre: " + soldado.getNombre() + ", Nivel de vida: " + soldado.getNivelVida());
        }
    }

    public static void mostrarEjercitoGanador(int soldados1, int soldados2) {
        if (soldados1 > soldados2) {
            System.out.println("\nEjército 1 es el ganador con " + soldados1 + " soldados.");
        } else if (soldados2 > soldados1) {
            System.out.println("\nEjército 2 es el ganador con " + soldados2 + " soldados.");
        } else {
            System.out.println("\nEmpate: Ambos ejércitos tienen " + soldados1 + " soldados.");
        }
    }
}
