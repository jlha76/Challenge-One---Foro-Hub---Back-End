package com.aluracursos.Challenge.One.Foro.Hub.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Long autor_id,
        @NotBlank
        String curso) {
}
