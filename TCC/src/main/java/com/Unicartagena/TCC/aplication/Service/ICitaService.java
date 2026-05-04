package com.Unicartagena.TCC.aplication.Service;

import com.Unicartagena.TCC.aplication.DTO.CitaDTO;
import com.Unicartagena.TCC.aplication.Request.CrearCitaRequest;

public interface ICitaService {
    CitaDTO create(CrearCitaRequest crearCitaRequest);
}
