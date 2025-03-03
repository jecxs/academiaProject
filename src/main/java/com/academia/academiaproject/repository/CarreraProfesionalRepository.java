package com.academia.academiaproject.repository;

import com.academia.academiaproject.repository.model.CarreraProfesional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarreraProfesionalRepository extends JpaRepository<CarreraProfesional, Long> {
    Optional<CarreraProfesional> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
