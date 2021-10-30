
package com.alkemy.challenge.disney.repositories;

import com.alkemy.challenge.disney.models.Genero;
import com.alkemy.challenge.disney.models.Pelicula;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaDao extends CrudRepository<Pelicula, Long> {

        @Query("SELECT  new Pelicula(p.imagen, p.titulo, p.fecha_creacion) FROM Pelicula p")
        public List<Pelicula> findImageTitleAndDate();

        @Query("from Pelicula p where p.titulo =:titulo")
        public List<Pelicula> findByTitulo(@Param("titulo") String titulo);

        //@Query("from Pelicula p order by p.fecha_creacion ")
        //public List<Pelicula> orderBy(@Param("order") String order);

        //@Query("from Genero g inner join g.peliculas p where p.id =:id")
        //public List<Genero> getPeliculaByIdGenero(@Param("id") Long id);

}
