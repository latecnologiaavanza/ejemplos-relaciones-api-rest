package com.api.rest.instructores.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.instructores.entidades.Instructor;
import com.api.rest.instructores.excepciones.ResourceNotFoundException;
import com.api.rest.instructores.repositorios.InstructorRepository;

@RestController
@RequestMapping("/api/v1")
public class InstructorController {

	@Autowired
	private InstructorRepository instructorRepository;
	
	@GetMapping("/instructores")
	public List<Instructor> listarInstructores(){
		return instructorRepository.findAll();
	}
	
	@GetMapping("/instructores/{id}")
	public ResponseEntity<Instructor> verDetallesDelInstructor(@PathVariable Long id){
		Instructor instructor = instructorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor con el ID : " + id + " no encontrado"));
		return ResponseEntity.ok().body(instructor);
	}
	
	@PostMapping("/instructores")
	public Instructor guardarInstructor(@Valid @RequestBody Instructor instructor) {
		return instructorRepository.save(instructor);
	}
	
	@PutMapping("/instructores/{id}")
	public ResponseEntity<Instructor> actualizarInstructor(@PathVariable Long id,@Valid @RequestBody Instructor instructorDetallles){
		Instructor instructor = instructorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor con el ID : " + id + " no encontrado"));
		
		instructor.setEmail(instructorDetallles.getEmail());
		Instructor instructorActualizado = instructorRepository.save(instructor);
		return ResponseEntity.ok(instructorActualizado);
	}
	
	@DeleteMapping("/instructores/{id}")
	public Map<String, Boolean> eliminarInstructor(@PathVariable Long id){
		Instructor instructor = instructorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor con el ID : " + id + " no encontrado"));
		
		instructorRepository.delete(instructor);
		Map<String,Boolean> respuesta = new HashMap<>();
		respuesta.put("Instructor eliminado", Boolean.TRUE);
		return respuesta;
	}
}
