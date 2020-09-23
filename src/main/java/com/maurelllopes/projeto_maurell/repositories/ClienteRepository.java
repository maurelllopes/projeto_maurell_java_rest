package com.maurelllopes.projeto_maurell.repositories;

import com.maurelllopes.projeto_maurell.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
