package com.livrariaapi.service;

import com.livrariaapi.domain.Categoria;
import com.livrariaapi.domain.Livro;
import com.livrariaapi.repository.CategoriaRepository;
import com.livrariaapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DbService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void instanciaDb(){
        Categoria cat1 = new Categoria(null,"Informática", "Livros de TI");
        Categoria cat2 = new Categoria(null,"Mistério", "Livros Ficção");
        Categoria cat3 = new Categoria(null,"Documentários", "Livros baseados em histórias reais");

        Livro l1 = new Livro(null, "Clean Code", "R.Martin", "lorem ipsum", cat1);
        Livro l2 = new Livro(null, "Sherlock Holmes", "Arthur Conan Doyle", "lorem ipsum", cat2);
        Livro l3 = new Livro(null, "Arsene Lupin", "Maurice LeBlanc", "lorem ipsum", cat2);
        Livro l4 = new Livro(null, "Carandiru", "Drauzio Varela", "lorem ipsum", cat3);
        Livro l5 = new Livro(null, "Java para Dummies", "Barry Burd", "lorem ipsum", cat3);

        cat1.getLivros().addAll(Arrays.asList(l1, l5));
        cat2.getLivros().addAll(Arrays.asList(l2, l3));
        cat3.getLivros().addAll(Arrays.asList(l4));

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
    }
}

