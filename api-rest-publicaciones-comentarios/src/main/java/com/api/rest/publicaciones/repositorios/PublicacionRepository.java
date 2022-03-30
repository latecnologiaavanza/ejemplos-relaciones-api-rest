package com.api.rest.publicaciones.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.publicaciones.entidades.Publicacion;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long>{

}
