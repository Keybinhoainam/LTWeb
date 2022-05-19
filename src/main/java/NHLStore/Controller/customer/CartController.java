package NHLStore.Controller.customer;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import NHLStore.domain.Account;
import NHLStore.domain.CartItem;
import NHLStore.domain.Product;
import NHLStore.service.CartItemService;
import NHLStore.service.ProductService;
@Controller
@RequestMapping("/customer/cart")
public class CartController implements Serializable{
	@Autowired
	CartItemService cartItemService;
	@Autowired
	ProductService productService;
	@Autowired
	HttpSession session;
	@RequestMapping()
	public String cart(Model model) {
		
		Long accountId=(Long) session.getAttribute("accountid");
		if(accountId==null) {
			return "customer/login";
			
		}
		List<CartItem> list=cartItemService.findCartItem(accountId);
		
		double amount=0;
		for(CartItem c: list) {
			if(c.getQuantity()>c.getProduct().getQuantity()) {
				c.setQuantity(c.getProduct().getQuantity());
				cartItemService.save(c);
			}
			amount+=c.getProduct().getUnitPrice()*c.getQuantity();
		}
		model.addAttribute("amount", amount);
		model.addAttribute("cartitems",list);
		return "customer2/Cart";
		
		
	}
	@RequestMapping("addtocart/{id}")
	public ModelAndView addtocart(ModelMap model,@PathVariable("id") Long id) {
		
		Long accountId=(Long) session.getAttribute("accountid");
		System.out.println(accountId);
		if(accountId==null) {
			return new ModelAndView("forward:/login",model);
		}
		System.out.println("ok");
		CartItem cartitem=new CartItem();
		Product p=productService.getById(id);
		cartitem.setProduct(p);
		Account acc=new Account();
		acc.setId(accountId);
		cartitem.setAccount(acc);
		
		if(p.getQuantity()<=0) {
			model.addAttribute("message", "Product is Empty");
			return new ModelAndView("forward:/customer/cart",model);
		}
		
		int quantity=0;
		
		List<CartItem> list=cartItemService.findCartItem(accountId);
		
		for(CartItem c: list) {
			if(c.getProduct().getProductId()==id) {
				quantity=c.getQuantity();
				cartitem.setId(c.getId());
			}
		}
		cartitem.setQuantity(quantity+1);
		
		cartItemService.save(cartitem);
		return new ModelAndView("forward:/customer/cart",model);
	}
	@RequestMapping("minus1/{id}")
	public ModelAndView minus1(ModelMap model,@PathVariable("id") Long id) {
		
		Long accountId=(Long) session.getAttribute("accountid");
		System.out.println(accountId);
		if(accountId==null) {
			return new ModelAndView("forward:/login",model);
		}
		System.out.println("ok");
		CartItem cartitem=new CartItem();
		Product p=productService.getById(id);
		cartitem.setProduct(p);
		Account acc=new Account();
		acc.setId(accountId);
		cartitem.setAccount(acc);
		
		int quantity=0;
		
		List<CartItem> list=cartItemService.findCartItem(accountId);
		
		for(CartItem c: list) {
			if(c.getProduct().getProductId()==id) {
				quantity=c.getQuantity();
				cartitem.setId(c.getId());
			}
		}
		if(quantity>1) cartitem.setQuantity(quantity-1);
		else cartitem.setQuantity(quantity);
		
		cartItemService.save(cartitem);
		return new ModelAndView("forward:/customer/cart",model);
	}
	@GetMapping("delete/{id}")
	public String delete(Model model, @PathVariable("id") Long productId) {
		Optional<CartItem> opt=cartItemService.findById(productId);
		
		if(opt.isPresent()) {
			cartItemService.deleteById(productId);
			model.addAttribute("mes", "Product is Deleted");
			return "forward:/customer/cart";
		}
		model.addAttribute("mes", "Product is Empty");
		return "forward:/customer/cart";
	}
}
