package com.livrariaapi.service;

import com.livrariaapi.domain.Categoria;
import com.livrariaapi.exceptions.ObjectNotFoundException;
import com.livrariaapi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id){
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID " + id + ", tipo " + Categoria.class.getName()));
    }
}












