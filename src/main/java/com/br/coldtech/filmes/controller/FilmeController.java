package com.br.coldtech.filmes.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.coldtech.filmes.dto.FilmeDTO;
import com.br.coldtech.filmes.response.FilmeResponseIdDTO;
import com.br.coldtech.filmes.service.FilmeService;
import com.br.coldtech.filmes.response.FilmeRespondeDTO;

@RestController
@RequestMapping("/api/filmes")
public class FilmeController {
    
    ModelMapper mapper = new ModelMapper();

    @Autowired
    private FilmeService service;
    
    @GetMapping
    public ResponseEntity<List<FilmeDTO>> obterFilmes() {
       return new ResponseEntity<>(service.obterTodosFilmes(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FilmeDTO> cadastrarFilme(@RequestBody @Valid FilmeDTO filme) {
        return new ResponseEntity<>(service.cadastrarFilme(filme), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFilmePorId(@PathVariable String id) {
        service.apagarFilmePorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmeDTO> atualizarInfoFilme(@PathVariable String id, @RequestBody @Valid FilmeDTO filme) {
        return new ResponseEntity<>(service.atualizarInfoFilme(id, filme), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeResponseIdDTO> obterFilmePorId(@PathVariable String id){
       Optional<FilmeDTO> pc = service.obterFilmePorId(id);

       if (movie.isPresent()) {
        return new ResponseEntity<>(mapper.map(movie.get(), FilmeResponseIdDTO.class), 
          HttpStatus.FOUND);
       }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}