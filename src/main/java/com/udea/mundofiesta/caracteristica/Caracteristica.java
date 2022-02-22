package com.udea.mundofiesta.caracteristica;

import com.udea.mundofiesta.personaje.Personaje;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "caracteristicas")
@Getter
@Setter
@NoArgsConstructor
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", nullable = false)
    private Integer id;

    @Column(name = "car_dimension", nullable = false, length = 20)
    private String dimension;

    @Column(name = "car_color", nullable = false, length = 50)
    private String color;

    @ManyToOne
    @JoinColumn(name = "car_personaje_id")
    private Personaje personaje;

}