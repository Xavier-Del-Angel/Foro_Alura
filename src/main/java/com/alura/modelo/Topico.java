package com.alura.modelo;

import com.alura.modelo.Respuesta;
import com.alura.modelo.Curso;
import com.alura.modelo.Usuario;
import com.alura.foro.record.topico.DatosActualizarTopico;
import com.alura.foro.record.topico.DatosRegistroTopico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Topico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "topico_id")
	private Long topicoId;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "mensaje")
	private String mensaje;
	
	@Column(name = "fecha_creacion")
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estado")
	private StatusTopico estado = StatusTopico.NO_RESPONDIDO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "autor_id")
	private Usuario autor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	 @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
	    private Set<Respuesta> respuestas = new HashSet<>();

	    public Topico(Long topicoId) {
	        this.topicoId = topicoId;
	    }

	    public Topico(DatosRegistroTopico datosRegistroTopico) {
	        this.titulo = datosRegistroTopico.titulo();
	        this.mensaje = datosRegistroTopico.mensaje();
	        this.estado = datosRegistroTopico.estado();
	        this.autor = new Usuario(datosRegistroTopico.autor());
	        this.curso = new Curso(datosRegistroTopico.curso());
	    }

	    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
	        if (datosActualizarTopico.titulo() != null) {
	            this.titulo = datosActualizarTopico.titulo();
	        }
	        if (datosActualizarTopico.mensaje() != null) {
	            this.mensaje = datosActualizarTopico.mensaje();
	        }
	        if (datosActualizarTopico.estado() != null) {
	            this.estado = datosActualizarTopico.estado();
	        }
	        if (datosActualizarTopico.autor() != null) {
	            this.autor = new Usuario(datosActualizarTopico.autor());
	        }
	        if (datosActualizarTopico.curso() != null) {
	            this.curso = new Curso(datosActualizarTopico.curso());
	        }
	    }
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((topicoId == null) ? 0 : topicoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topico other = (Topico) obj;
		if (topicoId == null) {
			if (other.topicoId != null)
				return false;
		} else if (!topicoId.equals(other.topicoId))
			return false;
		return true;
	}

	public Long getTopicoId() {
		return topicoId;
	}

	public void setTopicoId(Long id) {
		this.topicoId = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public StatusTopico getEstado() {
		return estado;
	}

	public void setEstado(StatusTopico status) {
		this.estado = status;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Respuesta> getRespuestas() {
		return (List<Respuesta>) respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = (Set<Respuesta>) respuestas;
	}




}
