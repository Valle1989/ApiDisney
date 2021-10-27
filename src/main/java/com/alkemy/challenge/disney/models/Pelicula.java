
package com.alkemy.challenge.disney.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

@Data
@Entity
@Table(name = "pelicula")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Pelicula implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    
    private Date fecha_creacion;
    
    private Integer calificacion;
    
    @ManyToMany
    @JoinTable(
            name = "combinados",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id"))
    private List<Personaje> personajes;
    
    public Pelicula(){
        
    }

    public Pelicula(String titulo, Date fecha) {
        this.titulo = titulo;
        this.fecha_creacion = fecha;
    }

    
}
