package com.manoel.livraria.repositories;

import com.manoel.livraria.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro,Long> {
}
