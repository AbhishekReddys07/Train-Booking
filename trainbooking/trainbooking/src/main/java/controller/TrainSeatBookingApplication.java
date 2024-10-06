package controller;
import model.Seat;
import securityconfig.InputUtil;
import service.SeatBookingService;

import java.util.List;

public class TrainSeatBookingApplication {
    public static void main(String[] args) {
        SeatBookingService bookingService = new SeatBookingService();

        while (true) {
            System.out.println("\nTrain Seat Booking System");
            System.out.println("1. View Available Seats by Row");
            System.out.println("2. View All Available Seats");
            System.out.println("3. Book Seats");
            System.out.println("4. Exit");

            int choice = InputUtil.getInt("Choose an option: ");
            switch (choice) {
                case 1:
                    int rowNumber = InputUtil.getInt("Enter row number (1-12): ");
                    List<Seat> seatsInRow = bookingService.getAvailableSeatsByRow(rowNumber);
                    System.out.println("Available Seats in Row " + rowNumber + ": " + seatsInRow);
                    break;
                case 2:
                    List<Seat> allAvailableSeats = bookingService.getAllAvailableSeats();
                    System.out.println("All Available Seats: " + allAvailableSeats);
                    break;
                case 3:
                    int numSeats = InputUtil.getInt("Enter number of seats to book: ");
                    List<Seat> bookedSeats = bookingService.bookSeats(numSeats);
                    if (bookedSeats.isEmpty()) {
                        System.out.println("Not enough seats available.");
                    } else {
                        System.out.println("Successfully booked seats: " + bookedSeats);
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
