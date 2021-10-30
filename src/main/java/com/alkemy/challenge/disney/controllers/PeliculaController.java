package com.alkemy.challenge.disney.controllers;


import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import com.alkemy.challenge.disney.models.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alkemy.challenge.disney.services.PeliculaService;

@RestController
@RequestMapping("/movies")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> listadoPeliculas(HttpServletRequest request) {
        String name = request.getParameter("name");
        String genre = request.getParameter("genre");
        String order = request.getParameter("order");
        if(name != null){
            return this.peliculaService.findByTitulo(name);
        } else if(genre != null){
            return this.peliculaService.getPeliculaByIdGenero(Long.valueOf(genre));
        } else if (order != null){
            return this.peliculaService.orderBy(order);
        } else{
            return peliculaService.listadoPeliculas();
        }
    }

    @GetMapping("/")
    public List<Pelicula> detallePeliculas(){
        return peliculaService.detallePeliculas();
    }

    @PostMapping()
    public void guardarPelicula(@RequestBody Pelicula pelicula) {
        peliculaService.save(pelicula);
    }

    @GetMapping(path = "/{id}")
    public Pelicula obtenerPeliculaPorId(@PathVariable("id") Long id) {
        return this.peliculaService.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.peliculaService.delete(id);
        if (ok) {
            return "Se eliminó la pelicula con id " + id;
        } else {
            return "No pudo eliminar la pelicula con id" + id;
        }

    }
    

    
}
