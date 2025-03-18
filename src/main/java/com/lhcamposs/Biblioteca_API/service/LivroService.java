package com.lhcamposs.Biblioteca_API.service;

import com.lhcamposs.Biblioteca_API.entity.Livro;
import com.lhcamposs.Biblioteca_API.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Transactional
    public Livro salvar(Livro livro){

        return livroRepository.save(livro);
    }
}
