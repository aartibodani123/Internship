package com.example.demo.controller.Customer;


import com.example.demo.common.ApiResponse;
import com.example.demo.model.Customer;
import com.example.demo.model.enums.Role;
import com.example.demo.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.List;

@Controller
@RequestMapping("/customers")

public class CustomerController {
    @Autowired
    CustomerServiceImpl service;

//    @PostMapping("/signup")
//    public ResponseEntity<ApiResponse<Customer>> signUpCustomer(@RequestBody Customer c){
//        Customer customer=service.signUpCustomer(c);
//        ApiResponse<Customer> apiResponse=new ApiResponse<>(201,"201 CREATED",customer);
//        return ResponseEntity.status(201).body(apiResponse);
//    }
    @GetMapping("/signup")
    public String showSignupPage() {
        return "customer-signup"; // customer-signup.jsp in /WEB-INF/jsp/
    }

    @PostMapping("/signup")
    public String signUpCustomer(@ModelAttribute Customer c, Model model) {
        c.setRole(Role.CUSTOMER);
        String signInReply = service.signUpCustomer(c);
        if(signInReply.equals("signup successfull")){
            model.addAttribute("message", "Signup successfull!");
        }
        else{
            model.addAttribute("error" ,"Email already exists");
        }
        return "customer-login";

 // redirect to login page after signup
    }

//    @PostMapping("/login")
//    public ResponseEntity<ApiResponse<String>> loginCustomer(@RequestBody Customer c){
//        String loginReply=service.loginCustomer(c);
//        ApiResponse<String> apiResponse=new ApiResponse<>(200,"200 OK",loginReply);
//        return ResponseEntity.status(200).body(apiResponse);
//    }
    @GetMapping("/login")
    public String showLoginPage() {
        return "customer-login"; // customer-login.jsp
    }

    // Handle login form submit
    @PostMapping("/login")
    public String loginCustomer(@ModelAttribute Customer c, Model model) {
        Customer loginResponce = service.loginCustomer(c);
        if (loginResponce != null) {
            model.addAttribute("user_name",loginResponce.getName());
            model.addAttribute("User Id",loginResponce.getUser_Id());
            return "customer-dashboard"; // a JSP page for customer after login
        } else {
            model.addAttribute("error", "Invalid email/password");
            return "customer-login"; // reload login page with error
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Customer>>> getCustomers(){

        List<Customer> customers= service.getCustomers();
        ApiResponse<List<Customer>> apiResponse=new ApiResponse<>(200,"200 OK",customers);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<ApiResponse<Customer>> getCustomerById(@PathVariable Long  id){
        Customer customer= service.getCustomerById(id);
        ApiResponse<Customer> apiResponse=new ApiResponse<>(200,"200 OK",customer);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<Customer>> updateCustomer(@PathVariable Long id,@RequestBody Customer c){
        c.setUserId(id);
        Customer customer=service.updateCustomer(c,id);
        ApiResponse<Customer> apiResponse=new ApiResponse<>(200,"200 OK",customer);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<String>> deleteCustomerById(@PathVariable Long  id){

        service.deleteCustomerById(id);
        ApiResponse<String> apiResponse=new ApiResponse<>(200,"Customer Deleted ",null);
        return ResponseEntity.status(200).body(apiResponse);
    }


}
