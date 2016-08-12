package any.artsoft.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import any.artsoft.dto.ProductDTO;
import any.artsoft.dto.UserDTO;
import service.UsersServiceImpl;

@Controller
public class LoginController {

	@Autowired
	UsersServiceImpl userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;

	}

	/**
	 * this method shows the page after the user logs in, depending on his role
	 * 
	 * @return model
	 */
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		String role = "";
		ModelAndView model = new ModelAndView();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		for (GrantedAuthority authority : authentication.getAuthorities()) {
			role = authority.getAuthority();
		}

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDTO userDTO = new UserDTO();
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		try {
			userDTO = userService.getUser(username);
			products = userService.ckeckUserRole(userDTO, role);

		} catch (RuntimeException e) {
			e.printStackTrace();

		}

		model.addObject("listsize", products.size());
		model.addObject("products", products);
		model.addObject("user_id", userDTO.getUser_id());
		model.addObject("lastaction", userDTO.getLastaction());
		model.addObject("role", role);
		model.setViewName("success");

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}

		model.setViewName("login");

		return model;

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("register");
		return model;

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUserPage(@ModelAttribute UserDTO userDTO) {

		ModelAndView model = new ModelAndView();
		if(userService.validatePassword(userDTO.getPassword())){
			try {
				userService.registerUser(userDTO.getUsername(), userDTO.getPassword());
			} catch (RuntimeException e) {
				e.printStackTrace();

			}
			model.setViewName("redirect:/");
		}else{
			String error = "Password null or shorter than 5.";
			model.addObject("error",error);
		}
					
		return model;

	}

}