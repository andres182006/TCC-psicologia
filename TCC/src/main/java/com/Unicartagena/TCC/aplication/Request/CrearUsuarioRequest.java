package com.Unicartagena.TCC.aplication.Request;

import com.Unicartagena.TCC.aplication.Entities.Rol;
import com.Unicartagena.TCC.aplication.Entities.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearUsuarioRequest {
    @Id
    @Column(name = "n_documento")
    private Long ndocumento;

    @Column(name = "t_documento", nullable = false, length = 100)
    private Usuario.TipoDocumento tdocumento;

    @Column(name = "código_estudiante", nullable = true)
    private Long codigoEstudiante; // nullable por defecto

    @Column(name = "celular", nullable = false)
    private Long celular; // Long es más seguro que int

    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @Column(name = "nombre_completo", nullable = false, length = 100)
    private String nombreCompleto;

    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    private Rol rol;

    @Column(name = "contrasena", nullable = false, length = 255)
    private String contrasena;
}
