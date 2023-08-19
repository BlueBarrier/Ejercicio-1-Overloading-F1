/**
    Universidad del Valle de Guatemala
    Departamento de Ciencias de la Computación
    Programación Orientada a Objetos - CC2008 - sección 50
    @author: Isa Ramírez, Erick Barrera
    @version: 1.1
    @Descripción: clase para almacenar los datos del comprador. (Válido para JDK 17) 
    @Fecha creación: 14/08/2023
    @FechaModificación: 19/08/2023
 */
import java.util.Random; // importar Random
public class Cliente {
    // astríbutos de la clase
    public String nombre;
    public long dpi, ticket;
    public int cantidadBoletos;
    public double presupuestoMaximo;
    private static Random random = new Random(); // iniciar la instancia random

    Cliente(String nombre, long dpi, int cantBoletos, double presupuestoMax){ // método constructor de la clase
        this.nombre = nombre;
        this.dpi = dpi;
        this.cantidadBoletos = cantBoletos;
        this.presupuestoMaximo = presupuestoMax;
        this.ticket = 0;
    }
    // getters y setters
    public int getCantidadBoletos() {
        return cantidadBoletos;
    }
    public long getDpi() {
        return dpi;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPresupuestoMaximo() {
        return presupuestoMaximo;
    }
    public long getTicket() {
        return ticket;
    }
    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }
    public void setDpi(long dpi) {
        this.dpi = dpi;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPresupuestoMaximo(double presupuestoMaximo) {
        this.presupuestoMaximo = presupuestoMaximo;
    }
    public void setTicket(long ticket) {
        this.ticket = ticket;
    }
    // método que asigna un ticket random entre 1 y 28,000
    public void asignarTicket(){
        long ticket = random.nextLong(1,28001);
        setTicket(ticket);
    }
    // método que válida si el ticket es impar o no
    public boolean ticketValido(){
        long ticket = this.getTicket(); // obtiene el ticket de la instancia
        long a = random.nextLong(1, 15001); // asigna un valor a entre 1 y 15,000
        long b = random.nextLong(1, 15001);// asigna un valor b entre 1 y 15,000
        long suma = a+b+ticket; // suma los valores 
        if(suma%2 == 1){return true;}else{return false;} // regresa verdadero o false dependiendo si es impar o no
    }
}