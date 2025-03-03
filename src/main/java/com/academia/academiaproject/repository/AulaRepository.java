package com.academia.academiaproject.repository;

import com.academia.academiaproject.repository.model.Aula;
import com.academia.academiaproject.repository.model.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {
    Optional<Aula> findByNombreAndSede(String nombre, Sede sede);
    List<Aula> findBySede(Sede sede);
    List<Aula> findBySedeId(Long sedeId);
}
