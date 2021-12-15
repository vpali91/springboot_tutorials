package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired

	private UserRepository userRepository;

	@GetMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("add", new User());
		return "add";
	}

	@PostMapping("/add") // Map ONLY POST Requests
	public String addNewUser(@ModelAttribute User user, Model model) {
		model.addAttribute("add", user);
		userRepository.save(user);
		return "add";
	}

	@GetMapping("/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}

	@GetMapping("/result")
	public String getResult(Model model) {
		// This returns a JSON or XML with the users
		Iterable<User> user = userRepository.findAll();
		model.addAttribute("result", user);
		return "result";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		userRepository.delete(user);
		return "redirect:/result";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		model.addAttribute("user", user);
		return "update";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") int id, @Validated User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			user.setId(id);
			return "update";
		}

		userRepository.save(user);
		return "redirect:/result";
	}

}
