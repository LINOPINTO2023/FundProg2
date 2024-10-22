/*propósito: simular un tablero 10x10 en el que de desarrolla una batalla*/
import java.util.*;
public class VideoJuego3 {
    public static int vidaTotalAzul = 0; //USO VARIABLES GLOBALES PARA HACER VARIOS CAMBIOS DESDE MÉTODOS
    public static int vidaTotalRojo = 0;
    public static double promedioAzul = 0;
    public static double promedioRojo = 0;
    public static Soldado mayorVidaAzul = new Soldado(null, 0, 0, 0, null); // INICIALIZO UN SOLDADO PARA LA COMPARACIÓN
    public static Soldado mayorVidaRojo = new Soldado(null, 0, 0, 0, null);
    public static Soldado[] soldadosUniDimensionalAzul = new Soldado[10]; // PARA NO DESPERDICIR TANTA MEMORIA ME APOYO DE UNA MATRIZ
    public static Soldado[] soldadosUniDimensionalRojo = new Soldado[10]; // LAS USARÉ SOLO PARA ORDENAMIENTOS
    public static void main(String[] args) {
        ArrayList<ArrayList<Soldado>> tablero = new ArrayList<ArrayList<Soldado>>(); //INICIALIZO MI ARRAYLIST BIDIMENSIONAL
        int cantidad = (int)(Math.random() * 10 + 1);
        int cantidadEnemiga = (int)(Math.random() * 10 + 1);
        for(int i = 0; i<10; i++){
            tablero.add(new ArrayList<Soldado>());
            for(int j = 0; j<10;j++)
                tablero.get(i).add(new Soldado(null, 0, 0, 0, null)); // INICIALIZA CON VALORES NULL Y 0
        }
        inicializarEjercito(tablero, cantidad); // METO DATOS A MI ARRAYLIST
        inicializarEjercitoEnemigo(tablero, cantidadEnemiga);
        mostrarTabla(tablero); // MUESTRA TABLA
        hallarSoldadoMayorVida(tablero);
        System.out.println("El soldado con mayor vida del ejército azul es: " + mayorVidaAzul);
        System.out.println("El soldado con mayor vida del ejército rojo es: " + mayorVidaRojo);
        hallarPromedioVida(tablero, cantidad, cantidadEnemiga);
        System.out.println("El promedio del ejercito azul es: " + promedioAzul);
        System.out.println("El promedio del ejercito rojo es: " + promedioRojo);
        System.out.println("DATOS DEL EJÉRCITO AZUL POR ORDEN DE INGRESO:");
        imprimirInformacion(cantidad, soldadosUniDimensionalAzul); // IMPRIME LA INFORMACIÓN DE LOS SOLDADOS DE UN EJERCITO
        System.out.println("DATOS DEL EJÉRCITO ROJO POR ORDEN DE INGRESO:");
        imprimirInformacion(cantidadEnemiga, soldadosUniDimensionalRojo);
        rankingDePoder(cantidad, soldadosUniDimensionalAzul); // ORDENA POR MÉTODO BURBUJA
        ordenarSeleccion(cantidadEnemiga, soldadosUniDimensionalRojo); // ORDENA POR MÉTODO SELECCIÓN
        System.out.println("DATOS DEL EJÉRCITO AZUL ORDENADO POR NIVEL DE VIDA:");
        imprimirInformacion(cantidad, soldadosUniDimensionalAzul);
        System.out.println("DATOS DEL EJÉRCITO ROJO ORDENADO POR NIVEL DE VIDA:");
        imprimirInformacion(cantidadEnemiga, soldadosUniDimensionalRojo);
        mostrarGanador(); // MUESTRA EL GANADOR, CRITERIO: VIDA TOTAL DE LOS EJÉRCITOS
    }
    public static void inicializarEjercito(ArrayList<ArrayList<Soldado>> tablero, int cantidad) { // INICIALIZA SOLDADOS CON SU INFORMACIÓN
        int contadorNombreSoldado = 0;
        while (cantidad > 0) {
            int fila = (int) (Math.random() * 10);
            int columna = (int) (Math.random() * 10);
            if (tablero.get(fila).get(columna).getVida() == 0) { // SE VERIFICA QUE NO HAYA OTRO SOLDADO EN ESA POSICIÓN, SI LO HAY, BUSCA OTRA
                tablero.get(fila).set(columna, new Soldado("\u001B[44mSoldado"+fila+"X"+columna + "\u001B[0m", (int) (Math.random() * 5 + 1), fila, columna, "azul"));  //USÉ COLORES PARA LA DISTINCIÓN ENTRE SOLDADOS
                soldadosUniDimensionalAzul[contadorNombreSoldado] = tablero.get(fila).get(columna);
                contadorNombreSoldado++;
                cantidad--;
                vidaTotalAzul += tablero.get(fila).get(columna).getVida();
            }
        }
    }
    public static void inicializarEjercitoEnemigo(ArrayList<ArrayList<Soldado>> tablero, int cantidad) { // INICIALIZA SOLDADOS CON SU INFORMACIÓN
        int contadorNombreSoldado = 0;
        while (cantidad > 0) {
            int fila = (int) (Math.random() * 10);
            int columna = (int) (Math.random() * 10);
            if (tablero.get(fila).get(columna).getVida() == 0) { // SE VERIFICA QUE NO HAYA OTRO SOLDADO EN ESA POSICIÓN, SI LO HAY, BUSCA OTRA
                tablero.get(fila).set(columna, new Soldado("\u001B[41mSoldado"+fila+"X"+columna + "\u001B[0m", (int) (Math.random() * 5 + 1), fila, columna, "rojo")); //USÉ COLORES PARA LA DISTINCIÓN ENTRE SOLDADOS
                soldadosUniDimensionalRojo[contadorNombreSoldado] = tablero.get(fila).get(columna);
                contadorNombreSoldado++;
                cantidad--;
                vidaTotalRojo += tablero.get(fila).get(columna).getVida();
            }
        }
    }
    public static void mostrarTabla(ArrayList<ArrayList<Soldado>> tablero) {  // GENERA A BASE DE | Y _ UN TABLA PARA LOS SOLDADOS
        for (int i = 0; i < tablero.size(); i++) {
            for (int j = 0; j < tablero.get(i).size(); j++) {
                if (tablero.get(i).get(j).getVida() == 0) // GENERA ESPACIOS VACÍOS SI NO HAY UN OBJETO EN ESA DIRECCIÓN
                    System.out.print("|__________");
                else
                    System.out.print("|" + tablero.get(i).get(j).getNombre());  // CARGA EL NOMBRE DEL SOLDADO SI EXISTE
            }
            System.out.println("|"); // ACOMODA EL TABLERO 10X10
        }
    }
    public static void hallarSoldadoMayorVida(ArrayList<ArrayList<Soldado>> tablero) { // MUESTRA AL SOLDADO CON MAYOR VIDA
        for (int i = 0; i < tablero.size(); i++) {
            for (int j = 0; j < tablero.get(i).size(); j++) {
                if (tablero.get(i).get(j).getVida() != 0 && tablero.get(i).get(j).getEquipo().equals("azul") && mayorVidaAzul.getVida() < tablero.get(i).get(j).getVida()) // SOLO SE CUMPLE SI LA VIDA ES DIFERENTES DE 0, PERTENECE AL EQUIPO AZUL Y ES MAYOR
                    mayorVidaAzul = tablero.get(i).get(j);
                if (tablero.get(i).get(j).getVida() != 0 && tablero.get(i).get(j).getEquipo().equals("rojo") && mayorVidaRojo.getVida() < tablero.get(i).get(j).getVida()) // SOLO SE CUMPLE SI LA VIDA ES DIFERENTES DE 0, PERTENECE AL EQUIPO ROJO Y ES MAYOR
                    mayorVidaRojo = tablero.get(i).get(j);
            }
        }
    }

    public static void hallarPromedioVida(ArrayList<ArrayList<Soldado>> tablero, int cantidad, int cantidadEnemiga) { //MUESTRA EL PROMEDIO DE VIDA TRBAJA EN LA MATRIZ BIDIMENSIONAL
        for (int i = 0; i < tablero.size(); i++) {
            for (int j = 0; j < tablero.get(i).size(); j++) {
                if (tablero.get(i).get(j).getVida() != 0 && tablero.get(i).get(j).getEquipo().equals("azul"))
                    promedioAzul += tablero.get(i).get(j).getVida(); // AUMENTA LA VARIABLE GLOBAL
                if (tablero.get(i).get(j).getVida() != 0 && tablero.get(i).get(j).getEquipo().equals("azul"))
                    promedioRojo += tablero.get(i).get(j).getVida();
            }
        }
        promedioAzul /= cantidad;
        promedioRojo /= cantidadEnemiga; // CONVIERTE LA VARIABLE GLOBAL EN PROMEDIO EN LUGAR DE UNA SUMATORIA
    }
    public static void rankingDePoder(int cantidad, Soldado[] soldadosUniDimensional) { //PRIMER ALGORITMO DE ORDENAMIENTO (BURBUJA)
        boolean intercambio = true;
        while (intercambio) {
            intercambio = false;  // LO MANTIENE FALSO HASTA QUE SE HAYA UN INTERCAMBIO, SINO SE SALE DEL BUCLE
            for (int i = 0; i < cantidad - 1; i++)
                if (soldadosUniDimensional[i].getVida() < soldadosUniDimensional[i + 1].getVida()) {
                    intercambio = true;
                    Soldado temp = new Soldado(null, 0, 0, 0, null); //VARIABLE TEMPORAL PARA EL INTERCAMBIO
                    temp = soldadosUniDimensional[i + 1];
                    soldadosUniDimensional[i + 1] = soldadosUniDimensional[i];
                    soldadosUniDimensional[i] = temp;
                }
        }
    }
    public static void ordenarSeleccion(int cantidad, Soldado[] soldadosUniDimensional) { // 2DO ALGORITMO DE ORDENAMIENTO
        for (int i = 0; i < cantidad - 1; i++) { //SE USA LA CANTIDAD PARA EVITAR QUE EL BUCLE SEÑALE A OBJETOS NULL
            int menor = i;
            for (int j = i + 1; j < cantidad; j++)
                if (soldadosUniDimensional[j].getVida() > soldadosUniDimensional[menor].getVida())
                    menor = j; // Almacena la posición del menor
            Soldado temp = soldadosUniDimensional[menor];             // Intercambio de elementos
            soldadosUniDimensional[menor] = soldadosUniDimensional[i];
            soldadosUniDimensional[i] = temp;
        }
    }
    public static void imprimirInformacion(int cantidad, Soldado[] soldadosUniDimensional){
        for(int i = 0; i<cantidad; i++){
            System.out.println("SOLDADO " + i + ":");
            System.out.println(soldadosUniDimensional[i].toString()); //ME APOYO DE UNA MATRIZ UNIDIMENSIONAL PARA NO
        }                                                               // DESPERDICIAR MEMORIA
    }
    public static void mostrarGanador(){ // CRITERIO: CANTIDAD TOTAL DE VIDA
        if(vidaTotalAzul>vidaTotalRojo)
            System.out.println("¡El ejercito azul gana por mayor nivel de vida! " + "\nAzul " + vidaTotalAzul + ":" + vidaTotalRojo + " Rojo");
        else if(vidaTotalAzul<vidaTotalRojo)
            System.out.println("¡El ejercito rojo gana por mayor nivel de vida! " + "\nAzul " + vidaTotalAzul + ":" + vidaTotalRojo + " Rojo");
        else
            System.out.println("¡Ha ocurrido un empate! "  + "\nAzul " + vidaTotalAzul + ":" + vidaTotalRojo + " Rojo");
    }
}