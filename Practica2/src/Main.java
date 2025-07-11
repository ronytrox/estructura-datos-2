import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TenistaManager manager = new TenistaManager();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(sc, "Seleccione una opción: ");
            switch (opcion) {
                case 1:
                    manager.ingresarTenistas(sc);
                    break;
                case 2:
                    manager.mostrarTenistas();
                    break;
                case 3:
                    manager.mostrarOrdenados(1); // Puntaje descendente
                    break;
                case 4:
                    manager.mostrarOrdenados(2); // Edad ascendente
                    break;
                case 5:
                    manager.mostrarOrdenados(3); // País y nombre
                    break;
                case 6:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Ingreso de los tenistas");
        System.out.println("2. Mostrar datos ingresados");
        System.out.println("3. Mostrar tenistas ordenados por puntaje descendentemnte");
        System.out.println("4. Mostrar tenistas ordenados por edad ascendentemente");
        System.out.println("5. Mostrar tenistas ordenados por país y/o nombre");
        System.out.println("6. Terminar");
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        int valor;
        while (true) {
            try {
                System.out.print(mensaje);
                valor = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }
        return valor;
    }
}
