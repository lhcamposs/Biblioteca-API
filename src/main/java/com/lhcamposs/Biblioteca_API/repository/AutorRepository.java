package com.lhcamposs.Biblioteca_API.repository;

import com.lhcamposs.Biblioteca_API.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
  }