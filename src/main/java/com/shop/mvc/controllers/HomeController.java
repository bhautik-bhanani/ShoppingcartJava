package com.shop.mvc.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.mvc.model.User;
import com.shop.mvc.services.ProductService;
import com.shop.mvc.services.UserService;

/**
 * @author Bhautik Bhanani
 * 
 */
@Controller
public class HomeController {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	ProductService productService;

	@Autowired
	UserService userService;

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @param locale
	 * @param model
	 * @return home page
	 */
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("products", productService.getProductList());
		return "home";
	}

	/**
	 * @param model
	 * @return login
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	/**
	 * @param request
	 * @return string
	 */
	@RequestMapping(value = "/authLogin")
	public String authLogin(HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.getUserByEmail(auth.getName());
		if (user != null) {
			request.getSession().setAttribute("loginUser", user);
		}
		return "redirect:home";
	}

	/**
	 * @param model
	 * @param request
	 * @return home page
	 */
	@RequestMapping(value = "/logout")
	public String logout(Model model, HttpServletRequest request) {
		request.getSession().removeAttribute("loginUser");
		return "redirect:home";
	}
}
