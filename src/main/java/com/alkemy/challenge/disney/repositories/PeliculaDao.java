
package com.alkemy.challenge.disney.repositories;

import com.alkemy.challenge.disney.models.Pelicula;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaDao extends CrudRepository<Pelicula, Long> {
    
    
}
