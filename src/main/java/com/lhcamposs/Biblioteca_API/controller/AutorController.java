package com.lhcamposs.Biblioteca_API.controller;

import com.lhcamposs.Biblioteca_API.entity.Autor;
import com.lhcamposs.Biblioteca_API.entity.Livro;
import com.lhcamposs.Biblioteca_API.service.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/autores")
public class AutorController {

    private final AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> getAll(){
        List<Autor> author = autorService.buscarTodos();
        return ResponseEntity.ok(author);
    }

    @PostMapping
    public ResponseEntity<Autor> create(@RequestBody Autor autor){
        Autor author =  autorService.salvar(autor);
        return ResponseEntity.ok(author);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getById(@PathVariable Long id){
        Autor author = autorService.buscarPorId(id);
        return  ResponseEntity.ok(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> update(@PathVariable Long id, @RequestBody Autor autor){
        Autor author = autorService.atualizarAutor(id, autor);
        return  ResponseEntity.ok(author);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        autorService.deletar(id);
        return  ResponseEntity.noContent().build();
    }
}
