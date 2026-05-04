package com.Unicartagena.TCC.aplication.Controller;

import com.Unicartagena.TCC.aplication.DTO.UsuarioDTO;
import com.Unicartagena.TCC.aplication.Request.CrearUsuarioRequest;
import com.Unicartagena.TCC.aplication.Service.impl.UsuarioService;
import com.Unicartagena.TCC.base.utils.ResponseDTOService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final ResponseDTOService responseDTOService;
    private final UsuarioService usuarioService;

    @PostMapping("/saveUsuario")
    public ResponseEntity<UsuarioDTO> saveUser(@Valid @RequestBody CrearUsuarioRequest crearUsuarioRequest,
                                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return (ResponseEntity<UsuarioDTO>) responseDTOService.response(HttpStatus.BAD_REQUEST);

        }else {
            return (ResponseEntity<UsuarioDTO>) responseDTOService.response(usuarioService.create(crearUsuarioRequest), HttpStatus.CREATED);
        }

    }
}



