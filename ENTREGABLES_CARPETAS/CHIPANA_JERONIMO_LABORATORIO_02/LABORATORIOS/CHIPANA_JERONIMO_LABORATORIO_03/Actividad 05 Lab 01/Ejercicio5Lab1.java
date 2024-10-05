/*
  Autor: Chipana Jeronimo German Arturo
  Proposito: Ejercicio 05
*/
package ejercicio5lab1;

public class Ejercicio5Lab1 {

    public static void main(String[] args) {
        // Inicializa dos arreglos de Ejercito con una cantidad aleatoria de soldados (de 1 a 5)
        Ejercito[] ejercito1=new Ejercito[(int)(Math.random()*5+1)];
        Ejercito[] ejercito2=new Ejercito[(int)(Math.random()*5+1)];
        // Llama al método para inicializar los soldados en ambos ejércitos
        inicializarEjercitos(ejercito1);
        inicializarEjercitos(ejercito2);
        // Muestra la cantidad de soldados en el primer ejército
        System.out.println("EJERCITO 1 : "+(ejercito1.length));
        // Muestra los nombres de los soldados del primer ejército
        mostrarEjercito(ejercito1);
        // Muestra la cantidad de soldados en el segundo ejército
        System.out.println("EJERCITO 2 : "+(ejercito2.length));
        // Muestra los nombres de los soldados del segundo ejército
        mostrarEjercito(ejercito2);
        // Determina y muestra el ganador entre los dos ejércitos
        mostrarEjercitoGanador(ejercito1,ejercito2);
    }
    // Método que inicializa un ejército con soldados
    public static void inicializarEjercitos(Ejercito[] ejercito){
        for(int i=0;i<ejercito.length;i++){
            ejercito[i]=new Ejercito();
            String nombre="Soldado"+(i);
            ejercito[i].setSoldado(nombre);
        }
    }
    // Método que muestra los nombres de los soldados de un ejército
    public static void mostrarEjercito(Ejercito[] ejercito){
        for(int i=0;i<ejercito.length;i++){
            System.out.println(ejercito[i].getSoldado());
        }
    }
    // Método que determina y muestra el ganador entre dos ejércitos
    public static void mostrarEjercitoGanador(Ejercito[] ejercito1,Ejercito[] ejercito2){
        if(ejercito1.length>=ejercito2.length){
            if(ejercito1.length==ejercito2.length)
                System.out.println("Hubo un EMPATE de ejercitos, ambos con "+ejercito1.length+" soldados...");
            else
                System.out.println("Gano el EJERCITO 1 con "+ejercito1.length+" soldados!");
        }
        else
            System.out.println("Gano el EJERCITO 2 con "+ejercito2.length+" soldados!");
    }
}


