package com.alura.foro.record.topico;

import com.alura.modelo.StatusTopico;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
		@NotNull
        Long id,
        String titulo,
        String mensaje,
        StatusTopico estado,
        Long autor,
        Long curso) {

	public Long id() {
		// TODO Auto-generated method stub
		return null;
	}

}
