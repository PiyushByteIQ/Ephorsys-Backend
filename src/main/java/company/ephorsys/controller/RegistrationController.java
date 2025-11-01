package company.ephorsys.controller;

import company.ephorsys.model.entity.RegistrationEntity;
import company.ephorsys.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/")
    private String healthcheck(){
        return "Healthy";
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers(){
        return registrationService.getAllUsers();
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationEntity registrationEntity){
        return registrationService.registerUser(registrationEntity);
    }
}
