package com.alkemy.challenge.disney.repositories;


import com.alkemy.challenge.disney.models.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class PersonajeDaoImpl {

    @Autowired
    private PersonajeDao personajeDao;


    public List<Personaje> findByNombre(String nombre) {
        return personajeDao.findByName(nombre);
    }

    public List<Personaje> findByEdad(Integer edad) {
        return personajeDao.findByAge(edad);
    }


    public List<Personaje>getPersonajeByIdPelicula(Long id) {
        return personajeDao.getCharacterByIdMovie(id);
    }


}
