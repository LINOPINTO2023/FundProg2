package homework2;

import java.util.*;

public class exercise1 {
    public static void main(String[] args) {
        String ahor1 = "  +---+  \n"+
                       "  |   |  \n" + 
                       "      |  \n" +  
                       "      |  \n" + 
                       "      |  \n" +  
                       "      |  \n" + 
                       "========= "; 

        String ahor2 = "  +---+    \n"+
                       "  |   |    \n"+
                       "  O   |    \n"+
                       "      |    \n"+ 
                       "      |    \n"+ 
                       "      |    \n"+ 
                       "========="; 

        String ahor3 = "  +---+    \n"+
                       "  |   |    \n"+
                       "  O   |    \n"+
                       "  |   |    \n"+ 
                       "      |    \n"+ 
                       "      |    \n"+ 
                       "========="; 

        String ahor4 = "  +---+    \n"+
                       "  |   |    \n"+
                       "  O   |    \n"+
                       " /|   |    \n"+ 
                       "      |    \n"+ 
                       "      |    \n"+ 
                       "========="; 

        String ahor5 = "  +---+    \n"+
                       "  |   |    \n"+
                       "  O   |    \n"+
                       " /|\\ |    \n"+ 
                       "      |    \n"+ 
                       "      |    \n"+ 
                       "========="; 

        String ahor6 = "  +---+    \n"+
                       "  |   |    \n"+
                       "  O   |    \n"+
                       " /|\\ |    \n"+ 
                       " /    |    \n"+ 
                       "      |    \n"+ 
                       "========="; 

        String ahor7 = "  +---+    \n"+
                       "  |   |    \n"+
                       "  O   |    \n"+
                       " /|\\ |    \n"+ 
                       " / \\ |    \n"+ 
                       "      |    \n"+ 
                       "========="; 

        String[] figuras = {ahor1, ahor2, ahor3, ahor4, ahor5, ahor6, ahor7}; 
        int contador = 0, intentos = 0; 
        char letra; 
        String[] palabras = {"programacion", "java", "indentacion", "clases", "objetos", "desarrollador", "pruebas"}; 
        String palSecreta = getPalabraSecreta(palabras); 
        System.out.println(figuras[0]); 
        
        char[] avance = new char[palSecreta.length()];
        for (int i = 0; i < avance.length; i++){
            avance[i] = '_';
        }
        mostrarBlancos(avance); 
        System.out.println("\n"); 
        
        while(contador < 6 && !palabraCompleta(avance)) {    
            letra = ingreseLetra(); 
            intentos++;
            if (letraEnPalabraSecreta(letra, palSecreta)) {
                actualizar(avance, letra, palSecreta);
                mostrarBlancosActualizados(avance); 
            } else {
                contador++;
                System.out.println(figuras[contador]); 
                mostrarBlancosActualizados(avance);
            }
            System.out.println("\nIntentos restantes: " + (6 - contador));
        }
        
        if (palabraCompleta(avance))
            System.out.println("\n¡GANASTE!, en " + intentos + " intentos.");
        else
            System.out.println("\nPERDISTE La palabra era: " + palSecreta 
            + "\nIntentos: " + intentos);
    }
    
    public static String getPalabraSecreta(String[] lasPalabras){ 
        int ind; 
        int indiceMayor = lasPalabras.length - 1; 
        int indiceMenor = 0; 
        ind = (int) ((Math.random() * (indiceMayor - indiceMenor + 1)) + indiceMenor); 
        return lasPalabras[ind];   
    }

    public static void mostrarBlancos(char[] avance) { 
        for (int i = 0; i < avance.length; i++){
            System.out.print(" " + avance[i] + " ");
        }
    }

    public static char ingreseLetra(){ 
        char laLetra; 
        Scanner sc = new Scanner(System.in); 
        System.out.print("\nIngrese letra: "); 
        laLetra = sc.next().charAt(0); 
        while (!letraAlfabeto(laLetra)) { 
            System.out.print("Caracter no valido\nIngrese letra: ");  
            laLetra = sc.next().charAt(0);       
        }
        return laLetra; 
    }
    
    public static boolean letraAlfabeto(char laLetra){
        return laLetra >= 'a' && laLetra <= 'z';
    }

    public static boolean letraEnPalabraSecreta(char letra, String palSecreta){ 
        for(int i = 0; i < palSecreta.length(); i++)
            if(letra == palSecreta.charAt(i)){
            return true;
            }
        return false; 
    }

    public static void mostrarBlancosActualizados(char [] avance){ 
        for (int i = 0; i < avance.length; i++) {
            System.out.print(" " + avance[i] + " ");   
        }
    }

    public static void actualizar(char [] avance, char letra, String palSecreta){
        for (int i = 0; i < avance.length; i++ ){
            if(letra == palSecreta.charAt(i))
                avance[i] = letra;
        }
    }
    
    public static boolean palabraCompleta(char[] avance) {
        for (int i = 0; i < avance.length; i++) {
            if (avance[i] == '_')
                return false;
        }
        return true;
    }
}