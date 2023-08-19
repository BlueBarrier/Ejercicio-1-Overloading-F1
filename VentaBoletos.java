/**
    Universidad del Valle de Guatemala
    Departamento de Ciencias de la Computación
    Programación Orientada a Objetos - CC2008 - sección 50
    @author: Isa Ramírez, Erick Barrera
    @version: 1.1
    @Descripción : clase para almacenar los datos de las localidades.
    @Fecha creación: 14/08/2023
    @FechaModificación: 19/08/2023
 */
import java.util.Random; // se llama al método random
public class VentaBoletos {
    // se inician los atributos de la clase
    public double precio; 
    public int cantidadDisponible;
    public String descripcion;
    private static Random random = new Random();

    VentaBoletos(double precio, int cantidadDisponible, String descripcion){ // método constructor
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
        this.descripcion = descripcion;
    }
    // getters y setters
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }
    public double getPrecio() {
        return precio;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    // método para asignar una localidad aleatoriamente
    public static VentaBoletos asignarLocalidad(VentaBoletos...localidades){ // recibe la lista de objetos tipo VentaBoleto
        int indiceR = random.nextInt(0,3); // elige un indice random entre 0 y 2
        return localidades[indiceR]; // regresa el objeto de la lista localidades con el indice random
    }
}
