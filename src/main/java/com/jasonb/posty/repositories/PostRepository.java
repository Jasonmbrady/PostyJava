package com.jasonb.posty.repositories;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jasonb.posty.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long>{

	public List<Post> findAll();
//	@Query(value = "SELECT * FROM posts WHERE post.user_id != %?1%;", nativeQuery = true )
//	public List<Post> findAllNotByUser(Long userId);
}
