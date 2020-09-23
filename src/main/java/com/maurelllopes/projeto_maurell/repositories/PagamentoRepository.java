package com.maurelllopes.projeto_maurell.repositories;

import com.maurelllopes.projeto_maurell.domain.Estado;
import com.maurelllopes.projeto_maurell.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
