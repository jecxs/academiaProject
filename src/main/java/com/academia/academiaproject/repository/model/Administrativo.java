package com.academia.academiaproject.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "administrativos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Administrativo extends BaseEntity {

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String cargo;
}
