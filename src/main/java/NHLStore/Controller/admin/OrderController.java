package NHLStore.Controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import NHLStore.domain.Order;
import NHLStore.service.OrderService;

@Controller
@RequestMapping("admin/order")
public class OrderController {
	@Autowired
	OrderService orderService;
	@RequestMapping()
	public String order(Model model) {
		List<Order>list=orderService.findAll();
		model.addAttribute("orders",list);
		return "admin/orders/Order";

	}
}
