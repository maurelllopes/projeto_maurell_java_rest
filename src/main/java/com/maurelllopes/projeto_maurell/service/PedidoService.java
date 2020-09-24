package com.maurelllopes.projeto_maurell.service;

import com.maurelllopes.projeto_maurell.domain.Pedido;
import com.maurelllopes.projeto_maurell.repositories.PedidoRepository;
import com.maurelllopes.projeto_maurell.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido find(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));

    }
}
