package hotelService;

import domain.Hotel;
import java.util.List;

public interface HotelService {

    void registrarHotel(Hotel hotel);

    List<Hotel> obtenerHoteles();

    void eliminarHotel(String nombre);

    void actualizarHotel(Hotel hotel);
}
