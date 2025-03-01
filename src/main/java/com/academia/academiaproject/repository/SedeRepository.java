package com.academia.academiaproject.repository;

import com.academia.academiaproject.repository.model.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Long> {
}