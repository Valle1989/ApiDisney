package com.alkemy.challenge.disney.services;

import com.alkemy.challenge.disney.models.Personaje;
import com.alkemy.challenge.disney.repositories.PersonajeDao;
import com.alkemy.challenge.disney.repositories.PersonajeDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeServiceImpl implements PersonajeService{

    @Autowired
    private PersonajeDao personajeDao;

    @Autowired
    private PersonajeDaoImpl personajeDaoImpl;


    @Override
    public List<Personaje> detallePersonajes() {
        return (List<Personaje>) personajeDao.findAll();
    }

    @Override
    public Personaje save(Personaje personaje) {
        return personajeDao.save(personaje);
    }

    @Override
    public boolean delete(Long id) {
        try {
            personajeDao.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    @Override
    public Optional<Personaje> obtenerPorIdMovie(Long id) {
        return personajeDao.findById(id);
    }

    @Override
    public List<Personaje> obtenerPersonajePorIdPelicula(Long id) {
        return personajeDaoImpl.getPersonajeByPelicula(id);
    }

    @Override
    public List<Personaje> getPersonajeByIdEdad(Integer edad) {
        return personajeDaoImpl.findByEdad(edad);
    }

    @Override
    public List<Personaje> findByNombre(String nombre) {
        return personajeDaoImpl.findByNombre(nombre);
    }
}
