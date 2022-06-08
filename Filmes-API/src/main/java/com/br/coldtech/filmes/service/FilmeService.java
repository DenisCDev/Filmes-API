package com.br.coldtech.filmes.service;

import java.util.List;
import java.util.Optional;

import com.br.coldtech.filmes.dto.FilmeDTO;

public interface FilmeService {
    
    List<FilmeDTO> obterTodosFilmes();

    Optional<FilmeDTO> obterFilmePorId(String id);

    FilmeDTO cadastrarFilme(FilmeDTO filme);

    void apagarFilmePorId(String id);

    FilmeDTO atualizarInfoFilme(String id, FilmeDTO filme);

    List<FilmeDTO> obterPorNome(String nome);

    List<FilmeDTO> obterPorDiretor(String diretor);

    List<FilmeDTO> obterPorCategoria(String categoria);

    List<FilmeDTO> obterPorClassificacao(String classificacao);
}