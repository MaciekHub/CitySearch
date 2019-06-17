package pr.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import pr.webapp.interfaces.UserService;
import pr.webapp.model.User;
import pr.webapp.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;

	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("loginForm") User loginForm, BindingResult bindingResult, Model model) {
		userValidator.isLoginCorrect(loginForm, bindingResult);
		final ModelAndView mView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			System.out.print("### ERROR IN LOGIN ###");
			mView.setViewName("login");
			return mView;
		} else {
			System.out.print("### CORRECT LOGIN ###");
			mView.setViewName("home");
			mView.addObject("message", "Welcome " + loginForm.getUsername() + "!");
			return mView;
		}
	}

	@GetMapping("/login")
	private String loginUser(Model model) {
		model.addAttribute("loginForm", new User());
		return "login";
	}

	@GetMapping("/signin")
	private String registerUser(Model model) {
		model.addAttribute("userForm", new User());
		return "signin";
	}

	@PostMapping("/signin")
	private String registerUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			System.out.print("### ERROR IN BINDING ###");
			return "signin";
		} else {
			System.out.print("### NO ERRORS ###");
			userService.save(userForm);
			return "redirect:/homepage";
		}
	}

}
