package com.Intern_Project.Order_Management_System.controller;

import com.Intern_Project.Order_Management_System.model.OrderItem;
import com.Intern_Project.Order_Management_System.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Intern_Project.Order_Management_System.service.OrderService;
import com.Intern_Project.Order_Management_System.model.Order;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    int insertOrder(@RequestBody Order order){ return orderService.insertOrder(order);}

    @GetMapping("/order")
    List<Order> getAll()
    {
        return orderService.findAll();
    }

    @GetMapping("/orderId/{id}")
    List<OrderItem> getOrderById(@PathVariable("id") int id){
        return orderService.findOrderById(id);
    }

    @GetMapping("/order/{id}")
    List<Order> getOrderDetailsByUserId(@PathVariable("id") int id){
        return orderService.findOrderDetailsByUserId(id);
    }

    @DeleteMapping("/order/{id}")
    int deleteOrder(@PathVariable int id){
       return orderService.deleteOrder(id);
    }
}