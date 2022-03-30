package com.example.sklad_rest_api.repository;

import com.example.sklad_rest_api.entity.Author;
import com.example.sklad_rest_api.projection.AuthorProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

    @Query("select a.id as id,a.name as name from Author a")
    List<AuthorProjection> findAllAuthor();

}
