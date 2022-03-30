package com.api.rest.fiestas.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "habilidades")
public class Habilidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "habilidad_id")
	private long id;

	private String nombre;

	@Enumerated(EnumType.STRING)
	private Nivel nivel;

	@ManyToOne
	@JoinColumn(name = "persona_id")
	@JsonBackReference
	private Persona persona;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
