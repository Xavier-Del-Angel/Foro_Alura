package com.alura.foro.record.topico;

import java.time.LocalDateTime;
import com.alura.modelo.StatusTopico;

public record DatosRespuestaTopico(
		Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico estado,
        Long autor,
        Long curso) {

}
