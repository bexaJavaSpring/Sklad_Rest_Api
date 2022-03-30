package com.example.sklad_rest_api.controller;

import com.example.sklad_rest_api.entity.Post;
import com.example.sklad_rest_api.projection.PostProjection;
import com.example.sklad_rest_api.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/posts")
@RestController
@RequiredArgsConstructor
public class PostController {

    final PostRepository postRepository;


    @GetMapping
    public ResponseEntity<List<PostProjection>> LISTPOST() {
        return ResponseEntity.status(HttpStatus.OK).body(postRepository.findAllPost());
    }

    @PostMapping("/add")
    public ResponseEntity<Post> add(@RequestBody Post post) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postRepository.save(post));
    }
}
