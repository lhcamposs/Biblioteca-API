package com.lhcamposs.Biblioteca_API.controller;

import com.lhcamposs.Biblioteca_API.entity.Livro;
import com.lhcamposs.Biblioteca_API.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/livros")
public class LivroController {

    private final LivroService livroService;

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
}
