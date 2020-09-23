package com.maurelllopes.projeto_maurell.service;

import com.maurelllopes.projeto_maurell.domain.Cliente;
import com.maurelllopes.projeto_maurell.repositories.ClienteRepository;
import com.maurelllopes.projeto_maurell.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));

    }}


