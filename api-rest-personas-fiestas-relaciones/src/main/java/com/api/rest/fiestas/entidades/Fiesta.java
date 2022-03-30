package com.api.rest.fiestas.entidades;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "fiestas")
public class Fiesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fiesta_id")
	private long id;

	private String ubicacion;

	@Column(name = "fiesta_fecha")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date fecha;

	@ManyToMany
	@JoinTable(name = "personas_fiestas", joinColumns = @JoinColumn(name = "fiesta_id", referencedColumnName = "fiesta_id"), inverseJoinColumns = @JoinColumn(name = "persona_id", referencedColumnName = "persona_id"))
	private Set<Persona> personas = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Set<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}

}
