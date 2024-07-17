package com.aluracursos.Challenge.One.Foro.Hub.usuario;

import jakarta.validation.constraints.NotEmpty;

public record AutenticarUsuario(
        @NotEmpty String usuario,
        @NotEmpty String contrasena) {
}
