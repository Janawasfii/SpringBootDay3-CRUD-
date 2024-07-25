package com.example.springbootday3ex32.Controller;

import com.example.springbootday3ex32.API.APIResponse;
import com.example.springbootday3ex32.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    ArrayList<Customer> customers = new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Customer> getCustomers(){
        return customers;
    }
    @PostMapping("/add")
    public APIResponse addCustomer(@RequestBody Customer customer){
     customers.add(customer);
     return new APIResponse ("Successfully added customer.");
}
    @PutMapping("/update/{index}")
    public APIResponse updateCustomer(@PathVariable int index, @RequestBody Customer customer){
        customers.set(index, customer);
        return new APIResponse ("Successfully updated customer.");
}
    @DeleteMapping("/delete/{index}")
    public APIResponse deleteCustomer(@PathVariable int index){
        customers.remove(index);
        return new APIResponse ("Successfully deleted customer.");
   }

   @PutMapping("/set/{index}/{amount}")
    public APIResponse depositMoney(@PathVariable int index,@PathVariable double amount){
       customers.get(index).setBalance(amount +customers.get(index).getBalance());
       return new APIResponse ("Successfully dep customer.");
   }
   @PutMapping("/set2/{index1}/{money}")
    public APIResponse withdrawMoney (@PathVariable int index1,@PathVariable double money) {
       if (customers.get(index1).getBalance() > money) {
           customers.get(index1).setBalance(customers.get(index1).getBalance() - money);
           return new APIResponse ("Successfully withdraw money.");
       } else return new APIResponse("Balance is over the limit.");

   }
}
















