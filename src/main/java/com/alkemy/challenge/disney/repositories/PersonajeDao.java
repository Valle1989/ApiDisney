
package com.alkemy.challenge.disney.repositories;

import com.alkemy.challenge.disney.models.Personaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeDao extends CrudRepository<Personaje, Long> {
    
}
