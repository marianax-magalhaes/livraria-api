package com.livrariaapi.dtos;

import com.livrariaapi.domain.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class LivroDto implements Serializable {

    private Integer id;
    private String titulo;

    public LivroDto(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }
}
