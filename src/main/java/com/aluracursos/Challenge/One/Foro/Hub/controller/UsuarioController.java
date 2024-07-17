package com.aluracursos.Challenge.One.Foro.Hub.controller;

import com.aluracursos.Challenge.One.Foro.Hub.usuario.DatosRegistroUsuario;
import com.aluracursos.Challenge.One.Foro.Hub.usuario.Usuario;
import com.aluracursos.Challenge.One.Foro.Hub.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void registrarUsuario(@Valid @RequestBody DatosRegistroUsuario datosRegistroUsuario){
        usuarioRepository.save(new Usuario(datosRegistroUsuario));
       // System.out.println(datosRegistroUsuario);
    }
}
