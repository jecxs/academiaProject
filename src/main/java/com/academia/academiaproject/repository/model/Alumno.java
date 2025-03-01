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
@Table(name = "alumno")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alumno extends BaseEntity{

    private String nombre;
    private String apellido;
    private String telefono;
    private String telefonoSecundario;

   @ManyToOne
   @JoinColumn(name = "carrera_id")
   private CarreraProfesional carrera;
}
