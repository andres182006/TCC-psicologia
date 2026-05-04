package com.Unicartagena.TCC.aplication.Service;

import com.Unicartagena.TCC.aplication.DTO.UsuarioDTO;
import com.Unicartagena.TCC.aplication.Request.CrearUsuarioRequest;



public interface IUsuarioService {
    UsuarioDTO create(CrearUsuarioRequest crearUsuarioRequest);
}
