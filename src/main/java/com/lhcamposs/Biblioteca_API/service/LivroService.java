package com.lhcamposs.Biblioteca_API.service;

import com.lhcamposs.Biblioteca_API.entity.Livro;
import com.lhcamposs.Biblioteca_API.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Transactional(readOnly = true)
    public List<Livro> buscarTodos() {
        return livroRepository.findAll();
    }

    @Transactional
    public Livro salvar(Livro livro){
        return livroRepository.save(livro);
    }

    @Transactional(readOnly = true)
    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Livro não encontrado")
        );
    }

    @Transactional
    public Livro atualizarLivro(Long id, Livro livro) {
        Livro book = buscarPorId(id);
        book.setTitulo(livro.getTitulo());
        book.setAnoPub(livro.getAnoPub());
        book.setIsbn(livro.getIsbn());
        return book;
    }


    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }
}
