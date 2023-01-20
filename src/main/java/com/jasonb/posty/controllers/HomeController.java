package com.jasonb.posty.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jasonb.posty.models.LoginUser;
import com.jasonb.posty.models.Post;
import com.jasonb.posty.models.User;
import com.jasonb.posty.services.PostService;
import com.jasonb.posty.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private PostService postServ;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
		User createdUser = userServ.register(user, result);
		if (createdUser == null) {
			model.addAttribute("loginUser", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("userId", createdUser.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser logUser, BindingResult result, HttpSession session, Model model) {
		User loggedUser = userServ.login(logUser, result);
		if (loggedUser == null) {
			model.addAttribute("user", new User());
			return "index.jsp";
		}
		session.setAttribute("userId", loggedUser.getId());
		return "redirect:/dashboard";
	
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("userId");

		model.addAttribute("user", userServ.getOneById(userId));
		model.addAttribute("post", new Post());
		model.addAttribute("allPosts", postServ.getAll());
		model.addAttribute("idInSession", userId);
		return "dashboard.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		return "redirect:/";
	}
}
