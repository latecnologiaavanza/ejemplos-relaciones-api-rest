package com.api.rest.fiestas.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "personas")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "persona_id")
	private long id;

	private String nombre;

	private int edad;

	@OneToMany(mappedBy = "persona",cascade = CascadeType.ALL)
	private Set<Habilidad> habilidades = new HashSet<>();

	@ManyToMany
	@JsonBackReference
	@JoinTable(name = "personas_fiestas", joinColumns = @JoinColumn(name = "persona_id", referencedColumnName = "persona_id"), inverseJoinColumns = @JoinColumn(name = "fiesta_id", referencedColumnName = "fiesta_id"))
	private Set<Fiesta> fiestas = new HashSet<>();

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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Set<Habilidad> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(Set<Habilidad> habilidades) {
		this.habilidades = habilidades;
	}

	public Set<Fiesta> getFiestas() {
		return fiestas;
	}

	public void setFiestas(Set<Fiesta> fiestas) {
		this.fiestas = fiestas;
	}

	public Persona() {
		super();
	}

}
