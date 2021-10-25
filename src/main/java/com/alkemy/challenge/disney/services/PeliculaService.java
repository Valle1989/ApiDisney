package com.alkemy.challenge.disney.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import com.alkemy.challenge.disney.models.Pelicula;

public interface PeliculaService {
    
    public List<Pelicula> listPeliculas();

    public List<Pelicula> detallePeliculas();

    public Pelicula save(Pelicula pelicula);

    public boolean delete(Long id);
    
    public Optional<Pelicula> obtenerPorId(Long id);

    public Pelicula getPeliculaById(Pelicula pelicula);
    
    public List<Pelicula> findByTitulo(String titulo);
    
    public List<Pelicula> getPeliculaByIdGenero(Long id);
    
    public List<Pelicula> findByGenero( String genero);
    
    public List<Pelicula> orderByAsc(Date fecha);
    

}
