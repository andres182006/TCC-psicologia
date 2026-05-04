package com.Unicartagena.TCC.aplication.Service.impl;

import com.Unicartagena.TCC.aplication.DTO.RolDTO;
import com.Unicartagena.TCC.aplication.Entities.Rol;
import com.Unicartagena.TCC.aplication.Repository.RolRepository;
import com.Unicartagena.TCC.aplication.Request.CrearRolRequest;
import com.Unicartagena.TCC.aplication.Service.IRolService;
import com.Unicartagena.TCC.base.exceptions.AlreadyExists;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolService implements IRolService {
    private final RolRepository rolRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public RolDTO create(CrearRolRequest crearRolRequest) {
        Optional<Rol> rolOptional = rolRepository.findByNombreRol(crearRolRequest.getNombreRol());
        if (rolOptional.isPresent()) {
            throw new AlreadyExists("Error ya se encuentra registrado esos id´s"
                    + crearRolRequest.getNombreRol());
        } else {
            Rol newrol = new Rol();
            newrol.setNombreRol(crearRolRequest.getNombreRol());

            RolDTO rolDTO = modelMapper.map(rolRepository.save(newrol),
                    RolDTO.class);
            return rolDTO;
        }

    }
}
