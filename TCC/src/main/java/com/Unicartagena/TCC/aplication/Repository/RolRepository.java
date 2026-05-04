package com.Unicartagena.TCC.aplication.Repository;

import com.Unicartagena.TCC.aplication.Entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByNombreRol(Rol.NombreRol nombreRol);
}
