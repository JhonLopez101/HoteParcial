package application;

import domain.Hotel;
import hotelService.HotelService;
import hotelServiceImpl.HotelServiceImpl;


import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelService hotelService = new HotelServiceImpl();

        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Registrar un nuevo hotel");
            System.out.println("2. Mostrar lista de hoteles");
            System.out.println("3. Eliminar un hotel");
            System.out.println("4. Actualizar hotel");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            switch (opcion) {
                case 1:
                    // Registrar nuevo hotel
                    System.out.print("Nombre del hotel: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Dirección del hotel: ");
                    String direccion = scanner.nextLine();
                    System.out.print("Número de habitaciones: ");
                    int habitaciones = scanner.nextInt();
                    System.out.print("Precio por noche: ");
                    double precio = scanner.nextDouble();
                    Hotel hotel = new Hotel(nombre, direccion, habitaciones, precio);
                    hotelService.registrarHotel(hotel);
                    System.out.println("Hotel registrado.");
                    break;

                case 2:
                    // Mostrar lista de hoteles
                    List<Hotel> hoteles = hotelService.obtenerHoteles();
                    if (hoteles.isEmpty()) {
                        System.out.println("No hay hoteles registrados.");
                    } else {
                        hoteles.forEach(System.out::println);
                    }
                    break;

                case 3:
                    // Eliminar un hotel
                    System.out.print("Introduce el nombre del hotel a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    hotelService.eliminarHotel(nombreEliminar);
                    System.out.println("Hotel eliminado.");
                    break;

                case 4:
                    // Actualizar un hotel
                    System.out.print("Introduce el nombre del hotel a actualizar: ");
                    String nombreActualizar = scanner.nextLine();
                    List<Hotel> hotelesParaActualizar = hotelService.obtenerHoteles();
                    Hotel hotelActualizar = null;
                    for (Hotel h : hotelesParaActualizar) {
                        if (h.getNombre().equalsIgnoreCase(nombreActualizar)) {
                            hotelActualizar = h;
                            break;
                        }
                    }
                    if (hotelActualizar != null) {
                        System.out.print("Nuevo nombre del hotel (dejar vacío para no cambiar): ");
                        String nuevoNombre = scanner.nextLine();
                        if (!nuevoNombre.isEmpty()) {
                            hotelActualizar.setNombre(nuevoNombre);
                        }
                        System.out.print("Nueva dirección (dejar vacío para no cambiar): ");
                        String nuevaDireccion = scanner.nextLine();
                        if (!nuevaDireccion.isEmpty()) {
                            hotelActualizar.setDireccion(nuevaDireccion);
                        }
                        System.out.print("Nuevo número de habitaciones (dejar vacío para no cambiar): ");
                        String nuevoHabitaciones = scanner.nextLine();
                        if (!nuevoHabitaciones.isEmpty()) {
                            hotelActualizar.setNumeroDeHabitaciones(Integer.parseInt(nuevoHabitaciones));
                        }
                        System.out.print("Nuevo precio por noche (dejar vacío para no cambiar): ");
                        String nuevoPrecio = scanner.nextLine();
                        if (!nuevoPrecio.isEmpty()) {
                            hotelActualizar.setPrecioPorNoche(Double.parseDouble(nuevoPrecio));
                        }
                        hotelService.actualizarHotel(hotelActualizar);
                        System.out.println("Hotel actualizado.");
                    } else {
                        System.out.println("Hotel no encontrado.");
                    }
                    break;

                case 5:
                    // Salir
                    System.out.println("Saliendo...");
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
