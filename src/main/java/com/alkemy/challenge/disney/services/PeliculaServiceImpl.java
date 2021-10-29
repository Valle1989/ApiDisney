package com.alkemy.challenge.disney.services;

import java.util.List;
import java.util.Optional;

import com.alkemy.challenge.disney.models.Genero;
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
    public List<Pelicula> listPeliculas() {
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
        System.out.println(pelicula);
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

    @Transactional(readOnly = true)
    public Pelicula getPeliculaById(Pelicula pelicula) {
        return peliculaDao.findById(pelicula.getId()).orElse(null);
    }

    public Optional<Pelicula> obtenerPorId(Long id) {
        return peliculaDao.findById(id);
    }

    @Override
    public List<Pelicula> findByTitulo(String titulo) {
        return peliculaDaoImpl.findByTitulo(titulo);
    }

    //@Override
    //public List<Pelicula> findByGenero(Long id) {
        //return peliculaDaoImpl.findByGenero(id);
    //}

    @Override
    public List<Genero> getPeliculaByIdGenero(Long id) {
        return peliculaDaoImpl.getPeliculaByIdGenero(id);
    }

    @Override
    public List<Pelicula> orderBy(String order) {
        return peliculaDaoImpl.orderBy(order);
    }


}
