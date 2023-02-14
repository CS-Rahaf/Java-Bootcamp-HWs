package com.example.homework28.Repository;

import com.example.homework28.Model.Orderr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends JpaRepository<Orderr, Integer> {

    Orderr findOrderById(Integer id);
}
