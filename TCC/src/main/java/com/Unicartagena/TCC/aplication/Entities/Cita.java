package com.Unicartagena.TCC.aplication.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "cita")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Integer idCita;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora")
    private LocalTime hora;

    @Column(name = "motivo", nullable = false, length = 100)
    private String motivo;

    // FK 1 → usuario (estudiante/paciente)
    @ManyToOne
    @JoinColumn(name = "n_documento_estudiante", referencedColumnName = "n_documento",
    insertable = true, updatable= true)
    private Usuario usuario;

    // FK 2 → usuario (psicóloga) — misma tabla, distinta columna
    @ManyToOne
    @JoinColumn(name = "n_documento_psicologa", referencedColumnName = "n_documento",
            insertable = true, updatable= true)
    private Usuario psicologa;
}
