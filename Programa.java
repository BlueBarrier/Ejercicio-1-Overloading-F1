/**
    Universidad del Valle de Guatemala
    Departamento de Ciencias de la Computación
    Programación Orientada a Objetos - CC2008 - sección 50
    @author: Isa Ramírez, Erick Barrera
    @version: 1.1
    Descripción: clase para almacenar los datos del comprador. 
    @Fecha creación: 14/08/2023
    @FechaModificación: 19/08/2023
 */
public class Programa {
    public static void main(String[] args) { // programa main
        int opcion = 0; // opcion para el while
        Cliente fanatico = null; // iniciar instancia tipo Cliente

        // iniciación instancias tipo VentaBoletos para las localidades
        VentaBoletos localidad1 = new VentaBoletos(300, 20,"Localida 1: La más alejada de la pista.");
        VentaBoletos localidad5 = new VentaBoletos(565, 20, "Localidad 5: Localidad en medio de la tribuna, una mejor vista a la pista.");
        VentaBoletos localidad10 = new VentaBoletos(1495, 20, "Localidad 10: La más cercana a la pista, ¡Una vista increíble!.");
        // iniciación localidad vendida
        VentaBoletos localidadVendida = null;
        double totalVenta = 0; // iniciación total recaudado por las ventas
        do{ // inicia el ciclo
            opcion=EntradaDatos.pedirOpcion(); // llama al método pedirOpcion de la clase EntradaDatos (Este sería el menú del programa)
            switch(opcion){
                case 1:     // si se elige un nuevo cliente
                    System.out.println("\n");
                    // pedida de datos del cliente
                    String nombre = EntradaDatos.pedirNombre(); 
                    long dpi = EntradaDatos.pedirDPI();
                    int cantBoletos = EntradaDatos.pedirBoletos();
                    double presupuesto = EntradaDatos.pedirPresupuesto();
                    // asignar los parámetros a la instancia fanatico de la clase Cliente
                    fanatico = new Cliente(nombre, dpi, cantBoletos, presupuesto);
                    break;
                case 2: // si se elige una compra de boleto
                    System.out.println("\n");
                    if(fanatico != null){ // verifica si a la instancia fanatico se le han asignado valores
                        fanatico.asignarTicket(); // se le asigna un ticket a la instancia fanatico
                        if(fanatico.ticketValido()){ // se comprueba si el ticket asignado es válido
                            localidadVendida = VentaBoletos.asignarLocalidad(localidad1,localidad5,localidad10); // se le asigna una localidad aleatoria
                            if(!(localidadVendida.getCantidadDisponible()<=0)){ // se verifica si hay disponibilidad en la localidad elegida
                                if(localidadVendida.getCantidadDisponible()>=fanatico.getCantidadBoletos()){ // se verifica si existe la cantidad de boletos que quiere el cliente en la localidad
                                    if((localidadVendida.getPrecio()*fanatico.getCantidadBoletos()) <= fanatico.getPresupuestoMaximo()){ // se verifica si el presupuesto del cliente alcanza para comprar la cantidad de boletos que quiere en la localidad elegida
                                        System.out.printf("\n¡Felicidades!, venta válida:\n"+
                                                            "Total a pagar: %.2f", (localidadVendida.getPrecio()*fanatico.getCantidadBoletos())); // se muestra el total a pagar
                                        totalVenta += (localidadVendida.getPrecio()*fanatico.getCantidadBoletos()); // se le suma la cantidad que pago al total de caja
                                        localidadVendida.setCantidadDisponible(localidadVendida.getCantidadDisponible()-fanatico.getCantidadBoletos()); // se le resta la cantidad de boletos comprados a la cantidad de boletos disponibles de la localidad elegida
                                        break;
                                    }else{System.out.printf("\nLo sentimos, su presupuesto no alcanza para comprar %d boletos en esta localidad. (precio localidad: %.2f)", fanatico.getCantidadBoletos(), localidadVendida.getPrecio());break;} // si su presupuesto no alcanza para comprar la cantidad de boletos que quiere en la localidad elegida
                                }else{
                                    if((localidadVendida.getPrecio()*localidadVendida.getCantidadDisponible()) <= fanatico.getPresupuestoMaximo()){ // se verifica si sus presupuesto alcanza para comprar la cantidad de boletos que quedan
                                        System.out.printf("\n¡Felicidades!, venta válida:\n"+
                                                            "Total a pagar: %.2f", (localidadVendida.getPrecio()*localidadVendida.getCantidadDisponible())); // se compra las entradas
                                        totalVenta += (localidadVendida.getPrecio()*localidadVendida.getCantidadDisponible()); // se suma lo que pago a la caja
                                        localidadVendida.setCantidadDisponible(localidadVendida.getCantidadDisponible()-localidadVendida.getCantidadDisponible()); // se resta la cantidad de boletos comprados de la cantidad disponible
                                        break;
                                    }else{System.out.printf("\nLo sentimos, su presupuesto no alcanza para comprar %d boletos en esta localidad. (precio localidad: %.2f)", localidadVendida.getCantidadDisponible(), localidadVendida.getPrecio());break;} // si su presupuesto no alcanza para comprar el resto de entradas que quedan 
                                }
                            }else{System.out.println("\nLocalidad agotada. Lo sentimos!");break;} // si la localidad asignada ya no tiene disponibilidad
                        }else{System.out.println("\nLo sentimos, su ticket no es válido. Pruebe más tarde!"); break;} // si el ticket no es válido
                    }else{System.out.println("\nIngrese sus datos primero!!"); break;} // si no ha ingresado datos a la instancia fanatico de la clase Cliente
                case 3: // si se quiere saber la cantidad de boletos totales
                    System.out.println("\n");
                    int disponibleTotal = localidad1.getCantidadDisponible() + localidad5.getCantidadDisponible() + localidad10.getCantidadDisponible(); // la suma de la cantidad de boletos disponibles en cada localidad
                    System.out.printf("\nEn total hay %d boletos disponibles entre las tres localidades.", disponibleTotal); // muestra la cantidad disponible
                    System.out.println("Disponibilidad para la localidad 1: " + localidad1.getCantidadDisponible());
                    System.out.println("Disponibilidad para la localidad 5: " + localidad5.getCantidadDisponible());
                    System.out.println("Disponibilidad para la localidad 10: "+ localidad10.getCantidadDisponible());
                    break;
                case 4: // si se quiere saber la cantidad de boletos por localidad
                    System.out.println("\n");
                    int opcion2 = 0; // se inicia la variable opcion 2
                    opcion2 = EntradaDatos.pedirLocalidad(localidad1,localidad5,localidad10); // se llama al menú de localidades, pasandole las localidades definidas
                    switch(opcion2){
                        case 1: // si selecciona la localidad 1
                            System.out.printf("\n(%s) \n"+
                                              "Disponibilidad: %d.",localidad1.getDescripcion(), localidad1.getCantidadDisponible()); // muesta la cantidad de boletos disponibles en la localidad 1
                            break;
                        case 2: // si selecciona la localidad 5
                            System.out.printf("\n(%s) \n"+
                                              "Disponibilidad: %d.",localidad5.getDescripcion(), localidad5.getCantidadDisponible()); // muesta la cantidad de boletos disponibles en la localidad 5
                            break;
                        case 3: // si selecciona la localidad 10
                            System.out.printf("\n(%s) \n"+
                                              "Disponibilidad: %d.",localidad10.getDescripcion(), localidad10.getCantidadDisponible()); // muesta la cantidad de boletos disponibles en la localidad 10
                            break;
                    }
                    break;
                case 5: // si se quiere saber el total recaudado
                    System.out.println("\n");
                    System.out.printf("\nReporte de Caja actual:\n"+
                                            "Total: %.2f",totalVenta); // muestra la variable que lleva la suma del total vendido
                    break;
                case 6: // si se quiere salir
                    System.out.println("\n");
                    System.out.println("Feliz día!!");
                default: // si elige algo que nada que ver
                    System.out.println("\n");
                    System.out.println("Opción no válida");
                    break;
            }
        }while(opcion != 6);
        
    }
}
