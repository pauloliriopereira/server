package br.com.imusica.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.imusica.server.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {}