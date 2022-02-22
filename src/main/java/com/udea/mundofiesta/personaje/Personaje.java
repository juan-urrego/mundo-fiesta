package com.udea.mundofiesta.personaje;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "personajes")
@Getter
@Setter
@NoArgsConstructor
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id", nullable = false)
    private Integer id;

    @Column(name = "per_nombre", nullable = false)
    private String nombre;

}