package com.alura.foro.controller;

import com.alura.foro.config.security.AutenticacionService;
import com.alura.foro.config.security.TokenService;
import com.alura.modelo.Usuario;
import com.alura.foro.record.autentificacion.DatosAutenticarUsuario;
import com.alura.foro.record.autentificacion.DatosJwtToken;
import jakarta.validation.Valid;
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
public class AunteticacionController {

	 private final AuthenticationManager authenticationManager;
	    private final TokenService tokenService;

	    public AunteticacionController(AuthenticationManager authenticationManager, TokenService tokenService) {
	        this.authenticationManager = authenticationManager;
	        this.tokenService = tokenService;
	    }

	    @PostMapping
	    public ResponseEntity autenticarLogin(@RequestBody @Valid DatosAutenticarUsuario datosAutenticarUsuario) {
	        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticarUsuario.nombre(),
	                datosAutenticarUsuario.contrasena());
	        var authUsuario = authenticationManager.authenticate(authToken);
	        var jwtToken = tokenService.generarToken((Usuario) authUsuario.getPrincipal());
	        return ResponseEntity.ok(new DatosJwtToken(jwtToken));
	    }
}
