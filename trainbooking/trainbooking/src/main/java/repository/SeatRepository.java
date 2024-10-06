package repository;

import model.Seat;
import java.util.List;

public interface SeatRepository {
    List<Seat> findByRowNumberAndIsBookedFalse(int rowNumber);
    List<Seat> findByIsBookedFalse();
	void bookSeat(int seatNumber);
}
