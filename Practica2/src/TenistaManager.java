import java.util.*;

public class TenistaManager {
    private final int MAX = 15;
    private Tenista[] lista = new Tenista[MAX];
    private int cantidad = 0;

    public void ingresarTenistas(Scanner sc) {
        int n = leerEntero(sc, "¿Cuántos tenistas desea ingresar? ");
        if (n < 1 || n > MAX) {
            System.out.println("Cantidad inválida");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nTenista #" + (cantidad + 1));
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("País: ");
            String pais = sc.nextLine();
            int edad = leerEntero(sc, "Edad: ");
            int puntaje = leerEntero(sc, "Puntaje ATP: ");

            lista[cantidad++] = new Tenista(nombre, pais, edad, puntaje);

            if (cantidad >= MAX) {
                System.out.println("Se alcanzó el máximo de tenistas");
                break;
            }
        }
    }

    public void mostrarTenistas() {
        if (cantidad == 0) {
            System.out.println("No hay tenistas registrados");
            return;
        }
        mostrarCabecera();
        for (int i = 0; i < cantidad; i++) {
            lista[i].mostrar();
        }
    }

    public void mostrarOrdenados(int criterio) {
        if (cantidad == 0) {
            System.out.println("No hay tenistas registrados");
            return;
        }

        Tenista[] copia = Arrays.copyOf(lista, cantidad);

        if (criterio == 1 || criterio == 2) {
            quicksort(copia, 0, copia.length - 1, criterio);
        } else if (criterio == 3) {
            Arrays.sort(copia, Comparator
                    .comparing(Tenista::getPais, String.CASE_INSENSITIVE_ORDER)
                    .thenComparing(Tenista::getNombre, String.CASE_INSENSITIVE_ORDER));
        }

        if (criterio == 1)
            System.out.println("Ordenados por puntaje descendente:");
        else if (criterio == 2)
            System.out.println("Ordenados por edad ascendente:");
        else if (criterio == 3)
            System.out.println("Ordenados por país y nombre:");

        mostrarCabecera();
        for (Tenista t : copia) {
            t.mostrar();
        }
    }

    private void mostrarCabecera() {
        System.out.printf("%-20s %-15s %-5s %-8s\n", "Tenista", "País", "Edad", "Puntaje");
    }

    private int leerEntero(Scanner sc, String mensaje) {
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

    private void quicksort(Tenista[] arr, int izq, int der, int criterio) {
        if (izq < der) {
            int p = particion(arr, izq, der, criterio);
            quicksort(arr, izq, p - 1, criterio);
            quicksort(arr, p + 1, der, criterio);
        }
    }

    private int particion(Tenista[] arr, int izq, int der, int criterio) {
        Tenista pivote = arr[der];
        int i = izq - 1;
        for (int j = izq; j < der; j++) {
            if (comparar(arr[j], pivote, criterio) < 0) {
                i++;
                intercambiar(arr, i, j);
            }
        }
        intercambiar(arr, i + 1, der);
        return i + 1;
    }

    private int comparar(Tenista a, Tenista b, int criterio) {
        if (criterio == 1)
            return Integer.compare(b.getPuntaje(), a.getPuntaje());
        if (criterio == 2)
            return Integer.compare(a.getEdad(), b.getEdad());
        return 0;
    }

    private void intercambiar(Tenista[] arr, int i, int j) {
        Tenista tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
