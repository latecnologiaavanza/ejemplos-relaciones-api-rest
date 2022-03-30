package com.api.rest.instructores.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	private String apellido;

	private String email;

	@OneToOne
	@JoinColumn(name = "instructor_detalle_id")
	private InstructorDetalle instructorDetalle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetalle getInstructorDetalle() {
		return instructorDetalle;
	}

	public void setInstructorDetalle(InstructorDetalle instructorDetalle) {
		this.instructorDetalle = instructorDetalle;
	}

}
