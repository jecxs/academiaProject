package com.academia.academiaproject.repository;

import com.academia.academiaproject.repository.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    List<Alumno> findByCarreraId(Long carreraId);
}
