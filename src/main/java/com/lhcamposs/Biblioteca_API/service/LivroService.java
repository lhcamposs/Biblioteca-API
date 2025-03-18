package com.lhcamposs.Biblioteca_API.service;

import com.lhcamposs.Biblioteca_API.entity.Livro;
import com.lhcamposs.Biblioteca_API.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Transactional
    public Livro salvar(Livro livro){

        return livroRepository.save(livro);
    }


    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Livro não encontrado")
        );
    }
}
