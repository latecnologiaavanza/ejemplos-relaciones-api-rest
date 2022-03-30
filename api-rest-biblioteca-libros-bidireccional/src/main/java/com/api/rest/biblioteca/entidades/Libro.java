package com.api.rest.biblioteca.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "libros",uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	private String nombre;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "biblioteca_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Biblioteca biblioteca;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

}
