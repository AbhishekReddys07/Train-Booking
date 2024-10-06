document.addEventListener('DOMContentLoaded', loadSeats);

function loadSeats() {
    fetch('/api/seats/available')
        .then(response => response.json())
        .then(seats => {
            const seatLayout = document.getElementById('seat-layout');
            seatLayout.innerHTML = '';  // Clear existing seats
            seats.forEach(seat => {
                const seatDiv = document.createElement('div');
                seatDiv.classList.add('seat');
                if (seat.isBooked) {
                    seatDiv.classList.add('booked');
                }
                seatLayout.appendChild(seatDiv);
            });
        });
}

function bookSeats() {
    const numberOfSeats = document.getElementById('seats').value;
    fetch('/api/seats/book', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ numberOfSeats: parseInt(numberOfSeats) })
    })
    .then(response => response.json())
    .then(bookingResult => {
        const statusDiv = document.getElementById('status');
        statusDiv.innerHTML = `Seats booked: ${bookingResult.map(seat => seat.seatNumber).join(', ')}`;
        loadSeats();
    })
    .catch(error => {
        console.error('Error:', error);
    });
}
