package com.Unicartagena.TCC.aplication.Service.impl;

import com.Unicartagena.TCC.aplication.DTO.CitaDTO;
import com.Unicartagena.TCC.aplication.Entities.Cita;
import com.Unicartagena.TCC.aplication.Repository.CitaRepository;
import com.Unicartagena.TCC.aplication.Request.CrearCitaRequest;
import com.Unicartagena.TCC.aplication.Service.ICitaService;
import com.Unicartagena.TCC.base.exceptions.AlreadyExists;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CitaService implements ICitaService {
    private final CitaRepository citaRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public CitaDTO create(CrearCitaRequest crearCitaRequest) {
        //Verifica que no haya ya una cita en esa fecha y hora
        Optional<Cita> citaOptional = citaRepository.findByFechaAndHora(
                crearCitaRequest.getFecha(),
                crearCitaRequest.getHora()
        );
        if (citaOptional.isPresent()){
            throw new AlreadyExists("Ya existe una cita en esa fecha y hora");
        }else {
            //crea la cita
            Cita newCita = new Cita();
            newCita.setFecha(crearCitaRequest.getFecha());
            newCita.setHora(crearCitaRequest.getHora());
            newCita.setMotivo(crearCitaRequest.getMotivo());
            newCita.setUsuario(crearCitaRequest.getUsuario());
            newCita.setPsicologa(crearCitaRequest.getPsicologa());
            CitaDTO citaDTO = modelMapper.map(citaRepository.save(newCita),
                    CitaDTO.class);
            return citaDTO;
        }


    }
}
