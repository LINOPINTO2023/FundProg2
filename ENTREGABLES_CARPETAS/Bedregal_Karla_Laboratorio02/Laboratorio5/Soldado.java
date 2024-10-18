// Autor: Karla Bedregal Coaguila
//Laboratorio 05 */
package laboratorio05_karlabedregal;
public class Soldado {
    private String nombre;
    private int nivelVida;
    private int fila;
    private String columna;
    
    // Constructor
    public void setNombre (String nom) {
        nombre = nom;
    }
    public void setNivelVida (int nivel) {
        nivelVida = nivel;
    }
    public void setFila (int fil) {
        fila = fil;
    }
    public void setColumna (String colum) {
        columna = colum;
    }
    // Métodos accesores
    public String getNombre() {
        return nombre;
    }
    public int getNivelVida() {
        return nivelVida;
    }
    public int getFila(){
        return fila;
    }
    public String getColumna(){
        return columna;
    }
    
    // Método para mostrar información del soldado
    public String toString() {
        return "Nombre: " + nombre + "\t| Nivel de vida: " + nivelVida  
                + "\t| Posicion: " + fila + columna;
    }
}