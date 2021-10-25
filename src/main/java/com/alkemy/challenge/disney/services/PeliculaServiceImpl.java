package com.alkemy.challenge.disney.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.alkemy.challenge.disney.models.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alkemy.challenge.disney.repositories.PeliculaDao;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private PeliculaDao peliculaDao;

    @Override
    public List<Pelicula> listPeliculas() {
        Query query = em.createQuery("Select p.titulo from pelicula p");
        return (List<Pelicula>) query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pelicula> detallePeliculas() {
        return (List<Pelicula>) peliculaDao.findAll();
    }

    @Override
    @Transactional
    public Pelicula save(Pelicula pelicula) {
        return peliculaDao.save(pelicula);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        try {
            peliculaDao.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Pelicula getPeliculaById(Pelicula pelicula) {
        return peliculaDao.findById(pelicula.getId()).orElse(null);
    }

    public Optional<Pelicula> obtenerPorId(Long id) {
        return peliculaDao.findById(id);
    }

    public List<Pelicula> findByTitulo(String titulo) {
        Query query = em.createQuery("Select from pelicula p where p.titulo =:titulo");
        query.setParameter("titulo", titulo);
        return query.getResultList();
    }

    public List<Pelicula> findByGenero(String genero) {
        Query query = em.createQuery("Select from pelicula p inner join p.genero g where g.genero =:genero");
        query.setParameter("genero", genero);
        return query.getResultList();
    }

    @Override
    public List<Pelicula>getPeliculaByIdGenero(Long id) {
        Query query = em.createQuery("Select from pelicula p inner join p.genero g where g.id_genero =:id");
        query.setParameter("id", id);
        return (List<Pelicula>) query.getResultList();
    }

    @Override
    public List<Pelicula> orderByAsc(Date fecha) {
        Query query = em.createQuery("FROM pelicula p where p.fecha_creacion order by =:asc");
        query.setParameter("asc", fecha);
        List result = query.getResultList();
        return result;
    }

}
