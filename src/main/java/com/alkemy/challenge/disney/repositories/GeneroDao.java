
package com.alkemy.challenge.disney.repositories;

import com.alkemy.challenge.disney.models.Genero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroDao extends CrudRepository<Genero, Long> {
    
}
