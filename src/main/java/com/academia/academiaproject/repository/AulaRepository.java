package com.academia.academiaproject.repository;

import com.academia.academiaproject.repository.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {
    List<Aula> findBySedeId(Long sedeId);
}
