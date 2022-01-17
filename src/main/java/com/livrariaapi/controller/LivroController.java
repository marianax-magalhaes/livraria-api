package com.livrariaapi.controller;

import com.livrariaapi.domain.Livro;
import com.livrariaapi.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id){
        Livro obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
