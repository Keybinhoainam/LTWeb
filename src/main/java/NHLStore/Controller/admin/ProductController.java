package NHLStore.Controller.admin;

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

import NHLStore.domain.Category;
import NHLStore.domain.Product;
import NHLStore.exception.StorageException;
import NHLStore.exception.StoreFileNotFoundException;
import NHLStore.model.CategoryDTO;
import NHLStore.model.ProductDTO;
import NHLStore.service.CategoryService;
import NHLStore.service.ProductService;
import NHLStore.service.StorageService;
@Controller
@RequestMapping("admin/products")
public class ProductController {
	@Autowired
	ProductService productservice;
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	StorageService storageService;
	
	@ModelAttribute("categories")
	public List<CategoryDTO> getCategories(){
		return categoryService.findAll().stream().map(item->{
			CategoryDTO dtoc=new CategoryDTO();
			BeanUtils.copyProperties(item, dtoc);
			return dtoc;
		}).collect(Collectors.toList());
	}

	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("product", new ProductDTO());
		return "admin/products/ProductAddorEdit";
	}
	@GetMapping("edit/{productId}")
	public String edit(Model model, @PathVariable("productId") Long productId) {
		Optional<Product> opt=productservice.findById(productId);
		ProductDTO dtop=new ProductDTO();
		if(opt.isPresent()) {
			Product p=opt.get();
			BeanUtils.copyProperties(p, dtop);
			dtop.setCategoryId(p.getCategory().getCategoryId());
			dtop.setIsEdit(true);

			model.addAttribute("product", dtop);
			return "admin/products/ProductAddorEdit";
		}
		model.addAttribute("mes", "Product is Empty");
		return "forward: /admin/products/list";
	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveorupdate(ModelMap model,
			@Valid @ModelAttribute("product") ProductDTO dto,BindingResult result) throws StorageException {
		if(result.hasErrors()) {
			return new ModelAndView("admin/products/ProductAddorEdit",model);
		}
		Product p=new Product();
		BeanUtils.copyProperties(dto, p);
		Category category=new Category();
		category.setCategoryId(dto.getCategoryId());
		p.setCategory(category);
		
		if(!dto.getImageFile().isEmpty()) {
			UUID uuid=UUID.randomUUID();
			String uuString=uuid.toString();
			p.setImage(storageService.getStoredFilename(dto.getImageFile(), uuString));
			storageService.store(dto.getImageFile(), p.getImage());
		}
		else {
			p.setImage(dto.getImage());
		}
		
		productservice.save(p);
		model.addAttribute("mes", "Product is saved");
		return new ModelAndView("forward:/admin/products/list",model);
	}
	@GetMapping("/images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws StoreFileNotFoundException{
		Resource file=storageService.loadAsResource(filename); 
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, 
				"attachment; filename=\"" +file.getFilename()+"\"").body(file);
	}
	@GetMapping("delete/{productId}")
	public String delete(Model model, @PathVariable("productId") Long productId) {
		Optional<Product> opt=productservice.findById(productId);
		
		if(opt.isPresent()) {
			productservice.deleteById(productId);
			model.addAttribute("mes", "Product is Deleted");
			return "forward:/admin/products/list";
		}
		model.addAttribute("mes", "Product is Empty");
		return "forward:/admin/products/list";
	}
	@RequestMapping("list")
	public String list(Model model) {
		List<Product> list=productservice.findAll();
		model.addAttribute("products", list);
		return "admin/products/ProductList";
	}
	@RequestMapping("search")
	public String search(Model model, @RequestParam(name="name") String name){
		List<Product> list=null;
		if(!name.isEmpty()) {
			list=productservice.findByNameContaining(name);
		}
		else list=productservice.findAll();
		model.addAttribute("products", list);
		return "admin/products/ProductList";
	}
	@RequestMapping("listinstock")
	public String listinstock(Model model) {
		List<Product> list=productservice.findProductInStock();
		model.addAttribute("products", list);
		return "admin/products/ProductList";
	}
	@RequestMapping("listoutstock")
	public String listoutstock(Model model) {
		List<Product> list=productservice.findProductOutStock();
		model.addAttribute("products", list);
		return "admin/products/ProductList";
	}

}
