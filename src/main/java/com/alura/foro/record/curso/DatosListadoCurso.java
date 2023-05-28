package com.alura.foro.record.curso;

import com.alura.modelo.Curso;

public record DatosListadoCurso(Long id, String nombre, String categoria) {

	public DatosListadoCurso(Curso curso) {
        this(curso.getCursoId(), curso.getNombre(), curso.getCategoria());
    }
}
