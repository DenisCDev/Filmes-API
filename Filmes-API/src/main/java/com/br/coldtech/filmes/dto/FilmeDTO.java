package com.br.coldtech.filmes.dto;

import javax.validation.constraints.NotEmpty;

public class FilmeDTO {
    private String id;

    @NotEmpty(message="O campo 'titulo' está vazio, corrija-o")
    private String titulo;
    @NotEmpty(message="O campo 'dataLancamento' está vazio, corrija-o")
    private String dataLancamento;
    @NotEmpty(message="O campo 'sinopse' está vazio, corrija-o")
    private String sinopse;
    @NotEmpty(message="O campo 'diretor' está vazio, corrija-o")
    private String diretor;
    @NotEmpty(message="O campo 'produtor' está vazio, corrija-o")
    private String produtor;
    @NotEmpty(message="O campo 'categoria' está vazio, corrija-o")
    private String categoria;
    @NotEmpty(message="O campo 'classificacao' está vazio, corrija-o")
    private String classificacao;
    @NotEmpty(message="O campo 'idiomas' está vazio, corrija-o")
    private String idiomas;
    @NotEmpty(message="O campo 'nota' está vazio, corrija-o")
    private int nota;
    @NotEmpty(message="O campo 'duracaoMinutos' está vazio, corrija-o")
    private int duracaoMinutos;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDataLancamento() {
        return dataLancamento;
    }
    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    public String getSinopse() {
        return sinopse;
    }
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    public String getDiretor() {
        return diretor;
    }
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    public String getProdutor() {
        return produtor;
    }
    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
    public String getIdiomas() {
        return idiomas;
    }
    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }
    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }
    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }
    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }
}