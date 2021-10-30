package com.alkemy.challenge.disney.repositories;

import com.alkemy.challenge.disney.models.Genero;
import com.alkemy.challenge.disney.models.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

public class PeliculaDaoImpl {

    @Autowired
    PeliculaDao peliculaDao;

    @PersistenceContext
    private EntityManager em;

    public List<Pelicula> listPeliculas() {
        //Query query = em.createQuery("Select p.titulo, p.fecha_creacion from Pelicula p");
        //return (List<Pelicula>) query.getResultList();
        return peliculaDao.findImageTitleAndDate();
    }

    public List<Pelicula> findByTitulo(String titulo) {
        //Query query = em.createQuery("from Pelicula p where p.titulo =:titulo");
        //query.setParameter("titulo", titulo);
        return peliculaDao.findByTitulo(titulo);
    }

    public List<Pelicula> findByGenero(Long id) {
        //Query query = em.createQuery("from Pelicula p, Genero g where p.id_genero = :g.id");
        Query query = em.createQuery("from Genero g inner join Pelicula p ON p.id_genero = g.id where p.id_genero = " + id);
        //query.setParameter("g.id", id);
        return query.getResultList();
    }


    public List<Pelicula>getPeliculaByIdGenero(Long id) {
        Query query = em.createQuery("from Pelicula p where p.genero.id =:id");
        query.setParameter("id", id);
        return (List<Pelicula>) query.getResultList();
    }


    public List<Pelicula> orderBy(String order) {
        Query query = em.createQuery("from Pelicula p order by p.fecha_creacion " + order);
        List result = query.getResultList();
        return result;
    }
}
