package com.Unicartagena.TCC.aplication.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table (name = "usuario")
public class Usuario {
    public enum TipoDocumento {
        CC,
        TI
    }
    @Id
    @Column(name = "n_documento")
    private Long ndocumento;

    @Enumerated(EnumType.STRING)
    @Column(name = "t_documento", nullable = false)
    private TipoDocumento tdocumento;

    @Column(name = "codigo_estudiante",nullable = true)
    private Long codigoEstudiante;

    @Column(name = "celular", nullable = false)
    private Long celular; // Long es más seguro que int

    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @Column(name = "nombre_completo", nullable = false, length = 100)
    private String nombreCompleto;

    @Column(name = "contrasena", nullable = true, length = 255)
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    private Rol rol;
}
