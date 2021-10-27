
package com.alkemy.challenge.disney.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

@Data
@Entity
@Table(name = "personaje")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Personaje implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    
    private Integer edad;
    
    private Double peso;
    
    private String historia;
    
    @ManyToMany(mappedBy = "personajes")
    private List<Pelicula> peliculas;


    
}
