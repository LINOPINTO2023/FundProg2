package Laboratorio4;
import java.util.*;
/*Laboratorio Nr4 - Ejercicio1
 *Autor: Hilacondo Begazo,Emanuel David
 *Colaboró: con nadie
 *Tiempo: --
*/

public class DemoBatalla {
    public static void main(String[] args) {
        Nave[] misNaves = new Nave[8];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;

        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("\nNave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.print("Fila: ");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.next();
            System.out.print("Estado: ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();

            misNaves[i] = new Nave(); // Se crea un objeto Nave y se asigna su referencia a misNaves
            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
        }

        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);
        mostrarPorNombre(misNaves);
        mostrarPorPuntos(misNaves);
        System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));

        // Mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
        System.out.println("Ingrese un nombre para buscar:");
        nomb = sc.next();
        int pos = busquedaLinealNombre(misNaves, nomb); // Asumiendo 'nombre' debe ser 'nomb'
        mostrarBusqueda(pos, misNaves);
        
        System.out.println("\nOrdenamiento burbuja por puntos:");
        ordenarPorPuntosBurbuja(misNaves);
        mostrarNaves(misNaves);
       
        System.out.println("\nOrdenamiento burbuja por nombres:");
        ordenarPorNombreBurbuja(misNaves);
        mostrarNaves(misNaves);
       
        // Mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
        System.out.println("Ingrese un nombre para buscar:");
        nomb = sc.next();
        pos = busquedaBinariaNombre(misNaves, nomb); // Asumiendo 'nombre' debe ser 'nomb'
        mostrarBusqueda(pos,misNaves);
       
        System.out.println("\nOrdenamiento por seleccion por puntos:");
        ordenarPorPuntosSeleccion(misNaves);
        mostrarNaves(misNaves);
       
        System.out.println("\nOrdenamiento por seleccion por nombre:");
        ordenarPorNombreSeleccion(misNaves);
        mostrarNaves(misNaves);
       
        System.out.println("\nOrdenamiento por insercion por puntos:");
        ordenarPorPuntosInsercion(misNaves);
        mostrarNaves(misNaves);
       
        System.out.println("\nOrdenamiento por insecion por nombres:");
        ordenarPorNombreInsercion(misNaves);
        mostrarNaves(misNaves);
    }

    // Método para mostrar todas las naves
    public static void mostrarNaves(Nave[] flota) {
        for(Nave n: flota)
            System.out.println(n+"\n");
    }

    // Método para mostrar todas las naves de un nombre que se pide por teclado
    public static void mostrarPorNombre(Nave[] flota) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Ingrese el nombre de la flota: ");
        String nomBuscado=sc.next();
        for(Nave n: flota) {
            if( n.getNombre().equals(nomBuscado) )
                System.out.println(n+"\n");
        }
    }

    // Método para mostrar todas las naves con un número de puntos inferior o igual
    // al número de puntos que se pide por teclado
    public static void mostrarPorPuntos(Nave[] flota) {
        Scanner sc=new Scanner(System.in);
         System.out.print("Ingrese un numero de puntos: ");
        int cantPunt=sc.nextInt();
        for(Nave n: flota)
            if(n.getPuntos()<=cantPunt)
                System.out.println(n+"\n");
    }

    // Método que devuelve la Nave con mayor número de Puntos
    public static Nave mostrarMayorPuntos(Nave[] flota) {
        int pos=0;
        int mayorPunt=flota[pos].getPuntos();
        for(int i=1; i<flota.length; i++) {
            if(mayorPunt<flota[i].getPuntos()) {
                mayorPunt=flota[i].getPuntos();
                pos=i;
            }
        }
        return flota[pos];
    }

    // Método para buscar la primera nave con un nombre que se pidió por teclado
    public static int busquedaLinealNombre(Nave[] flota, String s) {
        for(int i=0; i<flota.length; i++) {
            if( flota[i].getNombre().equals(s) )
                return i;
        }
        return -1; // Placeholder
    }
    
    //Método que muestra la nave búscada
    public static void mostrarBusqueda(int pos, Nave[] n) {
    	if(pos == -1) {
            System.out.println("No existe esa nave");
        } else {
            System.out.println("La nave es: "+ n[pos]);
        }
    }

    // Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosBurbuja(Nave[] flota) {
        for(int i=1; i<flota.length; i++) {
            for(int j=0; j<flota.length-i; j++){
                if(flota[j].getPuntos() > flota[j+1].getPuntos())
                    intercambiar(flota, j, j+1);
            }
        }
    }
    //Método que intercambia las posiciones de las naves
    public static void intercambiar(Nave[] f, int pos1, int pos2) {
            Nave nave = f[pos2];
            f[pos2] = f[pos1];
            f[pos1] = nave;
    }

    // Método que ordena por nombre de A a Z
    public static void ordenarPorNombreBurbuja(Nave[] flota) {
        for(int i = 1; i < flota.length; i++) {
            for(int j = 0; j < flota.length-i; j++){
                if(flota[j].getNombre().charAt(0) > flota[j+1].getNombre().charAt(0))
                    intercambiar(flota, j, j+1);
            }
        }
    }

    // Método para buscar la primera nave con un nombre que se pidió por teclado
    public static int busquedaBinariaNombre(Nave[] flota, String s) {
        int alta = flota.length-1, baja = 0, media;
        while(baja <= alta) {
            media = (alta+baja)/2;
            if( flota[media].getNombre().equals(s) )
                return media;
            else if( s.charAt(0) < flota[media].getNombre().charAt(0) )
                alta = media-1;
            else
                baja = media+1;
        }
        return -1; // Placeholder
    }

    // Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosSeleccion(Nave[] flota) {
		for(int rango=0; rango<flota.length-1; rango++) {
			int pos=puntosMenor(flota,rango);
			intercambiar(flota, pos, rango);
		}
	}
    
    //Método que regresa al menor por puntos 
	public static int puntosMenor(Nave[] f, int r) {
		int pos=r, menor=f[r].getPuntos();
		for(int i=r+1; i<f.length; i++) {
			if(menor>f[i].getPuntos()) {
				 menor = f[i].getPuntos();
				 pos=i;
			}
		}
		return pos;
	}

    // Método que regresa el menor por nombre de A a Z
    public static void ordenarPorNombreSeleccion(Nave[] flota) {
    	for(int rango=0; rango<flota.length-1; rango++) {
			int pos=nombreMenor(flota,rango);
			intercambiar(flota, pos, rango);
		}
    }
    
    // Método que haya la nave por el nombre de A a Z
    public static int nombreMenor(Nave[] f, int r) {
		int pos=r;
		char menor=f[r].getNombre().charAt(0);
		for(int i=r+1; i<f.length; i++) {
			if(menor>f[i].getNombre().charAt(0)) {
				 menor = f[i].getNombre().charAt(0);
				 pos=i;
			}
		}
		return pos;
	}

    // Método que muestra las naves ordenadas por número de puntos de mayor a menor
    public static void ordenarPorPuntosInsercion(Nave[] flota) {
    	for(int i=1; i<flota.length; i++) {
			for(int j=i; j>=1; j--) {
				if(flota[j-1].getPuntos() < flota[j].getPuntos()) 
					intercambiar(flota, j, j-1);
			}
		}
    }

    // Método que muestra las naves ordenadas por nombre de Z a A
    public static void ordenarPorNombreInsercion(Nave[] flota) {
    	for(int i=1; i<flota.length; i++) {
			for(int j=i; j>=1; j--) {
				if(flota[j-1].getNombre().charAt(0) < flota[j].getNombre().charAt(0)) 
					intercambiar(flota, j, j-1);
			}
		}
    }
}

