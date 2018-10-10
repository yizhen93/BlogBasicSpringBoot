/**
 * 
 */
package com.waylau.spring.boot.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.waylau.spring.boot.blog.domain.User;
import com.waylau.spring.boot.repository.UserRepository;

/**
 * @author ASUS
 *
 */

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public ModelAndView list(Model model) {
		model.addAttribute("userList", userRepository.listUsers());
		model.addAttribute("title", "�û�����");
		return new ModelAndView("users/list", "userModel", model);
	}
	
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id")Long id, Model model) {
		User user = userRepository.gerUserById(id);
		model.addAttribute("user", user);
		model.addAttribute("title", "�鿴�û�");
		return new ModelAndView("users/view", "userModel", model);
	}
	
	/*
	 * ��ȡ������ҳ��
	 */
	@GetMapping("/form")
	public ModelAndView createForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("title", "�����û�");
		return new ModelAndView("users/form", "userModel", model);
	}
	
	@PostMapping
	public ModelAndView saveOrUpdateUser(User user) {
		user = userRepository.saveOrUpdateUser(user);
		return new ModelAndView("users/form", "userModel", user);
	}
}
