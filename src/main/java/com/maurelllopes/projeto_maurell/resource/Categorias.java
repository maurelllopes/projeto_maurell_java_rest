package com.maurelllopes.projeto_maurell.resource;

import com.maurelllopes.projeto_maurell.domain.Categoria;
import com.maurelllopes.projeto_maurell.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/categorias")
public class Categorias {

    @Autowired
    private CategoriaService service;
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){
        Categoria obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }


    }

