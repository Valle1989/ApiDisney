
package com.alkemy.challenge.disney.controllers;

import com.alkemy.challenge.disney.models.Personaje;
import com.alkemy.challenge.disney.repositories.PersonajeDao;
import com.alkemy.challenge.disney.services.PeliculaService;
import com.alkemy.challenge.disney.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/characters")
public class PersonajeController {


    @Autowired
    private PersonajeService personajeService;


    @GetMapping
    public List<Personaje> listadoPersonajes(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String movies = request.getParameter("movies");
        if(name != null){
            return this.personajeService.findByNombre(name);
        } else if(age != null) {
            return this.personajeService.getPersonajeByIdEdad(Integer.valueOf(age));
        } else if(movies != null){
            return this.personajeService.obtenerPersonajePorIdPelicula(Long.valueOf(movies));
        } else{
            return personajeService.detallePersonajes();
        }
    }

    @PostMapping()
    public void guardarPersonaje(@RequestBody Personaje personaje) {
        personajeService.save(personaje);
    }

    @GetMapping(path = "/{id}")
    public Optional<Personaje> obtenerPersonajePorIdMovie(@PathVariable("id") Long id) {
        return this.personajeService.obtenerPorIdMovie(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.personajeService.delete(id);
        if (ok) {
            return "Se eliminó el personaje con id " + id;
        } else {
            return "No pudo eliminar el personaje con id" + id;
        }

    }

}
