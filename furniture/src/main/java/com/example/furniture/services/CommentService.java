package com.example.furniture.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.furniture.core.exception.UnknowException;
import com.example.furniture.dto.Comment;
import com.example.furniture.dto.Product;
import com.example.furniture.repositories.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
    @Autowired
    private CommentRepository repository;

    public List<Comment> getAllListData() {
        return repository.findAll();
    }

    public void insertComment(Comment comment) throws UnknowException{
        Comment commentSave = repository.save(comment);
    
        if (commentSave.getComment_id() == null) {
            throw new UnknowException("Transaction cannot complete!");
        }
    }

}
