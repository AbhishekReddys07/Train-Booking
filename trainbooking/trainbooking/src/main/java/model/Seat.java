package model;
public class Seat {
    private int seatNumber;
    private int rowNumber;
    private boolean booked;

    public Seat(int seatNumber, int j) {
        this.seatNumber = seatNumber;
        this.rowNumber = (seatNumber - 1) / 7 + 1; // Assuming 7 seats per row
        this.booked = false;
    }
    
    // Getters and setters
    public int getSeatNumber() {
        return seatNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
