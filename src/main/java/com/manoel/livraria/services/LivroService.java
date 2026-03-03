package com.manoel.livraria.services;

import com.manoel.livraria.dto.LivroDTO;
import com.manoel.livraria.entities.Livro;
import com.manoel.livraria.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Transactional
    public LivroDTO insert(LivroDTO dto){
        Livro livro = new Livro();
        copyDtoToEntity(dto, livro);
        livro = repository.save(livro);
        return new LivroDTO(livro);

    }

    private void copyDtoToEntity(LivroDTO dto, Livro entity) {
        entity.setAutor(dto.getAutor());
        entity.setTitulo(dto.getTitulo());
        entity.setAnoPublicacao(dto.getAnoPublicacao());
        entity.setDataCadastro(Instant.now());
    }

}
