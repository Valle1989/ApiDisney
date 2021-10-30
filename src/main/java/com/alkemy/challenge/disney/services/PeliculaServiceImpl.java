package com.alkemy.challenge.disney.services;

import java.util.List;

import com.alkemy.challenge.disney.models.Pelicula;
import com.alkemy.challenge.disney.repositories.PeliculaDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alkemy.challenge.disney.repositories.PeliculaDao;

@Service
public class PeliculaServiceImpl implements PeliculaService {



    @Autowired
    private PeliculaDao peliculaDao;

    @Autowired
    private PeliculaDaoImpl peliculaDaoImpl;


    @Override
    public List<Pelicula> listadoPeliculas() {
        return peliculaDaoImpl.listPeliculas();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pelicula> detallePeliculas() {
        return (List<Pelicula>) peliculaDao.findAll();
    }

    @Override
    @Transactional
    public Pelicula save(Pelicula pelicula) {
        return peliculaDaoImpl.save(pelicula);

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
    public Pelicula obtenerPorId(Long id) {
        return peliculaDaoImpl.getPeliculaById(id);
    }

    @Override
    public List<Pelicula> findByTitulo(String titulo) {
        return peliculaDaoImpl.findByTitulo(titulo);
    }


    @Override
    public List<Pelicula> getPeliculaByIdGenero(Long id) {
        return peliculaDaoImpl.findMovieByIdGenero(id);
    }

    @Override
    public List<Pelicula> orderBy(String order) {
        return peliculaDaoImpl.orderBy(order);
    }


}
