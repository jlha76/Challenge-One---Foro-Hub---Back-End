package com.aluracursos.Challenge.One.Foro.Hub.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String usuario,
        @NotBlank
        String contrasena,
        @NotBlank
        String perfil ) {
}

