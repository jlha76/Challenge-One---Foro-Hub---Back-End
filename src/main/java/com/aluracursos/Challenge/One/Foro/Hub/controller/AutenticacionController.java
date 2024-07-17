package com.aluracursos.Challenge.One.Foro.Hub.controller;


import com.aluracursos.Challenge.One.Foro.Hub.infra.security.DatosJWTtoken;
import com.aluracursos.Challenge.One.Foro.Hub.infra.security.TokenService;
import com.aluracursos.Challenge.One.Foro.Hub.usuario.AutenticarUsuario;
import com.aluracursos.Challenge.One.Foro.Hub.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid AutenticarUsuario autenticarUsuario) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(autenticarUsuario.usuario(), autenticarUsuario.contrasena());
        var usuarioAutenticado = authenticationManager.authenticate(authentication);
        var JwtToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTtoken(JwtToken));
    }
}
