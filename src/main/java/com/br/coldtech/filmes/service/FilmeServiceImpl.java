package com.br.coldtech.filmes.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.coldtech.filmes.dto.FilmeDTO;
import com.br.coldtech.filmes.model.Filme;
import com.br.coldtech.filmes.repository.FilmeRepository;

@Service
public class FilmeServiceImpl implements FilmeService {
    
    ModelMapper mapper = new ModelMapper();

    @Autowired
    private FilmeRepository repositorio;

    @Override
    public List<FilmeDTO> obterTodosFilmes() {
        List<Filme> movie = repositorio.findAll();
        
        return movie.stream()
        .map(i -> mapper.map(i, FilmeDTO.class))
        .collect(Collectors.toList());
    }

    @Override
    public Optional<FilmeDTO> obterFilmePorId(String id) {
        Optional<Filme> movie = repositorio.findById(id);

        if(movie.isPresent()) {
            return Optional.of(mapper.map(movie.get(), FilmeDTO.class));
        }

        return Optional.empty();
    }

    @Override
    public FilmeDTO cadastrarFilme(FilmeDTO filme) {
        Filme salvarFilme = mapper.map(filme, Filme.class);
        salvarFilme = repositorio.save(salvarFilme);
        
        return mapper.map(salvarFilme, FilmeDTO.class);
    }

    @Override
    public void apagarFilmePorId(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public FilmeDTO atualizarInfoFilme(String id, FilmeDTO filme) {
        Filme atualizarFilme = mapper.map(filme, Filme.class);
        atualizarFilme.setId(id);
        atualizarFilme = repositorio.save(atualizarFilme);

        return mapper.map(atualizarFilme, FilmeDTO.class);
    }
    @Override
    public List<FilmeDTO> obterPorNome(String nome) {
        List<Filme> movie = repositorio.findByNome(nome);
       
        return movie.stream()
        .map(i -> mapper.map(i, FilmeDTO.class))
        .collect(Collectors.toList());
    }

    @Override
    public List<FilmeDTO> obterPorDiretor(String diretor) {
        List<Filme> movie = repositorio.findByDiretor(diretor);
       
        return movie.stream()
        .map(i -> mapper.map(i, FilmeDTO.class))
        .collect(Collectors.toList());
    }

    @Override
    public List<FilmeDTO> obterPorCategoria(String categoria) {
        List<Filme> movie = repositorio.findByCategoria(categoria);
       
        return movie.stream()
        .map(i -> mapper.map(i, FilmeDTO.class))
        .collect(Collectors.toList());
    }
    
    @Override
    public List<FilmeDTO> obterPorClassificacao(String classificacao) {
        List<Filme> movie = repositorio.findByClassificacao(classicacao);
       
        return movie.stream()
        .map(i -> mapper.map(i, FilmeDTO.class))
        .collect(Collectors.toList());
    }
}