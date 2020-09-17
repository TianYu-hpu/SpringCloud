package com.kaishengit.controller;

import com.kaishengit.pojo.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/order")
    public Order findOrder() {
        return new Order("213", "已发货", 234.23F);
    }

}
