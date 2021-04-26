package com.printShop.printshopserver.repository;

import com.printShop.printshopserver.repository.entity.Payer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayerRepository extends JpaRepository<Payer, String> {
}
