package com.alkemy.challenge.disney.repositories;

import com.alkemy.challenge.disney.models.Genero;
import com.alkemy.challenge.disney.models.Pelicula;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

public class PeliculaDaoImpl {

    @PersistenceContext
    private EntityManager em;

    public List<Pelicula> listPeliculas() {
        Query query = em.createQuery("Select p.titulo, p.fecha_creacion from Pelicula p");
        return (List<Pelicula>) query.getResultList();
    }

    public List<Pelicula> findByTitulo(String titulo) {
        Query query = em.createQuery("from Pelicula p where p.titulo =:titulo");
        query.setParameter("titulo", titulo);
        return query.getResultList();
    }

    public List<Pelicula> findByGenero(Long id) {
        //Query query = em.createQuery("from Pelicula p, Genero g where p.id_genero = :g.id");
        Query query = em.createQuery("from Genero g inner join Pelicula p ON p.id_genero = g.id where p.id_genero = " + id);
        //query.setParameter("g.id", id);
        return query.getResultList();
    }


    public List<Genero>getPeliculaByIdGenero(Long id) {
        Query query = em.createQuery("from Genero g inner join g.peliculas p where p.id =:id");
        query.setParameter("id", id);
        return (List<Genero>) query.getResultList();
    }


    public List<Pelicula> orderBy(String order) {
        Query query = em.createQuery("from Pelicula p order by p.fecha_creacion " + order);
        List result = query.getResultList();
        return result;
    }
}
