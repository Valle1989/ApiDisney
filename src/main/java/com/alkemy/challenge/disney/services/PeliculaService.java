package com.alkemy.challenge.disney.services;

import java.util.List;

import com.alkemy.challenge.disney.models.Pelicula;

public interface PeliculaService {
    
    public List<Pelicula> listadoPeliculas();

    public List<Pelicula> detallePeliculas();

    public Pelicula save(Pelicula pelicula);

    public boolean delete(Long id);
    
    public Pelicula obtenerPorId(Long id);

    public List<Pelicula> findByTitulo(String titulo);

    public List<Pelicula>getPeliculaByIdGenero(Long id);

    public List<Pelicula> orderBy(String order);

}
