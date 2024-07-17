package com.aluracursos.Challenge.One.Foro.Hub.controller;

import com.aluracursos.Challenge.One.Foro.Hub.topico.DatosActualizarTopico;
import com.aluracursos.Challenge.One.Foro.Hub.topico.DatosRegistroTopico;
import com.aluracursos.Challenge.One.Foro.Hub.topico.Topico;
import com.aluracursos.Challenge.One.Foro.Hub.topico.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;


    @PostMapping
    public void registrarTopico(@Valid @RequestBody DatosRegistroTopico datosRegistroTopico){
        System.out.println(datosRegistroTopico);
        topicoRepository.save(new Topico(datosRegistroTopico));
    }

    @GetMapping
    public List<Topico> listadoTopicos(){
        return topicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<Topico> detallar(@PathVariable Long id) {
        return topicoRepository.findAllById(id);
    }

    @PutMapping
    @Transactional
    public void actualizarTopico(@Valid @RequestBody DatosActualizarTopico datosActualizarTopico){
        //busco en mi bd para obtener el topico
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        if (topico != null) {
            topico.actualizarTopico(datosActualizarTopico);
        }
        else {
            System.out.println("Topico es null");
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        if (topico != null){
            //topicoRepository.delete(topico);
            topicoRepository.deleteById(id);
        }
        else {
            System.out.println("Topico es null");
        }
    }
}
