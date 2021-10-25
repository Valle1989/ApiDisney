
package com.alkemy.challenge.disney.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pelicula")
public class Pelicula implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    
    private Date fecha;
    
    private Integer calificacion;
    
    @OneToMany(mappedBy = "pelicula")
    private List<Nominacion> nominaciones = new ArrayList<>();
    
    public Pelicula(){
        
    }

    public Pelicula(String titulo, Date fecha) {
        this.titulo = titulo;
        this.fecha = fecha;
    }

    public void addNominacion(Nominacion nominacion) {
        nominaciones.add(nominacion);
        nominacion.setPelicula(this);
    }

    public void removeNominacion(Nominacion nominacion) {
        nominaciones.remove(nominacion);
        nominacion.setPelicula(null);
    }
    
}
