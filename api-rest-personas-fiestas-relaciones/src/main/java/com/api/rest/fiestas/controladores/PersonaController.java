package com.api.rest.fiestas.controladores;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.fiestas.entidades.Fiesta;
import com.api.rest.fiestas.entidades.Persona;
import com.api.rest.fiestas.repositorios.PersonaRepository;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

	@Autowired
	private PersonaRepository personaRepository;
	
	@GetMapping
	public ResponseEntity<Collection<Persona>> listarPersonas(){
		return new ResponseEntity<>(personaRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable long id){
		Persona persona = personaRepository.findById(id).orElseThrow();
		
		if(persona != null) {
			return new ResponseEntity<>(personaRepository.findById(id).orElseThrow(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> guardarPersona(@RequestBody Persona persona){
		return new ResponseEntity<>(personaRepository.save(persona),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarPersona(@PathVariable long id){
		personaRepository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}/fiestas")
	public ResponseEntity<Collection<Fiesta>> listarFiestasDeLaPersona(@PathVariable long id){
		Persona persona = personaRepository.findById(id).orElseThrow();
		
		if(persona != null) {
			return new ResponseEntity<>(persona.getFiestas(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
}