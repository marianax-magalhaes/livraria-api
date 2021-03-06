package com.livrariaapi.service;

import com.livrariaapi.domain.Categoria;
import com.livrariaapi.domain.Livro;
import com.livrariaapi.exceptions.ObjectNotFound;
import com.livrariaapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id){
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(()->new ObjectNotFound("Objeto não encontrado! ID: " +id+ ", tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll(Integer id_cat) {
        categoriaService.findById(id_cat);
        return repository.findAllByCategoria(id_cat);
    }

    public Livro update(Integer id, Livro obj) {
       //buscando livro existente
        Livro newObj = findById(id);
       // atualizando o livro trazido
       updateData(newObj, obj) ;
       return repository.save(newObj);
    }

    private void updateData(Livro newObj, Livro obj) {
        newObj.setTitulo(obj.getTitulo());
        newObj.setNome_autor(obj.getNome_autor());
        newObj.setTexto(obj.getTexto());
    }

//    para p patch
    private void updateData1(Livro newObj, Livro obj) {
        if(newObj.getTitulo()==null)newObj.setTitulo(obj.getTitulo());
        if(newObj.getNome_autor()==null)newObj.setNome_autor(obj.getNome_autor());
        if(newObj.getTexto()==null)newObj.setTexto(obj.getTexto());
    }

    public Livro create(Integer id_cat, Livro obj) {
        obj.setId(null);
        //verificando se a categoria existe
        Categoria cat = categoriaService.findById(id_cat);
        //obj Livro conhecendo sua categoria
        obj.setCategoria(cat);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        //verificando se o id existe
        Livro obj = findById(id);
        // apagando
        repository.delete(obj);
    }
}
















