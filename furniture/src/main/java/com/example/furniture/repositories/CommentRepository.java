package com.example.furniture.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.furniture.dto.Comment;

public interface CommentRepository extends JpaRepository<Comment , Integer>{
     
}
