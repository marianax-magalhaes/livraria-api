package com.livrariaapi.controller;

import com.livrariaapi.domain.Categoria;
import com.livrariaapi.dtos.CategoriaDto;
import com.livrariaapi.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping(value="/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id){
        Categoria obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll(){
    List<Categoria> list = service.findAll();
    List<CategoriaDto> listDto = list.stream().map(obj-> new CategoriaDto(obj)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}































