package com.academia.academiaproject.repository;

import com.academia.academiaproject.repository.model.Docente;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DocenteRepository extends JpaRepository<Docente, Long> {
    Optional<Docente> findByCorreo(String correo);
}