package com.jasonb.posty.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jasonb.posty.models.Post;
import com.jasonb.posty.models.User;
import com.jasonb.posty.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepo;
	
	public Post create(Post p) {
		return postRepo.save(p);
	}
	
	public List<Post> getAll(){
		return postRepo.findAll();
	}
	
//	public List<Post> getAllNotByUser(Long userId){
//		List<Post> allPosts = postRepo.findAll();
////		for (Post post : allPosts) {
////			if (post.getCreatedBy().getId().equals(userId)) {
////				allPosts.remove(post);
////			}
////		}
//		for (int i = 0; i < allPosts.size(); i++) {
//			if(allPosts.get(i).getCreatedBy().getId().equals(userId)) {
//				allPosts.remove(i);
//			}
//		}
//		return allPosts;
//		
//	}
//	public List<Post> getAllNotByUser(Long userId){
//		return postRepo.findAllNotByUser(userId);
//	}
	
	public Post getOneById(Long id) {
		Optional<Post> optPost = postRepo.findById(id);
		if (optPost.isEmpty()) {
			return null;
		}
		return optPost.get();
	}
	
	public Post like(User u, Post p) {
//		List<User> usersWhoLikePost = p.getLikedBy();
		if (!p.getLikedBy().contains(u)) {
			p.getLikedBy().add(u);
			return postRepo.save(p);
		}
		return null;
	}
	
	public Post update(Post p) {
		return postRepo.save(p);
	}
}
