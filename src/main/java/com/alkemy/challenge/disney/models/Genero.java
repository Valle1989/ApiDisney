
package com.alkemy.challenge.disney.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@Entity
@Table(name = "genero")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Genero implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;

    private String imagen;

    @OneToMany(mappedBy = "genero")
    private List<Pelicula> peliculas;

    public Genero() {
    }

    public Genero(String nombre, String imagen, List<Pelicula> peliculas) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.peliculas = peliculas;
    }
}
