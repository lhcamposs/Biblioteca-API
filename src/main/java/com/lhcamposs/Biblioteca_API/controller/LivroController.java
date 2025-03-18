package com.lhcamposs.Biblioteca_API.controller;

import com.lhcamposs.Biblioteca_API.entity.Livro;
import com.lhcamposs.Biblioteca_API.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/livros")
public class LivroController {

    private final LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> getAll() {
        List<Livro> books = livroService.buscarTodos();
        return ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro livro) {
        Livro book = livroService.salvar(livro);
        return  ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getById(@PathVariable Long id){
        Livro book = livroService.buscarPorId(id);
        return  ResponseEntity.ok(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livro){
        Livro book = livroService.atualizarLivro(id, livro);
        return  ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        livroService.deletar(id);
        return  ResponseEntity.noContent().build();
    }
}
