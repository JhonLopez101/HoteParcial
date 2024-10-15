package hotelServiceImpl;

import domain.Hotel;
import hotelRepository.HotelRepository;
import hotelService.HotelService;

import java.util.List;

public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;

    public HotelServiceImpl() {
        this.hotelRepository = new HotelRepository();
    }

    @Override
    public void registrarHotel(Hotel hotel) {
        hotelRepository.guardarHotel(hotel);
    }

    @Override
    public List<Hotel> obtenerHoteles() {
        return hotelRepository.obtenerHoteles();
    }

    @Override
    public void eliminarHotel(String nombre) {
        hotelRepository.eliminarHotel(nombre);
    }

    @Override
    public void actualizarHotel(Hotel hotel) {
        hotelRepository.actualizarHotel(hotel);
    }
}
