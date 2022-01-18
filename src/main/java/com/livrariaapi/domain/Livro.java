package com.livrariaapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(of="id")
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message="Campo TITULO é obrigatório")
    @Length(min=3,max=50, message="Campo TITULO deve ter entre 3 e 50 caracteres")
    private String titulo;

    @NotEmpty(message="Campo NOME DO AUTOR é obrigatório")
    @Length(min=3,max=50, message="Campo NOME DO AUTO deve ter entre 3 e 50 caracteres")
    private String nome_autor;

    @NotEmpty(message="Campo TEXTO é obrigatório")
    @Length(min=10,max=2000000, message="Campo TEXTO deve ter entre 10 e 2.000.000 caracteres")
    private String texto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    public Livro() {
    }

    public Livro(Integer id, String titulo, String nome_autor, String texto, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.nome_autor = nome_autor;
        this.texto = texto;
        this.categoria = categoria;
    }
}
