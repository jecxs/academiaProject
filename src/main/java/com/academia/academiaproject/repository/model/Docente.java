package com.academia.academiaproject.repository.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "docentes")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Docente extends BaseEntity{

    private String nombre;
    private String apellido;
    private String telefono;
    private String especialidad;

    @Column(unique = true, nullable = false)
    private String correo;

    private String descripcion;
}