/*
  Autor: Chipana Jeronimo German Arturo
  Proposito: Ejercicio 1 (JUEGO DEL AHORCADO)
*/
package ejercicio1lab02;

import java.util.*;
public class Ejercicio1Lab02 {

    public static void main(String[] args) {
        // Definición de las diferentes etapas del dibujo del ahorcado
        String ahor1 = """
                        +---+ 
                        | | 
                        | 
                        | 
                        | 
                        | 
                       ========= """;
        String ahor2 = """
                        +---+ 
                        | | 
                        O | 
                        | 
                        | 
                        | 
                       =========""";
        String ahor3 = """
                        +---+ 
                        | | 
                        O | 
                        | | 
                        | 
                        | 
                       =========""";
        String ahor4 = """
                        +---+ 
                        | | 
                        O | 
                       /| | 
                        | 
                        | 
                       =========""";
        String ahor5 = """
                        +---+ 
                        | | 
                        O | 
                       /|\\ | 
                        | 
                        | 
                       =========""";
        String ahor6 = """
                        +---+ 
                        | | 
                        O | 
                       /|\\ | 
                        / | 
                        | 
                       =========""";
        String ahor7 = """
                        +---+ 
                        | | 
                        O | 
                       /|\\ | 
                       / \\ | 
                        | 
                       =========""";
        String [] figuras = {ahor1, ahor2, ahor3, ahor4, ahor5, ahor6, ahor7}; // Arreglo que contiene todas las figuras del ahorcado.
        int contador = 0; // Contador de errores (número de intentos fallidos)
        String letra; // Variable para almacenar la letra ingresada por el usuario.
        // Arreglo de palabras posibles para el juego.
        String [] palabras = {"programacion", "java", "indentacion", "clases",
         "objetos", "desarrollador", "pruebas"};   
        String palSecreta = getPalabraSecreta(palabras); // Selección aleatoria de la palabra secreta.
        boolean[] aciertos = new boolean[palSecreta.length()]; // Arreglo booleano para rastrear las letras acertadas.
        System.out.println(figuras[0]); // Muestra la primera figura del ahorcado.
        mostrarBlancos(palSecreta,aciertos);  // Muestra la palabra secreta con letras ocultas.
        System.out.println("\n");
        // Bucle principal del juego que continúa hasta que se alcance el límite de errores
        // o se adivine la palabra completa.
        while(contador < 6 && !juegoTerminado(aciertos)){
            letra = ingreseLetra();
            if (letraEnPalabraSecreta(letra, palSecreta))
                // Si la letra está en la palabra secreta, actualiza los aciertos.
                actualizarBlancos(letra,palSecreta,aciertos);
            else{
                // Si la letra no está, incrementa el contador de errores y muestra la siguiente figura.
                contador = contador +1;
                System.out.println(figuras[contador]);
            }
            // Muestra la palabra con las letras acertadas hasta el momento.
            mostrarBlancos(palSecreta, aciertos);
            System.out.println("\n");
        }
         System.out.println("\n");
        // Verifica si el juego terminó por adivinar la palabra o por agotar los intentos.
        if (juegoTerminado(aciertos)) {
            System.out.println("Felicidades! Has adivinado la palabra.");
        } 
        else {
            System.out.println("Lo siento, has perdido. La palabra era: " + palSecreta);
        }
    }
    // Método para seleccionar aleatoriamente una palabra secreta del arreglo proporcionado.  
    public static String getPalabraSecreta(String [] lasPalabras){
        String palSecreta;
        int ind;
        int indiceMayor = lasPalabras.length -1;
        int indiceMenor =0;
        ind = (int) ((Math.random() * (indiceMayor - indiceMenor + 1) + indiceMenor));
        return lasPalabras[ind]; // Retorna una palabra seleccionada aleatoriamente.
    }   
    // Método para mostrar la palabra secreta con letras acertadas y espacios en blanco.
    public static void mostrarBlancos(String palabra, boolean[] aciertos){
        for (int i = 0; i < palabra.length(); i++) {
            if (aciertos[i]) {
                System.out.print(palabra.charAt(i) + " ");
            } else {
                System.out.print("_ ");
            }
        }
    }
    // Método para solicitar al usuario que ingrese una letra válida.
    public static String ingreseLetra(){
        String laLetra;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese letra: ");
        laLetra = sc.next();
        //Valida que el usuario ingrese solo una letra y que sea una letra del alfabeto.
        while(laLetra.length()!= 1 || !Character.isLetter(laLetra.charAt(0))){ 
            System.out.println("Ingrese letra valida: ");
            laLetra = sc.next();
        }
         return laLetra; //Retorna la letra ingresada por el usuario.
    }
    // Método para verificar si una letra está presente en la palabra secreta.
    public static boolean letraEnPalabraSecreta(String letra, String palSecreta ){
        for(int i=0;i<palSecreta.length();i++){
            if(palSecreta.charAt(i)==letra.charAt(0))
                return true; // Retorna true si la letra se encuentra en la palabra.                      
        }
        return false; // Retorna false si la letra no se encuentra.
    }
    // Método para actualizar el arreglo de aciertos con la letra acertada.
    public static void actualizarBlancos(String letra,String palSecreta, boolean[] aciertos){      
        System.out.println("PROCESANDO.....");
        for(int i=0; i< palSecreta.length(); i++){
            if(letra.charAt(0)==palSecreta.charAt(i)){
                aciertos[i]=true; // Marca la posición como acertada. 
            }
        }
    }
    // Método para verificar si el juego ha terminado, es decir, si todas las letras han sido acertadas.
    public static boolean juegoTerminado(boolean[] aciertos) {
        for (boolean acierto : aciertos) {
            if (!acierto) {
                return false; // Retorna false si hay al menos una letra sin acertar.
            }
        }
        return true; // Retorna true si todas las letras han sido acertadas.
    }           
}


