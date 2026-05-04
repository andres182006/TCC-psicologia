package com.Unicartagena.TCC.aplication.Service;

import com.Unicartagena.TCC.aplication.DTO.RolDTO;
import com.Unicartagena.TCC.aplication.Request.CrearRolRequest;

public interface IRolService {
    RolDTO create(CrearRolRequest crearRolRequest);
}
