package com.Unicartagena.TCC.aplication.DTO;

import com.Unicartagena.TCC.aplication.Entities.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolDTO {
    private Integer idRol;
    private Rol.NombreRol nombreRol;
}
