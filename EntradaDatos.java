/**
    Universidad del Valle de Guatemala
    Departamento de Ciencias de la Computación
    Programación Orientada a Objetos - CC2008 - sección 50
    @author: Erick Barrera
    @version: 1.0
    @Descripción: clase para entrada de datos asociada a la clase Programa (main). 
    @Fecha creación: 19/08/2023
    @FechaModificación: 19/08/2023
 */
import java.util.Scanner; // importar el Scanner
public class EntradaDatos {
    private static Scanner scanner = new Scanner(System.in); // iniciar nuevo scanner
    
    public static String pedirNombre(){ // método que pide y devuelve el nombre
        System.out.println("\nIngrese su nombre: ");
        String nombre = scanner.nextLine();
        return nombre;
    }
    public static long pedirDPI(){ // método que pide y devuelve el dpi
        System.out.println("\nIngrese su DPI: ");
        long dpi = scanner.nextLong();
        scanner.nextLine();
        return dpi;
    }
    public static int pedirBoletos(){ // método que pide y devuelve la cantidad de boletos que quiere el cliente
        System.out.println("\nIngrese la cantidad de boletos a comprar: ");
        int boletos = scanner.nextInt();
        scanner.nextLine();
        return boletos;
    }
    public static double pedirPresupuesto(){ // método que pide y devuelve el presupuesto máximo a gastar
        System.out.println("\nIngrese su presupuesto máximo para la compra: ");
        double presupuesto = scanner.nextDouble();
        scanner.nextLine();
        return presupuesto;
    }
    public static int pedirOpcion(){ // método que pide y devuelve la opción seleccionada del menú mostrado
        System.out.println("\n Seleccione una opción: \n"+
                                "1. Nuevo Comprador\n"+
                                "2. Nueva solicitud de boletos\n"+
                                "3. Consultar disponibilidad total\n"+
                                "4. Consultar disponibilidad individual\n"+
                                "5. Reporte de caja\n"+
                                "6. Salir\n");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
    public static int pedirLocalidad(VentaBoletos...localidad){ // método que pide y devuelve la opción de la localidad seleccionada en relación a la lista de localidades ingresadas
        System.out.printf("\nSeleccione una localidad: \n"+
                                "1. %s\n"+
                                "2. %s\n"+
                                "3. %s",localidad[0].getDescripcion(),localidad[1].getDescripcion(),localidad[2].getDescripcion());
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
}