package company.ephorsys.service;

import company.ephorsys.model.entity.BookingEntity;
import org.springframework.http.ResponseEntity;

public interface BookingService {

    ResponseEntity<?> getAllBookings();
    ResponseEntity<?> bookingRegistration(BookingEntity registration);


}
