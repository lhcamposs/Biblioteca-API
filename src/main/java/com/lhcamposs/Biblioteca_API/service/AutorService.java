package com.lhcamposs.Biblioteca_API.service;

import com.lhcamposs.Biblioteca_API.entity.Autor;
import com.lhcamposs.Biblioteca_API.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AutorService {
    private final AutorRepository autorRepository;

    @Transactional(readOnly = true)
    public List<Autor> buscarTodos() {
        return autorRepository.findAll();
    }

    @Transactional
    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }

    @Transactional(readOnly = true)
    public Autor buscarPorId(Long id) {
        return autorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Livro não encontrado")
        );
    }

    @Transactional
    public Autor atualizarAutor(Long id, Autor autor) {
        Autor author = buscarPorId(id);
        author.setNome(autor.getNome());
        return author;
    }

    @Transactional
    public void deletar(Long id) {
        autorRepository.deleteById(id);
    }
}
