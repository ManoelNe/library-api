package com.manoel.livraria.services;

import com.manoel.livraria.dto.LivroDTO;
import com.manoel.livraria.entities.Livro;
import com.manoel.livraria.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

import static org.hibernate.internal.util.collections.CollectionHelper.map;

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

    @Transactional(readOnly = true)
    public LivroDTO findById(Long id) {

        Livro entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        return new LivroDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<LivroDTO> findAll(Pageable pageable) {
         Page<Livro> result = repository.findAll(pageable);
         return result.map(x-> new LivroDTO(x));
    }

    private void copyDtoToEntity(LivroDTO dto, Livro entity) {
        entity.setAutor(dto.getAutor());
        entity.setTitulo(dto.getTitulo());
        entity.setAnoPublicacao(dto.getAnoPublicacao());
        entity.setDataCadastro(Instant.now());
    }

}
