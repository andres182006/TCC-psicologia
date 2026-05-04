package com.Unicartagena.TCC.aplication.Repository;

import com.Unicartagena.TCC.aplication.Entities.Rol;
import com.Unicartagena.TCC.aplication.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar por nombre (barra de búsqueda)
    Optional<Usuario> findByNombreCompleto(String nombreCompleto);

    // Buscar por correo (útil para login o validar duplicados)
    Optional<Usuario> findByCorreo(String correo);

    // Buscar por código de estudiante
    Optional<Usuario> findByCodigoEstudiante(Long codigoEstudiante);

    // Buscar por celular
    Optional<Usuario> findByCelular(Long celular);

    // Listar todos los usuarios por rol (ej: todos los estudiantes, todas las psicólogas)
    List<Usuario> findByRol(Rol rol);

    //para el login
    Optional<Usuario> findByCorreoAndContrasena(String correo, String contrasena);


    // Obtener todas las psicólogas para mostrarlas al agendar una cita
   // tiene errores: List<Usuario> psicologas = usuarioRepository.findByRol(rolPsicologa);

    // Obtener todos los estudiantes
    // tiene errores:List<Usuario> estudiantes = usuarioRepository.findByRol(rolEstudiante);
}
