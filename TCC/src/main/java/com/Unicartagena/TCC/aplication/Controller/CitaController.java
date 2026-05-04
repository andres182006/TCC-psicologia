package com.Unicartagena.TCC.aplication.Controller;

import com.Unicartagena.TCC.aplication.DTO.CitaDTO;
import com.Unicartagena.TCC.aplication.Request.CrearCitaRequest;
import com.Unicartagena.TCC.aplication.Service.impl.CitaService;
import com.Unicartagena.TCC.base.utils.ResponseDTOService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Cita")
@RequiredArgsConstructor
public class CitaController {
    private final ResponseDTOService responseDTOService;
    private final CitaService citaService;
    @PostMapping("/saveCita")
    public ResponseEntity<CitaDTO> saveUser(@Valid @RequestBody CrearCitaRequest crearCitaRequest,
                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return (ResponseEntity<CitaDTO>) responseDTOService.response(HttpStatus.BAD_REQUEST);
        }else {
            return (ResponseEntity<CitaDTO>) responseDTOService.response(citaService.create(crearCitaRequest), HttpStatus.CREATED);
        }
    }
}
