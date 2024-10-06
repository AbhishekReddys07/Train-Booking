package service;
import org.springframework.stereotype.Service;

import model.Seat;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService {

    private List<Seat> seats; // Assume this is your list of seats

    public SeatService() {
        // Initialize your seats list (e.g., load from a database or predefined list)
        seats = new ArrayList<>();
        // Fill with example data, or load from your database
    }

    // Method to fetch available seats by row
    public List<Integer> getAvailableSeatsByRow(int rowNumber) {
        List<Integer> availableSeats = new ArrayList<>();
        // Assume seats are indexed starting from 1
        for (Seat seat : seats) {
            if (seat.getRowNumber() == rowNumber && !seat.isBooked()) {
                availableSeats.add(seat.getSeatNumber());
            }
        }
        return availableSeats;
    }

    // Method to fetch all available seats
    public List<Integer> getAllAvailableSeats() {
        List<Integer> availableSeats = new ArrayList<>();
        for (Seat seat : seats) {
            if (!seat.isBooked()) {
                availableSeats.add(seat.getSeatNumber());
            }
        }
        return availableSeats;
    }

    // Method to book seats
    public List<Integer> bookSeats(int numSeats) {
        List<Integer> bookedSeats = new ArrayList<>();
        for (Seat seat : seats) {
            if (!seat.isBooked() && bookedSeats.size() < numSeats) {
                seat.setBooked(true);
                bookedSeats.add(seat.getSeatNumber());
            }
        }
        return bookedSeats;
    }
}
