package com.udea.mundofiesta.galeria;


import com.udea.mundofiesta.categoria.Categoria;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "imagenes")
@Setter
@Getter
@NoArgsConstructor
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "img_id")
    private Integer id;

    @Column(name = "img_nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "img_url", nullable = false)
    private String imagenUrl;

    @Column(name = "img_cloud_id", nullable = false)
    private String cloudId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    public Imagen(String nombre, String imagenUrl, String cloudId, Categoria categoria) {
        this.nombre = nombre;
        this.imagenUrl = imagenUrl;
        this.cloudId = cloudId;
        this.categoria = categoria;
    }
}
