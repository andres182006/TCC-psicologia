package com.Unicartagena.TCC.aplication.Repository;

import com.Unicartagena.TCC.aplication.Entities.Cita;
import com.Unicartagena.TCC.aplication.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {

    List<Cita> findByUsuario(Usuario usuario);
    List<Cita> findByUsuarioAndFecha(Usuario usuario, LocalDate fecha);

    List<Cita> findByPsicologa(Usuario psicologa);
    List<Cita> findByPsicologaAndFecha(Usuario psicologa, LocalDate fecha);

    List<Cita> findByFecha(LocalDate fecha);
    Optional<Cita> findByFechaAndHora(LocalDate fecha, LocalTime hora);
}
