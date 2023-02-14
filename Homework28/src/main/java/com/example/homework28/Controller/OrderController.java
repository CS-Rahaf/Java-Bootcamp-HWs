package com.example.homework28.Controller;


import com.example.homework28.Model.MyUser;
import com.example.homework28.Model.Orderr;
import com.example.homework28.Service.OrderService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@AllArgsConstructor
public class OrderController {



    private final OrderService orderService;


    @GetMapping("")
    public ResponseEntity getOrders(@AuthenticationPrincipal MyUser myUser){
        List<Orderr> orderrs = orderService.getOrders(myUser);

        return ResponseEntity.status(200).body(orderrs);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOrder(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer id){
        Orderr orders = orderService.getOrder(myUser, id);

        return ResponseEntity.status(200).body(orders);
    }

    @PostMapping("")
    public ResponseEntity addOrder(@AuthenticationPrincipal MyUser myUser,  @RequestBody ObjectNode objectNode){
        orderService.addOrder(myUser, objectNode);
        return ResponseEntity.status(200).body("Order has been added Successfully");
    }

    @PutMapping("/{id}/status")
    @ResponseBody
    public ResponseEntity changeStatus(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer id, @RequestParam String status){

        orderService.changeStatus(myUser, id, status);
        return ResponseEntity.status(200).body("Order status has been updated Successfully");
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity deleteOrder(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer id){
        orderService.deleteOrder(myUser, id);
        return ResponseEntity.status(200).body("Order has been deleted Successfully");
    }




}
