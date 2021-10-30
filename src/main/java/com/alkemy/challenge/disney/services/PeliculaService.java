package com.alkemy.challenge.disney.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.alkemy.challenge.disney.models.Genero;
import com.alkemy.challenge.disney.models.Pelicula;

public interface PeliculaService {
    
    public List<Pelicula> listPeliculas();

    public List<Pelicula> detallePeliculas();

    public Pelicula save(Pelicula pelicula);

    public boolean delete(Long id);
    
    public Optional<Pelicula> obtenerPorId(Long id);

    public List<Pelicula> findByTitulo(String titulo);

    //public List<Pelicula> findByGenero(Long id);

    public List<Pelicula>getPeliculaByIdGenero(Long id);

    public List<Pelicula> orderBy(String order);

}
