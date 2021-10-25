
package com.alkemy.challenge.disney.services;

import java.util.List;
import com.alkemy.challenge.disney.models.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alkemy.challenge.disney.repositories.PersonajeDao;

@Service
public class PersonajeService {
    
    @Autowired
    private PersonajeDao personajeDao;
    
    public List<Personaje> obtenerPersonajes(){
        return (List<Personaje>) personajeDao.findAll();
    }
    
}
