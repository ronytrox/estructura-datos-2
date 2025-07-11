public class Tenista {
    private String nombre;
    private String pais;
    private int edad;
    private int puntaje;

    public Tenista(String nombre, String pais, int edad, int puntaje) {
        this.nombre = nombre;
        this.pais = pais;
        this.edad = edad;
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public int getEdad() {
        return edad;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void mostrar() {
        System.out.printf("%-20s %-15s %-5d %-8d\n", nombre, pais, edad, puntaje);
    }
}
