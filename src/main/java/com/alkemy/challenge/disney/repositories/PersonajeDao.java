
package com.alkemy.challenge.disney.repositories;

import com.alkemy.challenge.disney.models.Pelicula;
import com.alkemy.challenge.disney.models.Personaje;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeDao extends CrudRepository<Personaje, Long> {

    @Query("from Personaje p where p.nombre =:nombre")
    public List<Personaje> findByName(@Param("nombre") String nombre);

    @Query("from Personaje p where p.edad =:edad")
    public List<Personaje> findByAge(@Param("edad") Integer edad);

    @Query("from Personaje p inner join p.peliculas x where x.id =:id")
    public List<Personaje>getCharacterByIdMovie(@Param("id") Long id);
    
}
