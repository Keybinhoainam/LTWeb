package NHLStore.Controller.customer;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
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
import NHLStore.model.ProductDTO;
import NHLStore.service.CartItemService;
import NHLStore.service.CategoryService;
import NHLStore.service.ProductService;
import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Controller
@RequestMapping("/customer/home")
public class HomeCotroller {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	CartItemService cartItemService;
	@Autowired
    private HttpSession session;
	@RequestMapping("")
	public String home(Model model ) {
//		System.out.println("ok");
		
		List<ProductDTO> listp1=new ArrayList<>();
		List<Product> listp1t=productService.findTop3Nuts();
		for(int i=0;i<3&&i<listp1t.size();i++) {
			ProductDTO pdt1=new ProductDTO();
			BeanUtils.copyProperties(listp1t.get(i), pdt1);
			listp1.add(pdt1);
		}
		List<ProductDTO> listp2=new ArrayList<>();
		List<Product> listp2t=productService.findTop3Oils();
		for(int i=0;i<3&&i<listp2t.size();i++) {
			ProductDTO pdt2=new ProductDTO();
			BeanUtils.copyProperties(listp2t.get(i), pdt2);
			listp2.add(pdt2);
		}
		List<ProductDTO> listp3=new ArrayList<>();
		List<Product> listp3t=productService.findTop3PastaNoodles();
		for(int i=0;i<3&&i<listp3t.size();i++) {
			ProductDTO pdt3=new ProductDTO();
			BeanUtils.copyProperties(listp3t.get(i), pdt3);
			listp3.add(pdt3);
		}
		List<Category> listc=categoryService.findAll();
		List<CartItem> listci=cartItemService.findAll();
		model.addAttribute("nuts",listp1);
		model.addAttribute("oils",listp2);
		model.addAttribute("pastaNoodles",listp3);
		model.addAttribute("categories",listc);
		model.addAttribute("cartitems",listci);
		Long accountid=(Long) session.getAttribute("accountid");
		
		model.addAttribute("accountid", accountid);
		return "customer2/index";
	}
	@RequestMapping("loc")
	public String loc(Model model,@ModelAttribute("categoryselect") Long categoryselect, @ModelAttribute("statusselect") String statusselect) {
//		System.out.println("ok");
		
		
		List<Product> listproductselect=productService.findByCondi(categoryselect,statusselect);
//		List<Product> listp=productService.findAll();
		List<Category> listc=categoryService.findAll();
		List<CartItem> listci=cartItemService.findAll();
		model.addAttribute("products",listproductselect);
		model.addAttribute("categories",listc);
		model.addAttribute("cartitems",listci);
		model.addAttribute("productselect",listproductselect);
		Long accountid=(Long) session.getAttribute("accountid");
		model.addAttribute("accountid", accountid);
		
		return "customer/HomeN";
	}
}
