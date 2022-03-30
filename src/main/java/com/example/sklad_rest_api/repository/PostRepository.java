package com.example.sklad_rest_api.repository;

import com.example.sklad_rest_api.entity.Post;
import com.example.sklad_rest_api.projection.PostProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    @Query("select p.id as id,p.title as title,p.context as context,p.author.name as authorName from Post p")
    List<PostProjection> findAllPost();
}
