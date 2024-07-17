package com.aluracursos.Challenge.One.Foro.Hub.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String mensaje;
    private Long autor_id;
    private String curso;
    private String status;


    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.autor_id = datosRegistroTopico.autor_id();
        this.curso = datosRegistroTopico.curso();
        this.status = "activo";
    }

    public void actualizarTopico(DatosActualizarTopico datosActualizarTopico) {
        if(datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if(datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if(datosActualizarTopico.autor_id() != null){
            this.autor_id = datosActualizarTopico.autor_id();
        }
        if(datosActualizarTopico.curso() != null){
            this.curso = datosActualizarTopico.curso();
        }
        if(datosActualizarTopico.status() != null){
            this.status = datosActualizarTopico.status();
        }

    }
}
