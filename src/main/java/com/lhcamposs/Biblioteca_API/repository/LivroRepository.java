package com.lhcamposs.Biblioteca_API.repository;

import com.lhcamposs.Biblioteca_API.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}