package com.aluracursos.Challenge.One.Foro.Hub.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
         @NotNull long id,
         String titulo,
         String mensaje,
         Long autor_id,
         String curso,
         String status ) {
}
