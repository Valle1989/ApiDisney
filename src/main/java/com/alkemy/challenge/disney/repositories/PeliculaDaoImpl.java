package com.alkemy.challenge.disney.repositories;

import com.alkemy.challenge.disney.models.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class PeliculaDaoImpl  {

    @Autowired
    PeliculaDao peliculaDao;

    @PersistenceContext
    private EntityManager em;

    public Pelicula save(Pelicula pelicula){
        return peliculaDao.save(pelicula);
    }

    public Pelicula getPeliculaById(Long id){
        return peliculaDao.findPeliculaById(id);
    }

    public List<Pelicula> listPeliculas() {
        return peliculaDao.findImageTitleAndDate();
    }


    public List<Pelicula> findByTitulo(String titulo) {
        return peliculaDao.findByTitulo(titulo);
    }


    public List<Pelicula>findMovieByIdGenero(Long id) {
        return peliculaDao.findMovieByIdGenero(id);
    }


    public List<Pelicula> orderBy(String order) {
        Query query = em.createQuery("from Pelicula p order by p.fecha_creacion " + order);
        List result = query.getResultList();
        return result;
    }
}
