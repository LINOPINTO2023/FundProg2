import java.util.*;
public class Ejercicio01 {
    public static void main(String[] args) {
        Scanner nay = new Scanner(System.in);
        String ahor1 = "  +---+  \n" + 
                       "  |   |  \n" + 
                       "      |  \n" + 
                       "      |  \n" + 
                       "      |  \n" + 
                       "      |  \n" + 
                       "========= ";

        String ahor2 = "  +---+  \n" + 
                       "  |   |  \n" + 
                       "  O   |  \n" + 
                       "      |  \n" + 
                       "      |  \n" + 
                       "      |  \n" + 
                       "========= ";

        String ahor3 = "  +---+  \n" + 
                       "  |   |  \n" + 
                       "  O   |  \n" + 
                       "  |   |  \n" + 
                       "      |  \n" + 
                       "      |  \n" + 
                       "========= ";

        String ahor4 = "  +---+  \n" + 
                       "  |   |  \n" + 
                       "  O   |  \n" + 
                       " /|   |  \n" + 
                       "      |  \n" + 
                       "      |  \n" + 
                       "========= ";

        String ahor5 = "  +---+  \n" + 
                       "  |   |  \n" + 
                       "  O   |  \n" + 
                       " /|\\  |  \n" + 
                       "      |  \n" + 
                       "      |  \n" + 
                       "========= ";

        String ahor6 = "  +---+  \n" + 
                       "  |   |  \n" + 
                       "  O   |  \n" + 
                       " /|\\  |  \n" + 
                       " /    |  \n" + 
                       "      |  \n" + 
                       "========= ";

        String ahor7 = "  +---+  \n" + 
                       "  |   |  \n" + 
                       "  O   |  \n" + 
                       " /|\\  |  \n" + 
                       " / \\  |  \n" + 
                       "      |  \n" + 
                       "========= ";

        String[] figuras = {ahor1, ahor2, ahor3, ahor4, ahor5, ahor6, ahor7};

        // Creamos un contador donde se almacenan las fallas del Usuario
        int contador = 0;

        String[] palabras = {"programacion", "java", "indentacion", "clases", "objetos", "desarrollador", "pruebas"};

        // Seleccionamos una palabra al azar
        String palSecreta = getPalabraSecreta(palabras);

        char[] progreso = new char[palSecreta.length()];

        // Iniciamos el proceso con guiones bajos para que el Usuario adivine la palabra
        for (int i = 0; i < progreso.length; i++) {
            progreso[i] = '_';
        }

        // Creamos esta variable para saber si el Usuario logró adivinar la palabra
        boolean palabraAdivinada = false;

        // Este bucle se repite hasta que el Usuario cometa 6 errores o no adivine la palabra correspondiente
        while (contador < 6 && !palabraAdivinada) {
            // Aquí mostramos la figura del ahorcado después de los fallos del jugador
            System.out.println(figuras[contador]);

            // Con este método mostramos el proceso del jugador
            mostrarProgreso(progreso);
            System.out.println("\n");

            // Vammo a solicitar al Usuario que ingrese una letra
            String letra = ingreseLetra(nay);

            //Si la letra se encuentra en la palabra secreta, la actualizamos
            if (letraEnPalabraSecreta(letra, palSecreta)) {
                actualizarProgreso(progreso, letra, palSecreta);
                // Aquí vamos a verificar si el Usuario adivino toda la palabra
                palabraAdivinada = !contieneGuiones(progreso);
            } else {
                contador++;
            }
        }

        // Si el jugador adivina la palabra, mostramos un mensaje 
        if (palabraAdivinada) {
            System.out.println("¡Felicidades! Adivinaste la palabra: " + palSecreta);
        } else {
            // Si el Usuario falla 6 veces, se muestra la última figura del ahorcado y la palabra 
            System.out.println(figuras[6]);
            System.out.println("Has perdido. La palabra era: " + palSecreta);
        }
        nay.close();
    }

    // Método que selecciona una palabra aleatoria 
    public static String getPalabraSecreta(String[] lasPalabras) {
        int indice = (int) (Math.random() * lasPalabras.length); // Selecciona un índice aleatorio
        return lasPalabras[indice]; // Retorna la palabra seleccionada
    }

    public static void mostrarProgreso(char[] progreso) {
        for (char c : progreso) {
            System.out.print(c + " "); // Imprime cada letra o guion con un espacio entre ellos
        }
    }
    public static String ingreseLetra(Scanner nay) {
        String laLetra;
        do {
            System.out.print    ("Ingrese una letra: ");
            laLetra = nay.next().toLowerCase(); // Lee la letra y la convierte a minúscula
    
            // Revisa que el Usuario solo ingrese letras entre 'a' y 'z'
            if (laLetra.length() != 1 || laLetra.charAt(0) < 'a' || laLetra.charAt(0) > 'z') {
                System.out.println("Por favor, ingrese solo una letra válida (a-z).");
            }
        } while (laLetra.length() != 1 || laLetra.charAt(0) < 'a' 
        || laLetra.charAt(0) > 'z'); // Repite hasta que la entrada sea válida
    
        return laLetra;
    }    

    // Aquí se verifica si la letra esta en la palabra anónima
    public static boolean letraEnPalabraSecreta(String letra, String palSecreta) {
        return palSecreta.contains(letra); // Retorna true si la letra está en la palabra, de lo contrario false
    }

    // Método que actualiza el progreso del Usuario
    public static void actualizarProgreso(char[] progreso, String letra, String palSecreta) {
        char charLetra = letra.charAt(0); // Convierte la letra a char
        // Recorre toda la letra y actualiza las coincidencias 
        for (int i = 0; i < palSecreta.length(); i++) {
            if (palSecreta.charAt(i) == charLetra) {
                progreso[i] = charLetra;
            }
        }
    }

    // Aquí se verifica si todavía hay letras por adivinar de la palabra anónima
    public static boolean contieneGuiones(char[] progreso) {
        for (char c : progreso) {
            if (c == '_') {
                return true; // Si hay guiones, retorna true
            }
        }
        return false; // Caso contrario, retorna false
    }
}
