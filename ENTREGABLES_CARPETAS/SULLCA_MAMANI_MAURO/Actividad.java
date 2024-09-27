
/**
 *
 * @author Mauro Snayder
 */
import java.util.*;

public class Activividad {
    public static void main(String []args){ 
        String ahor1 =  "  +---+  \n"+ 
                        "  |   |  \n" + 
                        "      |  \n" +  
                        "      |  \n" + 
                        "      |  \n" +  
                        "      |  \n" + 
                        "========= "; 
        String ahor2 =  "  +---+    \n"+ 
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
        String ahor5 =  "  +---+    \n"+ 
                        "  |   |    \n"+ 
                        "  O   |    \n"+ 
                        " /|\\ |    \n"+ 
                        "      |    \n"+ 
                        "      |    \n"+ 
                        "========="; 
        String ahor6 =  "  +---+    \n"+ 
                        "  |   |    \n"+ 
                        "  O   |    \n"+ 
                        " /|\\ |    \n"+ 
                        " /    |    \n"+ 
                        "      |    \n"+ 
                        "========="; 
        String ahor7 =  "  +---+    \n"+ 
                        "  |   |    \n"+ 
                        "  O   |    \n"+ 
                        " /|\\ |    \n"+ 
                        " / \\ |    \n"+ 
                        "      |    \n"+ 
                        "=========";
        String [] figuras = {ahor1, ahor2, ahor3, ahor4, ahor5, ahor6, ahor7}; 
        int contador=1; 
        String letra; 
        String [] palabras = {"programacion", "java", "indentacion", "clases","objetos",
                                "desarrollador", "pruebas"}; 
        String palSecreta = getPalabraSecreta(palabras);
        // PalabraInc: Almacena en un arreglo tipo "char" las letras correctas que ingresa el usuario.
        Character[] palabraInc=new Character[palSecreta.length()];
        // Ponemos subguiones a todos los espacios del arreglo, para que este luego sea completado.
        for(int i=0;i<palabraInc.length;i++)
            palabraInc[i]='_';
        System.out.println(figuras[0]); 
        mostrarBlancos(palSecreta); 
        System.out.println("\n"); 
        while(contador <= 6){    
            letra=ingreseLetra(palabraInc); 
            if (letraEnPalabraSecreta(letra, palSecreta)){
                // Si la letra pertenece a la palabra secreta, entonces
                // actualizamos el arreglo "palabraInc"
                mostrarBlancosActualizados(letra,palSecreta,palabraInc);
                // si ya no hay subguiones en el arreglo entonces gana el usuario.
                if (palabraCompleta(palabraInc)) {
                    System.out.println("\nUsted gano");
                    break;
                }
            }
            else{
                System.out.println(figuras[contador]);
                mostrarBlancosActualizados(letra,palSecreta,palabraInc);
                contador=contador+1;
            }
        }
        // El contador inicia con 1, y si despues falla sus 6 intentos entonces pierde el juego.
        if (contador==7)
            System.out.println("\nUsted perdio");
    }
    public static String getPalabraSecreta(String [] lasPalabras){ 
        int ind; 
        int indiceMayor=lasPalabras.length -1; 
        int indiceMenor=0; 
        ind = (int) ((Math.random()*(indiceMayor-indiceMenor+1)+indiceMenor)); 
        return lasPalabras[ind];   
    } 
    public static void mostrarBlancos(String palabra) { 
        for(int i=0; i< palabra.length(); i++) 
         System.out.print("_ " );   
    } 
    public static String ingreseLetra(Character[] palabraInc){ 
        String laLetra; 
        Scanner sc=new Scanner(System.in); 
        System.out.print("\nIngrese letra: "); 
        laLetra=sc.next();
        // Con este bucle y condicion, estamos validando que no se ingrese letras correctas que
        // el usuario ya ingreso anteriormente.
        for(int i=0;i<palabraInc.length;i++){
            if(laLetra.charAt(0)==palabraInc[i]){
                System.out.println("Error usted ya ingreso esta letra.");
                laLetra="-1";
            }
        }
        // Estamos validando que el usuario no haya ingresado una cadena de mas de una letra o un numero.
        while(laLetra.length()!= 1 || Character.isDigit(laLetra.charAt(0)) ){
            System.out.print("Error, Ingrese letra: ");
            laLetra = sc.next(); 
        }
        return laLetra; 
    } 
    public static boolean letraEnPalabraSecreta(String letra, String palSecreta ){
        // Con charAt() accedemos a una letra de la palabra secreta y lo comparamos con la letra que ingresó el
        // usuario, si son iguales retornamos True; caso contrario, False.
        for (int j=0;j<palSecreta.length();j++){
            if (letra.charAt(0)==palSecreta.charAt(j))
                return true;
        }
        return false; 
    } 
    public static void mostrarBlancosActualizados(String letra,String palSecreta,Character[] palabraInc){
        // Creamos un nuevo arrreglo temporal para copiar el arreglo "palabraInc"
        // Esto nos servirá para que no se pierdan el progreso cuando el usuario ingrese otra letra correcta. 
        Character[] actualizar=new Character[palSecreta.length()];
        System.arraycopy(palabraInc,0,actualizar,0,palabraInc.length);
        // Introducimos al arreglo temporal la letra que ingresó el usuario.
        for(int j=0;j<actualizar.length;j++){
            if (letra.charAt(0)==palSecreta.charAt(j))
                actualizar[j]=letra.charAt(0);
            // Imprimimos el arreglo con las palabras que el usuario ingreso.
            System.out.print(actualizar[j]+" "); 
        }
        // Actualizamos el arreglo "palabraInc" con la letra correcta que ingreso el usuario.
        System.arraycopy(actualizar,0,palabraInc,0,actualizar.length);
    }
    public static boolean palabraCompleta(Character[] palabraInc) {
        // Verificamos que no haya subguiones en el arreglo "palabraInc", para así
        // llegar a la conclusion de queel usuario completó toda la palabra secreta.
        for (int i=0;i<palabraInc.length;i++){
            if (palabraInc[i]=='_')
                return false;
        }
        return true;
    }
}