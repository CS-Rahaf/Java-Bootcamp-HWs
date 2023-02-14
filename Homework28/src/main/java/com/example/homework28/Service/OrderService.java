package com.example.homework28.Service;

import com.example.homework28.Exception.ApiException;
import com.example.homework28.Model.MyUser;
import com.example.homework28.Model.Orderr;
import com.example.homework28.Model.Product;
import com.example.homework28.Repository.OrderRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;


    public List<Orderr> getOrders(MyUser myUser) {
        List<Orderr> allOrderrs = orderRepository.findAll();

        List<Orderr> userOrderrs = new ArrayList<>();

        for (Orderr Orderr : allOrderrs) {
            if(Orderr.getMyUser().getId()== myUser.getId()){
                userOrderrs.add(Orderr);
            }
        }
        return userOrderrs;
    }

    public Orderr getOrder(MyUser myUser, Integer id) {
        Orderr Orderr = orderRepository.findOrderById(id);
        if(Orderr == null || Orderr.getMyUser().getId() != myUser.getId()){
            throw new ApiException("This Order does not exist");
        }
        return Orderr;
    }

    public void addOrder(MyUser myUser, ObjectNode objectNode) {

        int quantity = objectNode.get("quantity").asInt();
        Integer productId = objectNode.get("productId").asInt();

        Product product= productService.getProduct(productId);

        double totalPrice= product.getPrice() * quantity;

        Orderr orderr = new Orderr(null, quantity, totalPrice, "new", LocalDate.now(),myUser,product);

        orderRepository.save(orderr);

    }

    public void changeStatus(MyUser myUser, Integer OrderId , String status) {
        if(!myUser.getRole().equals("Admin")){
            throw new ApiException("You are not allowed to make this change");
        }

        Orderr currentOrderr = getOrder(myUser, OrderId);
        currentOrderr.setStatus(status);
        orderRepository.save(currentOrderr);

    }

    public void deleteOrder(MyUser myUser, Integer orderId) {
        Orderr orderr = getOrder(myUser, orderId);

        if(orderr.getStatus().equals("inProgress") || orderr.getStatus().equals("completed")){
            throw new ApiException("Couldn't delete this order");
        }
        orderRepository.deleteById(orderId);
    }


}
