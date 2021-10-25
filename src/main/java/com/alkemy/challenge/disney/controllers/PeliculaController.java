package com.alkemy.challenge.disney.controllers;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
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
        String fecha = request.getParameter("asc");
        if(name != null){
            return this.peliculaService.findByTitulo(name);
        } else if(genre != null){
            return this.peliculaService.getPeliculaByIdGenero(Long.valueOf(genre));
        } else if (fecha != null){
            return this.peliculaService.orderByAsc(Date.valueOf(fecha));
        } else{
            return peliculaService.listPeliculas();
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
    public Optional<Pelicula> obtenerPeliculaPorId(@PathVariable("id") Long id) {
        return this.peliculaService.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.peliculaService.delete(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }

    }
    
    @GetMapping("/name")
    public List<Pelicula> obtenerPeliculaPorNombre(@RequestParam("nombre") String titulo){
        return this.peliculaService.findByTitulo(titulo);
    }
    
    @GetMapping("/genero")
    public List<Pelicula> obtenerPeliculaPorGenero(@RequestParam("idGenero") Long id){
        return this.peliculaService.getPeliculaByIdGenero(id);
    }
    
    @GetMapping("/order")
    public List<Pelicula> obtenerPeliculasPorOrdenAscendente(@RequestParam("asc") Date fecha){
        return this.peliculaService.orderByAsc(fecha);
    }
    
}
