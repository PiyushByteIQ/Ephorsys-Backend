package company.ephorsys.service;

import company.ephorsys.model.entity.RegistrationEntity;
import org.springframework.http.ResponseEntity;

public interface RegistrationService {

    ResponseEntity<?> getAllUsers();
    ResponseEntity<?> registerUser(RegistrationEntity registration);


}
