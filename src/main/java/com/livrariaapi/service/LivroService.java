package com.livrariaapi.service;

import com.livrariaapi.domain.Livro;
import com.livrariaapi.exceptions.ObjectNotFound;
import com.livrariaapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public Livro findById(Integer id){
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(()->new ObjectNotFound("Objeto não encontrado! ID: " +id+ ", tipo: " + Livro.class.getName()));
    }
}
