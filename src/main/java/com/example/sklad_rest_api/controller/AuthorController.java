package com.example.sklad_rest_api.controller;

import com.example.sklad_rest_api.entity.Author;
import com.example.sklad_rest_api.projection.AuthorProjection;
import com.example.sklad_rest_api.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/author")
@RestController
@RequiredArgsConstructor
public class AuthorController {

    final AuthorRepository authorRepository;

    @GetMapping
    public ResponseEntity<List<AuthorProjection>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(authorRepository.findAllAuthor());
    }
    @PostMapping("/add")
    public ResponseEntity<Author> add(@RequestBody Author author){
        return ResponseEntity.status(HttpStatus.CREATED).body(authorRepository.save(author));
    }
}
