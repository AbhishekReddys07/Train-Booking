package controller;

import model.Seat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.SeatBookingService;

import java.util.List;

@Controller
public class SeatBookingController {

    private final SeatBookingService bookingService = new SeatBookingService();

 

        @GetMapping("/seat-map")
        public String getSeatMap(Model model) {
            // Add logic to populate the seat data
            model.addAttribute("seats", bookingService.getAllAvailableSeats());
            return "seat_map"; // Name of your HTML template
        }

        @PostMapping("/book-seats")
        public String bookSeats(@RequestParam int seatNumbers, Model model) {
            // Logic to book the selected seats
            bookingService.bookSeats(seatNumbers);
            return "redirect:/seat-map"; // Redirect after booking
        }
}
