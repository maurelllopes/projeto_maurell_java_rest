package com.maurelllopes.projeto_maurell.repositories;

import com.maurelllopes.projeto_maurell.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
