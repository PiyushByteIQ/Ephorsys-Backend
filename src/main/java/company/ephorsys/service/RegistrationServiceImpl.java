package company.ephorsys.service;

import company.ephorsys.model.dto.RegistrationDto;
import company.ephorsys.model.entity.RegistrationEntity;
import company.ephorsys.model.mapper.RegistrationMapper;
import company.ephorsys.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private RegistrationMapper registrationMapper;

    @Override
    public ResponseEntity<?> getAllUsers(){
        List<RegistrationEntity> allUsers = registrationRepository.findAll();
        List<RegistrationDto> allUsersList = registrationMapper.toDtoList(allUsers);
        return new ResponseEntity<>(allUsersList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> registerUser(RegistrationEntity registration){
        Optional<RegistrationEntity> existingEmail = registrationRepository.findByEmail(registration.getEmail());
        if(existingEmail.isPresent()){
            return new ResponseEntity<>("Email Already Exists.", HttpStatus.BAD_REQUEST);
        }else {
            RegistrationEntity save = registrationRepository.save(registration);
            RegistrationDto dto = registrationMapper.toDto(save);
            return ResponseEntity.ok("User added successfully");
        }
    }

}
