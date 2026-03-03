package com.manoel.livraria.controllers;

import com.manoel.livraria.dto.LivroDTO;
import com.manoel.livraria.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroControllers {

    @Autowired
    private LivroService service;

    @PostMapping
    public LivroDTO insert(@RequestBody LivroDTO dto){
        dto = service.insert(dto);
        return dto;
    }

    @GetMapping("/{id}")
    public LivroDTO findById(@PathVariable Long id){
        return service.findById(id);
    }


    @GetMapping
    public Page<LivroDTO> findAll(Pageable pageable){
        return service.findAll(pageable);
    }
}
