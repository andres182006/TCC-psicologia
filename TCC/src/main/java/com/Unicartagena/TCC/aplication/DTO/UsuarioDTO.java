package com.Unicartagena.TCC.aplication.DTO;

import com.Unicartagena.TCC.aplication.Entities.Rol;
import com.Unicartagena.TCC.aplication.Entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long ndocumento;
    private Usuario.TipoDocumento tdocumento;
    private Long codigoEstudiante;
    private Long celular;
    private String correo;
    private String nombreCompleto;
    private Rol rol;
    private String contrasena;
}
