
package com.alkemy.challenge.disney.services;

import java.util.List;
import java.util.Optional;

import com.alkemy.challenge.disney.models.Personaje;


public interface PersonajeService {


    public List<Personaje> detallePersonajes();

    public Personaje save(Personaje personaje);

    public boolean delete(Long id);

    public Optional<Personaje> obtenerPorIdMovie(Long id);

    public List<Personaje> obtenerPersonajePorIdPelicula(Long id);

    public List<Personaje>getPersonajeByIdEdad(Integer edad);

    public List<Personaje> findByNombre(String nombre);
    
}
