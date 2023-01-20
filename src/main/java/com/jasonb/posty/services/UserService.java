package com.jasonb.posty.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.jasonb.posty.models.LoginUser;
import com.jasonb.posty.models.User;
import com.jasonb.posty.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User create(User u) {
		return userRepo.save(u);
	}
	
	public User getOneById(Long id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isEmpty()) {
			return null;
		}
		return user.get();
	}
	
	public User register(User createdUser, BindingResult result) {
		if (!createdUser.getPassword().equals(createdUser.getConfirmPass())) {
			result.rejectValue("confirmPass", "Match", "Passwords must match!");
		}
		if (!result.hasErrors()) {
			createdUser.setPassword(BCrypt.hashpw(createdUser.getPassword(), BCrypt.gensalt()));
			return this.create(createdUser);
		}
		return null;
	}
	
	public User login(LoginUser logUser, BindingResult result) {
		Optional<User> user = userRepo.findByEmail(logUser.getEmail());
		if (user.isPresent() && BCrypt.checkpw(logUser.getPassword(), user.get().getPassword())) {
			return user.get();
		}
		result.rejectValue("password", "Invalid", "Invalid credentials");
		return null;
			
		
	}
}