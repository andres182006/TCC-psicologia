package com.Unicartagena.TCC.aplication.Controller;

import com.Unicartagena.TCC.aplication.DTO.LoginDTO;
import com.Unicartagena.TCC.aplication.Entities.Usuario;
import com.Unicartagena.TCC.aplication.Service.impl.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO request) {

        Usuario usuario = usuarioService.login(
                request.getCorreo(),
                request.getContrasena()
                );

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciales incorrectas");
        }
    }
}