package org.cjwilliams.commonscents.controller;

import org.cjwilliams.commonscents.model.Orders;
import org.cjwilliams.commonscents.model.Payment;
import org.cjwilliams.commonscents.model.Products;
import org.cjwilliams.commonscents.model.Users;
import org.cjwilliams.commonscents.repository.PaymentRepository;
import org.cjwilliams.commonscents.service.OrderService;
import org.cjwilliams.commonscents.service.PaymentService;
import org.cjwilliams.commonscents.service.ProductsService;
import org.cjwilliams.commonscents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//Order registration controller that saves order data to database

@Controller
@RequestMapping("/menu")
public class OrderRegistrationController {

	@Autowired
    private OrderService orderService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@GetMapping("/menu/{userID}")
	public Payment getPaymentByuserID(@PathVariable("userID") long userID) {
		return paymentRepository.findPaymentByuserID(userID);
	}
	
	/*
	//Getmapping for menu view
	
    @GetMapping()
    public String orders(Model model) {
    	Products products = new Products();
    	Orders orders = new Orders();
    	model.addAttribute("products", products);
    	model.addAttribute("orders", orders);
    	return "menu";
    }
    */
    //Posts order data to database
	
    @PostMapping
    public String registerOrder(@ModelAttribute Orders order, @RequestParam long id, @PathVariable long userID){
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String login = authentication.getName();
    	Users user = userService.findByEmail(login);
    	Products product = productsService.findByid(id);
    	Payment payment;
    	//if(user.getId() != findPaymentByuserID(id)) {
    	order.setProducts(product);
    	order.setUsers(user);
    	orderService.save(order);
        return "redirect:/menu?success";
   }
}