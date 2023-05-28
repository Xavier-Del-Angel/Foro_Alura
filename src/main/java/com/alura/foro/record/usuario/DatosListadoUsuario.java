package com.alura.foro.record.usuario;

import com.alura.modelo.Usuario;

public record DatosListadoUsuario(Long id, String nombre, String email) {

	 public DatosListadoUsuario(Usuario usuario) {
	        this(usuario.getUsuarioId(), usuario.getNombre(), usuario.getEmail());
	    }
}
