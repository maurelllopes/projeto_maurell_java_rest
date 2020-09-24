package com.maurelllopes.projeto_maurell.service;

import com.maurelllopes.projeto_maurell.domain.Categoria;
import com.maurelllopes.projeto_maurell.service.exception.DataIntegrityService;
import com.maurelllopes.projeto_maurell.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.maurelllopes.projeto_maurell.repositories.CategoriaRepository;
import java.util.Optional;
import java.io.IOException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update(Categoria obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityService("Não é possível excluir categorias com produtos");

        }
    }
}
