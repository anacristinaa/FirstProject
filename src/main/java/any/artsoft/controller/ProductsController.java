package any.artsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import any.artsoft.model.Product;
import service.ProductsServiceImpl;

@Controller
public class ProductsController {

	@Autowired
	ProductsServiceImpl productService;

	@RequestMapping(value = "success/addProduct", method = RequestMethod.GET)
	public ModelAndView addPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("addProduct");
		return model;
	}

	@RequestMapping(value = "success/addProduct", method = RequestMethod.POST)
	public ModelAndView addProductPage(@ModelAttribute Product product) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		try {
			productService.addProduct(product, username);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/success");
		return model;

	}

	@RequestMapping(value = "success/edit/{product_id}", method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable("product_id") int product_id) {

		Product product = productService.getProductById(product_id);
		System.out.println("IDDD: " + product.toString());
		ModelAndView model = new ModelAndView();
		model.addObject("product", product);
		model.setViewName("edit");
		return model;
	}

	@RequestMapping(value = "success/edit/saveProduct", method = RequestMethod.POST)
	public ModelAndView editProductPage(@ModelAttribute Product product, BindingResult result) {

		ModelAndView model = new ModelAndView();

		if (result.hasErrors() || product.getPrice() < 0) {
			model.addObject("result", "Invalid price edit!!");
			model.setViewName("edit");
		} else {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			try {
				productService.updateProduct(product, username);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}

			model.setViewName("redirect:/success");
		}

		return model;
	}

	@RequestMapping(value = "/success/{product_id}", method = RequestMethod.GET)
	public ModelAndView deleteProductPage(@PathVariable("product_id") int product_id) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		try{
			productService.deleteProduct(product_id, username);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
		ModelAndView model = new ModelAndView("redirect:/success");

		return model;
	}

}
