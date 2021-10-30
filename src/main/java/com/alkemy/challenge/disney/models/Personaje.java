
package com.alkemy.challenge.disney.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;


@Data
@Entity
@Table(name = "personaje")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Personaje implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagen;
    
    private String nombre;
    
    private Integer edad;
    
    private Double peso;
    
    private String historia;
    
    @ManyToMany(mappedBy = "personajes", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<Pelicula> peliculas;

    public void addPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public Personaje() {
    }

    public Personaje(String imagen, String nombre, Integer edad, Double peso, String historia, List<Pelicula> peliculas) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.peliculas = peliculas;
    }
}
