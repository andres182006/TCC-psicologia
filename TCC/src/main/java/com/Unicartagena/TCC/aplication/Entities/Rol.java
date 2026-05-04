package com.Unicartagena.TCC.aplication.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;

    @Enumerated(EnumType.STRING)
    @Column(name = "nombre_rol")
    private NombreRol nombreRol;

    // Enum interno que refleja el ENUM de MySQL
    public enum NombreRol {
        estudiante,
        administrativo,
        psicologa
    }
}
