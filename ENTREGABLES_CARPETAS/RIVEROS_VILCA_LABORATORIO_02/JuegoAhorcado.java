import java.util.Scanner;
public class JuegoAhorcado {
    public static void main(String []args) {
        String ahor1 = """
                 +---+
                 |   |
                     |
                     |
                     |
                     |
                =========""";
        String ahor2 = """
                 +---+
                 |   |
                 O   |
                     |
                     |
                     |
                =========""";
        String ahor3 = """
                 +---+
                 |   |
                 O   |
                 |   |
                     |
                     |
                =========""";
        String ahor4 = """
                 +---+
                 |   |
                 O   |
                /|   |
                     |
                     |
                =========""";
        String ahor5 = """
                 +---+
                 |   |
                 O   |
                /|\\ |
                     |
                     |
                =========""";
        String ahor6 = """
                 +---+
                 |   |
                 O   |
                /|\\  |
                /    |
                     |
                =========""";
        String ahor7 = """
                 +---+
                 |   |
                 O   |
                /|\\  |
                / \\  |
                     |
                =========""";
        String[] figuras = {ahor1, ahor2, ahor3, ahor4, ahor5, ahor6, ahor7};
        int errores = 0;
        int intentosEmpleados = 0;
        char letra;
        String adivinado = "";
        String[] palabras = {"programacion", "java", "indentacion", "clases",
                "objetos", "desarrollador", "pruebas"};
        String palSecreta = getPalabraSecreta(palabras);
        for (int i = 0; i < palSecreta.length(); i++) {
            adivinado += "_";
        }
        System.out.println(figuras[0]);
        mostrarBlancos(palSecreta);
        System.out.println("\n");
        /*Verifica que aún no haya adivinado la palabra y este dentro de los
        errores permitidos para el bucle while*/
        while (errores < 6 && !adivinado.equals(palSecreta)) {
            letra = ingreseLetra();
            intentosEmpleados++;
            if (letraEnPalabraSecreta(letra, palSecreta)) {
                adivinado = mostrarBlancosActualizados(letra, palSecreta, adivinado);
                System.out.println("Acertaste una letra :D");
                System.out.println(adivinado);
            } else {
                System.out.println(figuras[errores+1]);
                errores++;
                System.out.println(adivinado);
                System.out.println("No acertaste :c");
                System.out.println("Intentos restantes: " + (6              - errores) + "\n");
            }
        }
        //Verificamos si se adivino la palabra e imprimimos el mensaje correspondiente
        if(adivinado.equals(palSecreta)){
            System.out.println("¡Usted ganó en " + intentosEmpleados + " intentos!");
        }else{
            System.out.println("Usted perdió. La palabra era: " + palSecreta);
        }
    }
    public static String getPalabraSecreta(String [] lasPalabras){
        /*Se escoge aleatoriamente la palabra Secreta de todas las disponibles*/
        int ind = (int) (Math.random() * (lasPalabras.length));
        return lasPalabras[ind];
    }
    public static void mostrarBlancos(String palabra) {
        /*Muestra los blancos de la palabra secreta*/
        System.out.println("Cual será la palabra secreta?");
        for(int i=0; i< palabra.length(); i++)
            System.out.print("_");
    }
    public static char ingreseLetra(){
        /*Se ingresa un caracter para el juego*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese letra: ");
        String laLetra = sc.next().toLowerCase();
        //Verifica que solo sea un caracter del rango a-z
        while(laLetra.length()!= 1 || !Character.isLetter(laLetra.charAt(0))) {
            System.out.println("Dato invalido,por favor ingrese un caracter en el rango a-z: ");
            laLetra = sc.next().toLowerCase();
        }
        return laLetra.charAt(0);
    }
    public static boolean letraEnPalabraSecreta(char letra, String palSecreta){
        /*Verifica si el caracter se encuentra en la palabra secreta*/
        for(int i=0;i<palSecreta.length();i++){
            if(palSecreta.charAt(i)==letra) {
                return true;
            }
        }
        return false;
    }
    public static String mostrarBlancosActualizados(char letra,String palSecreta,String palAdivinada){
        /*Aqui se actualiza los blancos de la palabra*/
        System.out.println("PROCESANDO.....");
        //Se utiliza un arreglo de caracteres de la palabra Adivinada
        char[] palAdivinadoChars = palAdivinada.toCharArray();
        for(int i=0;i<palSecreta.length();i++){//Actualiza cada caracter en el arreglo
            if(palSecreta.charAt(i)==letra)
                palAdivinadoChars[i] = letra;
        }
        return String.valueOf(palAdivinadoChars);
    }
}
