package com.alkemy.challenge.disney.services;

import com.alkemy.challenge.disney.models.Personaje;
import com.alkemy.challenge.disney.repositories.PersonajeDao;
import com.alkemy.challenge.disney.repositories.PersonajeDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PersonajeServiceImpl implements PersonajeService{

    @Autowired
    private PersonajeDao personajeDao;

    @Autowired
    private PersonajeDaoImpl personajeDaoImpl;


    @Override
    @Transactional(readOnly = true)
    public List<Personaje> detallePersonajes() {
        return (List<Personaje>) personajeDao.findAll();
    }

    @Override
    @Transactional
    public Personaje save(Personaje personaje) {
        return personajeDao.save(personaje);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        try {
            personajeDao.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }


    @Override
    @Transactional(readOnly = true)
    public List<Personaje> obtenerPersonajePorIdPelicula(Long id) {
        return personajeDaoImpl.getPersonajeByIdPelicula(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Personaje> getPersonajeByIdEdad(Integer edad) {
        return personajeDaoImpl.findByEdad(edad);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Personaje> findByNombre(String nombre) {
        return personajeDaoImpl.findByNombre(nombre);
    }
}
