package com.aluracursos.Challenge.One.Foro.Hub.topico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//JPA requiere de dos parametros, la entidad con que trabajare y el tipo de objeto del id
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<Topico> findAllById(Long id);
}
