package com.maurelllopes.projeto_maurell.repositories;

import com.maurelllopes.projeto_maurell.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
