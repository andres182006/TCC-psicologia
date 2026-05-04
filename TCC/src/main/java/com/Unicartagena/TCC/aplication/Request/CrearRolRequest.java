package com.Unicartagena.TCC.aplication.Request;

import com.Unicartagena.TCC.aplication.Entities.Rol;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearRolRequest {


    private Integer idRol;

    @Enumerated(EnumType.STRING)
    @Column(name = "nombre_rol")
    private Rol.NombreRol nombreRol;

    // Enum interno que refleja el ENUM de MySQL
    public enum NombreRol {
        estudiante,
        administrativo,
        psicologa
    }
}
