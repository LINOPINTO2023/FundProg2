/* Laboratorio Nro 02 - Ejercicio 01
Autor: Karla Bedregal Coaguila */
package bedregal_karla_lab2;
// Version del ahorcado al 70%
import java.util.Scanner;
public class Ejercicio01 {
    public static void main(String []args){
        //Figuras del ahorcado
        String ahor1 = " +---+  \n"+
                       " |   |  \n" +
                       "     |  \n" +
                       "     |  \n" +
                       "     |  \n" +
                       "     |  \n" +
                       "========= ";
        String ahor2 = " +---+ \n"+
                       " |   | \n"+
                       " O   | \n"+
                       "     | \n"+
                       "     | \n"+
                       "     | \n"+
                       "=========";

        String ahor3 = " +---+ \n"+
                       " |   | \n"+
                       " O   | \n"+
                       " |   | \n"+
                       "     | \n"+
                       "     | \n"+
                       "=========";

        String ahor4 = " +---+ \n"+
                       "  |  | \n"+
                       "  O  | \n"+
                       " /|  | \n"+
                       "     | \n"+
                       "     | \n"+    
                       "=========";

        String ahor5 = " +---+ \n"+
                       "  |  | \n"+
                       "  O  | \n"+
                       " /|\\| \n"+
                       "     | \n"+
                       "     | \n"+
                       "=========";

        String ahor6 = " +---+ \n"+
                       "  |  | \n"+
                       "  O  | \n"+
                       " /|\\| \n"+
                       " /   | \n"+
                       "     | \n"+
                       "=========";

        String ahor7 = " +---+ \n"+
                       " |   | \n"+
                       " O   | \n"+
                       " /|\\| \n"+
                       " / \\| \n"+
                       "     | \n"+
                       "=========";
        
        //Arreglo de figuras
        String [] figuras = {ahor1, ahor2, ahor3, ahor4, ahor5, ahor6, ahor7};
        int contador = 0; //Inicializar en 0 para comenzar el juego
        String letra;
        //Palabras clave del juego
        String [] palabras = {"programacion", "java", "indentacion", "clases",
        "objetos", "desarrollador", "pruebas"};
        
        //Obtener una palabra aleatoria
        String palSecreta = getPalabraSecreta(palabras);
        
        //Arreglo que almacena las letras correctas que se ingresaron
        char[] letrasCorrectas = new char[palSecreta.length()];
        for (int i = 0; i < letrasCorrectas.length; i++) {
            letrasCorrectas[i] = '_'; //Representar en lineas las letras no adivinadas
        }
        // Bucle principal del juego
        while(contador < 6){
            System.out.println(figuras[contador]); //Imprimir las imagenes del ahorcado
            mostrarBlancos(letrasCorrectas); //Mostrar espacios de la palabra
            System.out.println("\n"); 
            letra = ingreseLetra(); //Pedir al usuario que adivine una letra
            if (letraEnPalabraSecreta(letra, palSecreta)){
                mostrarBlancosActualizados(letra, palSecreta, letrasCorrectas);
                //Verificar si el arreglo de letras correctas es igual a la palabra secreta
                if (new String(letrasCorrectas).equals(palSecreta)) {
                    System.out.println("GANO - La palabra es " + palSecreta); //Mensaje de que ganó
                    return; //Salir del juego
                }
            } else {
                contador = contador + 1; //Sumar los intentos fallidos
            }
        }
        System.out.println(figuras[contador]);
        System.out.println("PERDIO - La palabra era " + palSecreta); //Mensaje de que perdió
    }    
    
    //Método para obtener una palabra aleatoria del juego
    public static String getPalabraSecreta(String [] lasPalabras){
        int ind; //Almacenaremos el índice de la palabra aleatoria
        int indiceMayor = lasPalabras.length - 1;   //Ultimo índice del arreglo
        int indiceMenor = 0; //Primer índice
        ind = (int) (Math.random() * (indiceMayor - indiceMenor + 1) + indiceMenor);
        return lasPalabras[ind]; //REtornar la palabra random
    }
    
    //Método para mostrar las lineas blancas del juego
    public static void mostrarBlancos(char [] letrasCorrectas){
        for(int i = 0; i< letrasCorrectas.length; i++) {
        System.out.print(letrasCorrectas[i] + " " ); //Mostrar las letras o espacios
        }
    }
    
    //Método para ingresar y verificar si es una letra
    public static String ingreseLetra(){
        String laLetra;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese letra: ");
        laLetra = sc.next();
        //Verificar si es una sola letra 
        while(laLetra.length()!= 1 || !Character.isLetter(laLetra.charAt(0))){ //PLETAR PARA VALIDAR CARACTERES PERMITIDOS a-z
            System.out.println("ERROR - Ingrese una letra válida"); //Mensaje de error
            laLetra = sc.next(); //Se pide una nueva letra
        }
        return laLetra; //Retornar la letra que se ingresó
    }
    
    //Método para comparar las letras ingresadas con la palabra 
    public static boolean letraEnPalabraSecreta(String letra, String palSecreta){
        for (int i = 0; i < palSecreta.length(); i++) {
            if (palSecreta.charAt(i) == letra.charAt(0)) {
                return true; //Se encontró la letra
            }    
        }
        return false; //No se encontró la letra
    }
    
    //Método para mostrar los blancos de las letras que aún faltan
    public static void mostrarBlancosActualizados(String letra, String palSecreta, char[] letrasCorrectas){
        System.out.println("PROCESANDO.....");
        for (int i = 0; i < palSecreta.length(); i++) {
            if (palSecreta.charAt(i) == letra.charAt(0)) {
                letrasCorrectas[i] = letra.charAt(0); //Actualizar la letra que era correcta
            } 
        }
    }      
}