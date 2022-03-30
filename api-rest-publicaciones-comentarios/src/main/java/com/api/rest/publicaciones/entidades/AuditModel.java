package com.api.rest.publicaciones.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
		value = {"fechaCreacion","fechaActualizacion"},
		allowGetters = true
		)
public abstract class AuditModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion", nullable = false, updatable = false)
	@CreatedDate
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_actualizacion", nullable = false)
	@LastModifiedDate
	private Date fechaActualizacion;

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

}
