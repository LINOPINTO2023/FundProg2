/*
  Clase Soldados
*/
package ejercicio4lab1;


public class Soldados {
    private String nombre;
    private int vida;
    // Metodos mutadores
    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // Metodos accesores
    public String getNombre() {
        return nombre;
    }
        
    public int getVida() {
        return vida;
    }
}


