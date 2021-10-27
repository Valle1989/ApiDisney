package com.alkemy.challenge.disney.repositories;

import com.alkemy.challenge.disney.models.Pelicula;
import com.alkemy.challenge.disney.models.Personaje;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class PersonajeDaoImpl {

    @PersistenceContext
    private EntityManager em;


    public List<Personaje> findByNombre(String nombre) {
        Query query = em.createQuery("from Personaje p where p.nombre =:nombre");
        query.setParameter("nombre", nombre);
        return query.getResultList();
    }

    public List<Personaje> findByEdad(Integer edad) {
        Query query = em.createQuery("from Personaje p where p.edad =:edad");
        query.setParameter("edad", edad);
        return query.getResultList();
    }


    public List<Personaje>getPersonajeByPelicula(Long id) {
        Query query = em.createQuery("from Personaje p inner join p.peliculas  where p.id =:id");
        query.setParameter("id", id);
        return (List<Personaje>) query.getResultList();
    }


}
