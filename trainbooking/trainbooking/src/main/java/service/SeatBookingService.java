package service;

import model.Seat;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatBookingService {
    private List<Seat> seats; // List to hold seat information

    public SeatBookingService() {
        this.seats = new ArrayList<>();
        initializeSeats(); // Initialize seats
    }

    // Initialize seats (for example, create 12 rows with 7 seats each)
    private void initializeSeats() {
        // Create 10 rows of seats
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 7; j++) {
                // Last row (10th) has only 3 seats
                if (i == 10 && j > 3) break; 
                seats.add(new Seat(i, j)); // Assuming Seat constructor takes row and seat number
            }
        }
    }


    // Get available seats by row
    public List<Seat> getAvailableSeatsByRow(int rowNumber) {
        List<Seat> availableSeats = new ArrayList<>();
        for (Seat seat : seats) {
            if (seat.getRowNumber() == rowNumber && !seat.isBooked()) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }

    // Get all available seats
    public List<Seat> getAllAvailableSeats() {
        List<Seat> availableSeats = new ArrayList<>();
        for (Seat seat : seats) {
            if (!seat.isBooked()) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }

    // Book seats
    public List<Seat> bookSeats(int numSeats) {
        List<Seat> bookedSeats = new ArrayList<>();
        for (Seat seat : seats) {
            if (!seat.isBooked() && bookedSeats.size() < numSeats) {
                seat.setBooked(true); // Mark seat as booked
                bookedSeats.add(seat);
            }
        }
        return bookedSeats; // Return booked seats
    }
}
