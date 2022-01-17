package com.livrariaapi.service;

import com.livrariaapi.domain.Categoria;
import com.livrariaapi.dtos.CategoriaDto;
import com.livrariaapi.exceptions.ObjectNotFound;
import com.livrariaapi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id){

        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() ->
                new ObjectNotFound("Objeto não encontrado! ID " + id + ", tipo " + Categoria.class.getName())
        );
    }

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Categoria create(Categoria obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Integer id, CategoriaDto objDto) {
        Categoria obj = findById(id);

        obj.setNome(objDto.getNome());
        obj.setDescricao(objDto.getDescricao());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}












