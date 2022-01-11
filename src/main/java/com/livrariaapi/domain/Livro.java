package com.livrariaapi.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(of="id")
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String nome_autor;
    private String texto;

    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;
}
