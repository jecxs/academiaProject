package com.academia.academiaproject.repository.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name="sedes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sede extends BaseEntity{
    private String nombre;
    private String direccion;

    @OneToMany(mappedBy = "sede", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aula> aulas;
}

