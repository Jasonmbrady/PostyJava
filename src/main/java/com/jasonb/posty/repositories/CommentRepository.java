package com.jasonb.posty.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jasonb.posty.models.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{
	
}
