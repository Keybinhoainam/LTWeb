package NHLStore.Controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import NHLStore.domain.Account;
import NHLStore.domain.CartItem;
import NHLStore.domain.Category;
import NHLStore.domain.Product;
import NHLStore.service.CartItemService;
import NHLStore.service.CategoryService;
import NHLStore.service.ProductService;

@Controller
@RequestMapping("/home")
public class HomeCotroller {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	CartItemService cartItemService;
	@RequestMapping("")
	public String home(Model model ) {
//		System.out.println("ok");
		
		
		List<Product> listp=productService.findAll();
		List<Category> listc=categoryService.findAll();
		List<CartItem> listci=cartItemService.findAll();
		model.addAttribute("products",listp);
		model.addAttribute("categories",listc);
		model.addAttribute("cartitems",listci);
		return "customer/HomeN";
	}
	@RequestMapping("loc")
	public String loc(Model model,@ModelAttribute("categoryselect") Long categoryselect, @ModelAttribute("statusselect") String statusselect) {
//		System.out.println("ok");
		
		
		List<Product> listproductselect=productService.findByCondi(categoryselect,statusselect);
		List<Product> listp=productService.findAll();
		List<Category> listc=categoryService.findAll();
		List<CartItem> listci=cartItemService.findAll();
		model.addAttribute("products",listp);
		model.addAttribute("categories",listc);
		model.addAttribute("cartitems",listci);
		model.addAttribute("productselect",listproductselect);
		return "customer/HomeN";
	}
}
