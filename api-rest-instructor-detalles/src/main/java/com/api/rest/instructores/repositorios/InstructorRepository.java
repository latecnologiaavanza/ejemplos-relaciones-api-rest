package com.api.rest.instructores.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.instructores.entidades.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Long>{

}
