package com.Unicartagena.TCC.aplication.Request;

import com.Unicartagena.TCC.aplication.Entities.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
public class CrearCitaRequest {

    private Integer idCita;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora")
    private LocalTime hora;

    @Column(name = "motivo", nullable = false, length = 100)
    private String motivo;

    // FK 1 → usuario (estudiante/paciente)
    @ManyToOne
    @JoinColumn(name = "n_documento_estudiante", referencedColumnName = "n_documento")
    private Usuario usuario;

    // FK 2 → usuario (psicóloga) — misma tabla, distinta columna
    @ManyToOne
    @JoinColumn(name = "n_documento_psicologa", referencedColumnName = "n_documento")
    private Usuario psicologa;
}
