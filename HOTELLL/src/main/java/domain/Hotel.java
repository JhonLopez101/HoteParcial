package domain;

public class Hotel {
    private String nombre;
    private String direccion;
    private int numeroDeHabitaciones;
    private double precioPorNoche;

    public Hotel(String nombre, String direccion, int numeroDeHabitaciones, double precioPorNoche) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroDeHabitaciones = numeroDeHabitaciones;
        this.precioPorNoche = precioPorNoche;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumeroDeHabitaciones() {
        return numeroDeHabitaciones;
    }

    public void setNumeroDeHabitaciones(int numeroDeHabitaciones) {
        this.numeroDeHabitaciones = numeroDeHabitaciones;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numeroDeHabitaciones=" + numeroDeHabitaciones +
                ", precioPorNoche=" + precioPorNoche +
                '}';
    }
}
