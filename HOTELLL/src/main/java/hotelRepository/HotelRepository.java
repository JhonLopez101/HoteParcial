package hotelRepository;

import domain.Hotel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HotelRepository {

    private final String archivoHoteles = "hoteles.txt";

    public void guardarHotel(Hotel hotel) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoHoteles, true))) {
            writer.write(hotel.getNombre() + "," +
                    hotel.getDireccion() + "," +
                    hotel.getNumeroDeHabitaciones() + "," +
                    hotel.getPrecioPorNoche());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Hotel> obtenerHoteles() {
        List<Hotel> hoteles = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoHoteles))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                Hotel hotel = new Hotel(datos[0], datos[1], Integer.parseInt(datos[2]), Double.parseDouble(datos[3]));
                hoteles.add(hotel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hoteles;
    }

    public void eliminarHotel(String nombre) {
        List<Hotel> hoteles = obtenerHoteles();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoHoteles))) {
            for (Hotel hotel : hoteles) {
                if (!hotel.getNombre().equalsIgnoreCase(nombre)) {
                    writer.write(hotel.getNombre() + "," +
                            hotel.getDireccion() + "," +
                            hotel.getNumeroDeHabitaciones() + "," +
                            hotel.getPrecioPorNoche());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actualizarHotel(Hotel hotel) {
        List<Hotel> hoteles = obtenerHoteles();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoHoteles))) {
            for (Hotel h : hoteles) {
                if (h.getNombre().equalsIgnoreCase(hotel.getNombre())) {
                    writer.write(hotel.getNombre() + "," +
                            hotel.getDireccion() + "," +
                            hotel.getNumeroDeHabitaciones() + "," +
                            hotel.getPrecioPorNoche());
                } else {
                    writer.write(h.getNombre() + "," +
                            h.getDireccion() + "," +
                            h.getNumeroDeHabitaciones() + "," +
                            h.getPrecioPorNoche());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
