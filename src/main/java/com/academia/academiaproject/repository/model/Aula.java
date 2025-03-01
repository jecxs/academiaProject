package com.academia.academiaproject.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="aulas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aula extends BaseEntity{
    private String nombre;
    private String aforo;

    @ManyToOne
    @JoinColumn(name = "sede_id", nullable = false)
    private Sede sede;
}
