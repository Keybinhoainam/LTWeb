package NHLStore.Controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import NHLStore.domain.Category;
import NHLStore.domain.Product;
import NHLStore.service.CategoryService;
import NHLStore.service.ProductService;

@Controller
@RequestMapping("/customer")
public class HomeCotroller {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@RequestMapping("home")
	public String home(Model model) {
		List<Product> listp=productService.findAll();
		List<Category> listc=categoryService.findAll();
		model.addAttribute("products",listp);
		model.addAttribute("categories",listc);
		return "customer/HomeN";
	}
}
