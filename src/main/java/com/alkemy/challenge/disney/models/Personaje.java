
package com.alkemy.challenge.disney.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "personaje")
public class Personaje implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    
    private Integer edad;
    
    private Double peso;
    
    private String historia;
    
    @OneToMany(mappedBy = "personaje")
    private List<Nominacion> nominaciones = new ArrayList<>();

    public void addNominacion(Nominacion nominacion) {
        nominaciones.add(nominacion);
        nominacion.setPersonaje(this);
    }

    public void removeNominacion(Nominacion nominacion) {
        nominaciones.remove(nominacion);
        nominacion.setPersonaje(null);
    }
    
}
