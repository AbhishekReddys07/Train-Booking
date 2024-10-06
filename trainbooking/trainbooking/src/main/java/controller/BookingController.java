package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import model.Seat;
import service.SeatBookingService;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private SeatBookingService seatService; // Assume this service contains logic for seat management

    // Endpoint to fetch available seats by row
    @GetMapping("/availableSeatsByRow/{rowNumber}")
    public List<Seat> getAvailableSeatsByRow(@PathVariable int rowNumber) {
        return seatService.getAvailableSeatsByRow(rowNumber);
    }

    // Endpoint to fetch all available seats
    @GetMapping("/available")
    public List<Seat> getAllAvailableSeats() {
        return seatService.getAllAvailableSeats();
    }

    // Endpoint to book seats
    @PostMapping("/bookSeats")
    public List<Seat> bookSeats(@RequestParam int numSeats) {
        return seatService.bookSeats(numSeats);
    }
}
