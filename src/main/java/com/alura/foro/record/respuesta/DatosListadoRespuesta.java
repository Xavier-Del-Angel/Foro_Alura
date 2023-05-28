package com.alura.foro.record.respuesta;

import com.alura.modelo.Respuesta;

public record DatosListadoRespuesta(
		 Long id,
	        String mensaje,
	        String fechaCreacion,
	        Boolean solucion) {

	public DatosListadoRespuesta(Respuesta respuesta) {
        this(respuesta.getRespuestaId(),
                respuesta.getMensaje(),
                respuesta.getFechaCreacion().toString(),
                respuesta.getSolucion()
        );
    }
}
