
package com.alkemy.challenge.disney.models;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;


@Data
@Entity
@Table(name = "pelicula")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pelicula implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagen;
    
    private String titulo;
    
    private Date fecha_creacion;
    
    private Integer calificacion;
    
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "combinados",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id"))
    private List<Personaje> personajes;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;

    public Pelicula(){
        
    }

    public Pelicula(String titulo, Date fecha) {
        this.titulo = titulo;
        this.fecha_creacion = fecha;
    }

    public Pelicula(String imagen, String titulo, Date fecha_creacion) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.fecha_creacion = fecha_creacion;
    }

    public Pelicula(String imagen, String titulo, Date fecha_creacion, Integer calificacion, List<Personaje> personajes) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.fecha_creacion = fecha_creacion;
        this.calificacion = calificacion;
        this.personajes = personajes;
    }

    public void addPersonaje(Personaje personaje) {
        personajes.add(personaje);
    }

}
