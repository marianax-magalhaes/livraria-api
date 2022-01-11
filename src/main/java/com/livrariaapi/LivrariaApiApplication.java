package com.livrariaapi;

import com.livrariaapi.domain.Categoria;
import com.livrariaapi.domain.Livro;
import com.livrariaapi.repository.CategoriaRepository;
import com.livrariaapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class LivrariaApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LivrariaApiApplication.class, args);
    }

    // instanciando o repositório para usa-lo para salvar
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;


    @Override
    public void run(String... args) throws Exception{

        // criando
        Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
        Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "lorem ipsum", cat1);

        // fazendo um "conhecer o outro"
        cat1.getLivros().addAll(Arrays.asList(l1));

        // salvando
        this.categoriaRepository.saveAll(Arrays.asList(cat1));
        this.livroRepository.saveAll(Arrays.asList(l1));
    }
}
