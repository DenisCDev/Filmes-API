package com.br.coldtech.filmes.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4computer.dto.ComputerDTO;
import br.com.tech4me.tech4computer.model.Computer;
import br.com.tech4me.tech4computer.repository.ComputerRepository;

@Service
public class FilmeServiceImpl implements FilmeService {
    
    ModelMapper mapper = new ModelMapper();

    @Autowired
    private FilmeRepository repositorio;

    @Override
    public List<FilmeDTO> obterTodos() {
        List<Computer> pc = repositorio.findAll();
        
        return pc.stream()
        .map(i -> mapper.map(i, ComputerDTO.class))
        .collect(Collectors.toList());
    }

    @Override
    public Optional<ComputerDTO> obterComputadorPeloId(String id) {
        Optional<Computer> pc = repositorio.findById(id);

        if(pc.isPresent()) {
            return Optional.of(mapper.map(pc.get(), ComputerDTO.class));
        }

        return Optional.empty();
    }

    @Override
    public ComputerDTO armazenarComputador(ComputerDTO computador) {
        Computer saveComputador = mapper.map(computador, Computer.class);
        saveComputador = repositorio.save(saveComputador);
        
        return mapper.map(saveComputador, ComputerDTO.class);
    }

    @Override
    public void excluirComputadorPeloId(String id) {
        repositorio.deleteById(id);
        
    }

    @Override
    public ComputerDTO atualizarComputador(String id, ComputerDTO computador) {
        Computer attComputador = mapper.map(computador, Computer.class);
        attComputador.setId(id);
        attComputador = repositorio.save(attComputador);

        return mapper.map(attComputador, ComputerDTO.class);
    }

    @Override
    public List<ComputerDTO> obterPorPreco(String preco) {
        List<Computer> pc = repositorio.findByPreco(preco);
       
        return pc.stream()
        .map(i -> mapper.map(i, ComputerDTO.class))
        .collect(Collectors.toList());
    }
    
}