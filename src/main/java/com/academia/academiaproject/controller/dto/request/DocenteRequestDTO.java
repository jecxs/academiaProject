package com.academia.academiaproject.controller.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DocenteRequestDTO(

        @NotBlank(message = "El campo no debe estar vacio")
        @Size(min = 2, max = 25, message = "El nombre debe tener 2 caracteres como minimo y 25 como maximo")
        String nombre,

        String apellido,


        @Pattern(regexp = "^\\+?\\d{1,3}?[-.\\s]?\\(?\\d{1,4}\\)?[-.\\s]?\\d{3,4}[-.\\s]?\\d{3,4}$\n",message = "El telefono debe tener un formato preestablecido, ejemplos: +51 999-888-777/ " +
                " +1 (800) 123-4567" +
                "/ 987654321 " +
                "/ 01-2345-6789")
        String telefono,

        String especialidad,

        @Email(message = "El correo debe ser valido")
        String correo,

        String descripcion

) {}
