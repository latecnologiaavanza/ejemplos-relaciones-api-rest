package com.api.rest.biblioteca.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "biblioteca")
public class Biblioteca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	private String nombre;

	@OneToMany(mappedBy = "biblioteca", cascade = CascadeType.ALL)
	private Set<Libro> libros = new HashSet<>();

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

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
		for(Libro libro : libros) {
			libro.setBiblioteca(this);
		}
	}

}
