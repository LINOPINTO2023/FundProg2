/*
  Autor: Santiago Palma Apaza
  juego del ahorcado
*/
package labFP2;

import java.util.*;

public class Ahorcado {

    public static void main(String[] args) {
        String etapa1 = """
                        +---+ 
                        |   | 
                            | 
                            | 
                            | 
                            | 
                       ========= """;
        String etapa2 = """
                        +---+ 
                        |   | 
                        O   | 
                            | 
                            | 
                            | 
                       =========""";
        String etapa3 = """
                        +---+ 
                        |   | 
                        O   | 
                        |   | 
                            | 
                            | 
                       =========""";
        String etapa4 = """
                        +---+ 
                        |   | 
                        O   | 
                       /|   | 
                            | 
                            | 
                       =========""";
        String etapa5 = """
                        +---+ 
                        |   | 
                        O   | 
                       /|\\  | 
                            | 
                            | 
                       =========""";
        String etapa6 = """
                        +---+ 
                        |   | 
                        O   | 
                       /|\\  | 
                       /    | 
                            | 
                       =========""";
        String etapa7 = """
                        +---+ 
                        |   | 
                        O   | 
                       /|\\  | 
                       / \\  | 
                            | 
                       =========""";
        
        String[] fasesJuego = {etapa1, etapa2, etapa3, etapa4, etapa5, etapa6, etapa7}; 
        int intentosFallidos = 0; 
        String intento; 
        String[] listaPalabras = {"codificacion", "python", "herencia", "objetos", "computadora", "tecnologia", "depuracion"};
        
        String palabraOculta = seleccionarPalabraAleatoria(listaPalabras); 
        boolean[] letrasDescubiertas = new boolean[palabraOculta.length()];
        
        System.out.println(fasesJuego[0]); 
        mostrarPalabraOculta(palabraOculta, letrasDescubiertas);
        System.out.println("\n");
        
        while (intentosFallidos < 6 && !esJuegoFinalizado(letrasDescubiertas)) {
            intento = ingresarLetra();
            if (existeLetraEnPalabra(intento, palabraOculta))
                actualizarLetrasDescubiertas(intento, palabraOculta, letrasDescubiertas);
            else {
                intentosFallidos++;
                System.out.println(fasesJuego[intentosFallidos]);
            }
            mostrarPalabraOculta(palabraOculta, letrasDescubiertas);
            System.out.println("\n");
        }

        if (esJuegoFinalizado(letrasDescubiertas)) {
            System.out.println("Has adivinado la palabra.");
        } else {
            System.out.println("Has perdido");
        }
    }

    public static String seleccionarPalabraAleatoria(String[] opciones) {
        int indiceAleatorio = (int) (Math.random() * opciones.length);
        return opciones[indiceAleatorio];
    }
    public static void mostrarPalabraOculta(String palabra, boolean[] descubiertas) {
        for (int i = 0; i < palabra.length(); i++) {
            if (descubiertas[i]) {
                System.out.print(palabra.charAt(i) + " ");
            } else {
                System.out.print("_ ");
            }
        }
    }
    public static String ingresarLetra() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa una letra: ");
        String letra = teclado.next();

        while (letra.length() != 1 || !Character.isLetter(letra.charAt(0))) {
            System.out.println("ingrese una letra válida: ");
            letra = teclado.next();
        }
        
        return letra;
    }

    public static boolean existeLetraEnPalabra(String letra, String palabraSecreta) {
        return palabraSecreta.contains(letra);
    }

    public static void actualizarLetrasDescubiertas(String letra, String palabraSecreta, boolean[] descubiertas) {
        System.out.println("Verificando...");
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (letra.charAt(0) == palabraSecreta.charAt(i)) {
                descubiertas[i] = true;
            }
        }
    }

    public static boolean esJuegoFinalizado(boolean[] descubiertas) {
        for (boolean letraDescubierta : descubiertas) {
            if (!letraDescubierta) {
                return false;
            }
        }
        return true;
    }
}
