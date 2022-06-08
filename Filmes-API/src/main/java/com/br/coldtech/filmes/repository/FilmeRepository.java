package com.br.coldtech.filmes.repository;

import com.br.coldtech.filmes.model.Filme;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmeRepository extends MongoRepository<Filme, String>{
}
