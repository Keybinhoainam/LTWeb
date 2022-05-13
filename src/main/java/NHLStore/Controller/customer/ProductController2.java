package NHLStore.Controller.customer;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import NHLStore.domain.CartItem;
import NHLStore.domain.Category;
import NHLStore.domain.Product;
import NHLStore.exception.StorageException;
import NHLStore.exception.StoreFileNotFoundException;
import NHLStore.model.CategoryDTO;
import NHLStore.model.ProductDTO;
import NHLStore.service.CartItemService;
import NHLStore.service.CategoryService;
import NHLStore.service.ProductService;
import NHLStore.service.StorageService;
@Controller
@RequestMapping("/products")
public class ProductController2 {
	@Autowired
	ProductService productservice;
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	StorageService storageService;
	
	

	@GetMapping("infor/{productId}")
	public String infor(Model model, @PathVariable("productId") Long productId) {
		
		Optional<Product> opt=productservice.findById(productId);
		ProductDTO dtop=new ProductDTO();
		if(opt.isPresent()) {
			Product p=opt.get();
			BeanUtils.copyProperties(p, dtop);
			dtop.setCategoryId(p.getCategory().getCategoryId());
			
			Optional<Category> co=categoryService.findById(p.getCategory().getCategoryId());
			Category c=co.get();
			model.addAttribute("categoryname",c.getName());

			model.addAttribute("product", dtop);
			return "customer/ProductInfor";
		}
		model.addAttribute("mes", "Product is Empty");
		return "forward: /";
	}
	
	@GetMapping("/images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws StoreFileNotFoundException{
		Resource file=storageService.loadAsResource(filename); 
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, 
				"attachment; filename=\"" +file.getFilename()+"\"").body(file);
	}
	@RequestMapping("search")
	public String search(Model model, @RequestParam(name="name") String name){
		List<Product> list=null;
		if(!name.isEmpty()) {
			list=productservice.findByNameContaining(name);
		}
		else list=productservice.findAll();
		model.addAttribute("products", list);
		return "customer/HomeN";
	}

}
