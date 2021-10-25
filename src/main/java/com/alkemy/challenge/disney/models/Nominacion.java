
package com.alkemy.challenge.disney.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "nominacion")
public class Nominacion implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nominacion")
    private Integer idNominacion;
    
    //@JoinColumn(name="id_personaje",referencedColumnName = "id")
    @ManyToOne
    private Personaje personaje;
    
    //@JoinColumn(name="id_pelicula",referencedColumnName = "id")
    @ManyToOne
    private Pelicula pelicula;
    
    
    
}
