package NHLStore.Controller.customer;


import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

// import BHNStore.model.Account;
import NHLStore.domain.Account;
import NHLStore.domain.Product;
import NHLStore.exception.StorageException;
import NHLStore.model.AccountDTO;
import NHLStore.service.AccountService;


@Controller
@RequestMapping("/")
//@SessionAttributes("account")
public class AccountController {
    @Autowired
    AccountService accountService; 
    @Autowired
    private HttpSession session;
    private Long accountid;
    @GetMapping("/login")
    public String login(ModelMap model)
    {
        model.addAttribute("account",new AccountDTO());
        return "customer/login";
    }
    @PostMapping("/login")
    public ModelAndView Login(ModelMap model, @Valid @ModelAttribute("account") AccountDTO dto, BindingResult result)
    { 
        if(result.hasErrors())
        {
            return new ModelAndView("forward:/login", model);
        }
        
        System.out.println(dto.getUsername()+" "+dto.getPassword());
        Optional<Account> optExist=accountService.findByUserName(dto.getUsername());
        // Account account = accountService.login(dto.getUsername(),dto.getPassword());
        System.out.println(optExist.isPresent());
        if(optExist.isPresent() && dto.getPassword().equals(optExist.get().getPassword()))
        {
			System.out.println("password "+optExist.get().getPassword());
           
            session.setAttribute("accountid", optExist.get().getId());
//            System.out.println(session.getAttribute("id"));
            // return new ModelAndView("forward:/",model);
            model.addAttribute("accountid",optExist.get().getId());
            return new ModelAndView("forward:/home",model);
            // session.setAttribute("username", dto.account.getUsername());
            
        }
        // model.addAttribute("message","Invalid username or password");
        // optExist.get().setPassword("");
        System.out.println("no");
        Account acc= new Account();
        acc=optExist.get();
        AccountDTO acd=new AccountDTO();
        BeanUtils.copyProperties(acc, acd);
        model.addAttribute("account",acd);
        return new ModelAndView("customer/login",model);

        
        // return new ModelAndView("forward:/",model);
    }
    @RequestMapping("logout")
    public String logout(Model model)
    {
    	session.setAttribute("accountid", null);
    	model.addAttribute("account",new AccountDTO());
    	return "customer/login";
    }
    
    @GetMapping("/dangky")    
    public String Dangky(Model model)
    {
        model.addAttribute("account", new AccountDTO());

        return "customer/dangky";
    }
   
    @RequestMapping("/save")
    public ModelAndView dangky(ModelMap model, @ModelAttribute("account") AccountDTO dto) throws StorageException
    {
        
        Account entity=new Account();
        if(dto.getPassword().equals(dto.getConfirm_password()))
        {
        	System.out.println("1");
            BeanUtils.copyProperties(dto, entity);
            System.out.println(dto.getUsername());
            System.out.println(dto.getPassword());
            System.out.println(entity.getPassword());
            accountService.save(entity);
            model.addAttribute("message","Đăng ký thành công");
            model.addAttribute("accountid",dto.getId());
            return new ModelAndView("forward:/login", model);
        }
        else 
        {
            model.addAttribute("message","Loi !!");
            return new ModelAndView("customer/dangky",model);
        }
    }
//    @ModelAttribute("account")
//    public Long getaccountid() {
//    	return (long) 1000;
//    }
}
