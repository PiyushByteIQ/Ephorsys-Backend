package company.ephorsys.model.mapper;

import company.ephorsys.model.dto.RegistrationDto;
import company.ephorsys.model.entity.RegistrationEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RegistrationMapper {

    public static RegistrationEntity toEntity(RegistrationDto dto) {
        if (dto == null) return null;

        RegistrationEntity registration = new RegistrationEntity();
        registration.setId(dto.getId());
        registration.setName(dto.getName());
        registration.setEmail(dto.getEmail());
        registration.setPhone(dto.getPhone());
        registration.setMessage(dto.getMessage());

        return registration;
    }

    public static RegistrationDto toDto(RegistrationEntity registration) {
        if (registration == null) return null;

        RegistrationDto dto = new RegistrationDto();
        dto.setId(registration.getId());
        dto.setName(registration.getName());
        dto.setEmail(registration.getEmail());
        dto.setPhone(registration.getPhone());
        dto.setMessage(registration.getMessage());

        return dto;
    }

    public static List<RegistrationDto> toDtoList(List<RegistrationEntity> registrations) {
        if (registrations == null) return null;

        return registrations.stream()
                .map(RegistrationMapper::toDto)
                .collect(Collectors.toList());
    }
}
