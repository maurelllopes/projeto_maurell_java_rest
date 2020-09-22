package com.maurelllopes.projeto_maurell.service;

import com.maurelllopes.projeto_maurell.domain.Categoria;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maurelllopes.projeto_maurell.repositories.CategoriaRepository;
import java.util.Optional;
import java.io.IOException;

@Service
public class CategoriaService {

@Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElse(null);

    }
}
