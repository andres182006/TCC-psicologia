package com.Unicartagena.TCC.aplication.DTO;

import com.Unicartagena.TCC.aplication.Entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaDTO {
    private Integer idCita;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private Usuario usuario;
    private Usuario psicologa;
}
