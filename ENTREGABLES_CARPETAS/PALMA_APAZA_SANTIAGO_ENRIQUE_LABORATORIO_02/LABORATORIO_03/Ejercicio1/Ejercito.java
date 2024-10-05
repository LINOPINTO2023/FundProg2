import java.util.Random;

public class Ejercito {
    private Soldado[] soldados;

    public Ejercito(int numSoldados) {
        soldados = new Soldado[numSoldados];
        inicializarEjercito();
    }

    private void inicializarEjercito() {
        for (int i = 0; i < soldados.length; i++) {
            String nombre = "Soldado" + i;
            soldados[i] = new Soldado(nombre, 100); 
        }
    }

    public Soldado[] getSoldados() {
        return soldados;
    }

    public int getNumeroSoldados() {
        return soldados.length;
    }
}
