package br.com.tech4me.coldtech.model;

import org.springframework.data.annotation.Id;

@Document("filmes")
public class Filme {

    @Id
    private String id;
    private String titulo;
    private String dataLancamento;
    private String sinopse;
    private String diretor;
    private String produtor;
    private String categoria;
    private String classificacao;
    private String idiomas;
    private int nota;
    private int duracaoMinutos;

    //Criar getters e setters
}