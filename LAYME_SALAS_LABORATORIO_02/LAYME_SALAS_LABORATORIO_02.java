/*PROPÓSITO: RECREAR EL JEUGO DEL AHORCADO
 * AUTOR: LAYME SALAS RODRIGO FABRICIO */
import java.util.*;
public class LAYME_SALAS_LABORATORIO_02 {
    public static void main(String[] args) {
        String ahor1 = "  +---+  \n" +
                "  |   |  \n" +
                "      |  \n" +
                "      |  \n" +
                "      |  \n" +
                "      |  \n" +
                "========= ";
        String ahor2 = "  +---+    \n" +
                "  |   |    \n" +
                "  O   |    \n" +
                "      |    \n" +
                "      |    \n" +
                "      |    \n" +
                "=========";
        String ahor3 = "  +---+    \n" +
                "  |   |    \n" +
                "  O   |    \n" +
                "  |   |    \n" +
                "      |    \n" +
                "      |    \n" +
                "=========";
        String ahor4 = "  +---+    \n" +
                "  |   |    \n" +
                "  O   |    \n" +
                " /|   |    \n" +
                "      |    \n" +
                "      |    \n" +
                "=========";
        String ahor5 = "  +---+    \n" +
                "  |   |    \n" +
                "  O   |    \n" +
                " /|\\  |    \n" +
                "      |    \n" +
                "      |    \n" +
                "=========";
        String ahor6 = "  +---+    \n" +
                "  |   |    \n" +
                "  O   |    \n" +
                " /|\\  |    \n" +
                " /    |    \n" +
                "      |    \n" +
                "=========";
        String ahor7 = "  +---+    \n" +
                "  |   |    \n" +
                "  O   |    \n" +
                " /|\\  |    \n" +
                " / \\  |    \n" +
                "      |    \n" +
                "=========";
    int contador = 1, intentosTotales = 0; //USO UNA VARIABLE PARA EL CONTROL DE VIDAS Y OTRO PARA CONTAR LOS INTENTOS DENTRO DEL JUEGO
    String letra;
    String[] figuras = { ahor1, ahor2, ahor3, ahor4, ahor5, ahor6, ahor7 }, palabras = { "programacion", "java", "indentacion", "clases",
    "objetos", "desarrollador", "pruebas" };
    String palSecreta = getPalabraSecreta(palabras);
    String[] palMatriz = new String[palSecreta.length()]; // EL USO DE UNA MATRIZ ME FACILITA LA ACTUALIZACIÓN DE LA PALABRA
    for(int i = 0; i<palMatriz.length; i++)
            palMatriz[i] = "_ ";
    System.out.println(figuras[0]);
    mostrarBlancos(palSecreta, palMatriz);
    System.out.println("\n");
    while (contador <= 6) { // MANTIENE EN BUCLE EL JUEGO HASTA QUE LA FIGURA 6 APAREZCA Y TERMINE EL JUEGO
        letra = ingreseLetra();
        if (letraEnPalabraSecreta(letra, palSecreta)){
            intentosTotales++;
            mostrarBlancosActualizados(letra, palSecreta, palMatriz);
            if(comprobarMatrizLlena(palMatriz) == true){ //SI RETORNA QUE SE COMPLETÓ LA PALABRA, TERMINA EL JEGO
                System.out.println("\nADIVINASTE LA PALABRA CON " + intentosTotales + " INTENTOS. ¡FELICIDADES!");
                break;
            }
        }
        else{ 
            System.out.println(figuras[contador]);
            contador+=1; //EL CONTADOR DE INTENTOS PERMITIDO AVANAZARÁ Y SI SE PASA SE TERMINA EL JUEGO CON LA ÚLTIMA IMAGEN
            intentosTotales++; 
            if(contador == 7)
                System.out.println("¡PERDISTE! La palabra era: " + palSecreta);
        }
    }
    }
    public static String getPalabraSecreta(String[] lasPalabras) { //RETORNA UNA PALABRA SECRETA PARA EMPEZAR EL JUEGO
        int ind, indiceMayor = lasPalabras.length-1, indiceMenor = 0;
        ind = (int)((Math.random()*(indiceMayor-indiceMenor+1)+indiceMenor));
        return lasPalabras[ind];
    }
    public static void mostrarBlancos(String palabra, String[] palMatriz) { // MUESTRA EL AVANCE DEL JUEGO
        for (int i = 0; i < palabra.length(); i++)
            System.out.print(palMatriz[i]);
    }
    public static String ingreseLetra() { // PIDE AL USUARIO INGRESAR UN DATO PARA EL JUEGO
        String laLetra;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIngrese letra: ");
        laLetra = sc.next();
        while (laLetra.length() != 1 || Character.isDigit(laLetra.charAt(0))){ // EL BUCLE CONTINUA HASTA QUE SE INGRESE SOLO UNA LETRA
            System.out.println("Dato erróneo, pruebe con 1 letra: ");
            laLetra = sc.next();
        }
        return laLetra;
    }
    public static boolean letraEnPalabraSecreta(String letra, String palSecreta){ // VERIFICA SI LA LETRA INGRESADA ESTÁ DENTRO DE LA PALABRA
        if(palSecreta.contains(letra))
            return true;
        return false;
    }
    public static void mostrarBlancosActualizados(String letra, String palSecreta, String[] palMatrix){ // CON AYUDA DE LA MATRIZ ACTUALIZA LOS BLANCOS
        int i = palSecreta.indexOf(letra);
        while(i<palSecreta.length()){ // ES UN BUCLE PARA ACTUALIZAR TODOS LOS ESPACIOS DONDE ESTÁ LA LETRA
            palMatrix[i] = letra;
            i = palSecreta.indexOf(letra, i+1);
            if(i == -1)
                break;
        }
        mostrarBlancos(palSecreta, palMatrix);
    }
    public static boolean comprobarMatrizLlena(String[] palMatriz){ // SE COMPRUEBA SI SE COMPLETÓ LA PALABRA PARA TERMINAR EL JUEGO 
        for(int i = 0 ; i<palMatriz.length; i++){
            if(palMatriz[i].equals("_ "))
                return false;
        }
        return true;
    }
}