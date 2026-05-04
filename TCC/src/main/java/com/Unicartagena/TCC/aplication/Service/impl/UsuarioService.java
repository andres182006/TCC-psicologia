package com.Unicartagena.TCC.aplication.Service.impl;

import com.Unicartagena.TCC.aplication.DTO.UsuarioDTO;
import com.Unicartagena.TCC.aplication.Entities.Usuario;
import com.Unicartagena.TCC.aplication.Repository.UsuarioRepository;
import com.Unicartagena.TCC.aplication.Request.CrearUsuarioRequest;
import com.Unicartagena.TCC.aplication.Service.IUsuarioService;
import com.Unicartagena.TCC.base.exceptions.AlreadyExists;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    public Usuario login(String correo, String contrasena) {
        return usuarioRepository
                .findByCorreoAndContrasena(correo, contrasena)
                .orElse(null);
    }
    @Override
    @Transactional(rollbackOn = Exception.class)
    public UsuarioDTO create(CrearUsuarioRequest crearUsuarioRequest) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByCorreo(crearUsuarioRequest.getCorreo());
        if (usuarioOptional.isPresent()) {
            throw new AlreadyExists("Error un usuario ya se encuentra registrado"
                    + crearUsuarioRequest.getCorreo());
        } else {
            Usuario newusuario = new Usuario();
            newusuario.setNdocumento(Long.valueOf(crearUsuarioRequest.getNdocumento()));
            newusuario.setNombreCompleto(crearUsuarioRequest.getNombreCompleto());
            newusuario.setCelular(crearUsuarioRequest.getCelular());
            newusuario.setCorreo(crearUsuarioRequest.getCorreo());
            newusuario.setTdocumento(crearUsuarioRequest.getTdocumento());
            newusuario.setCodigoEstudiante(Long.valueOf(crearUsuarioRequest.getCodigoEstudiante()));
            newusuario.setRol(crearUsuarioRequest.getRol());
            newusuario.setContrasena(crearUsuarioRequest.getContrasena());

            UsuarioDTO usuarioDTO = modelMapper.map(usuarioRepository.save(newusuario),
                    UsuarioDTO.class);
            return usuarioDTO;
        }

    }

}
