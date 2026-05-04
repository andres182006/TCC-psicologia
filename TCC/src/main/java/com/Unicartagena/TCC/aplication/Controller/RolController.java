package com.Unicartagena.TCC.aplication.Controller;

import com.Unicartagena.TCC.aplication.DTO.RolDTO;
import com.Unicartagena.TCC.aplication.Request.CrearRolRequest;
import com.Unicartagena.TCC.aplication.Service.impl.RolService;
import com.Unicartagena.TCC.base.configs.dto.ResponseDTO;
import com.Unicartagena.TCC.base.utils.ResponseDTOService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Rol")
@RequiredArgsConstructor
public class RolController {
    private final ResponseDTOService responseDTOService;
    private final RolService rolService;

    @PostMapping("/saveRol")
    public ResponseEntity<RolDTO> saveUser (@Valid @RequestBody CrearRolRequest crearRolRequest,
                                            BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return (ResponseEntity<RolDTO>) responseDTOService.response(HttpStatus.BAD_REQUEST);
        }else {
            return (ResponseEntity<RolDTO>) responseDTOService.response(rolService.create(crearRolRequest), HttpStatus.CREATED);
        }
    }

}
