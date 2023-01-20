package com.jasonb.posty.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jasonb.posty.models.Comment;
import com.jasonb.posty.repositories.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepo;
	
	public Comment create(Comment c) {
		return commentRepo.save(c);
	}
}
