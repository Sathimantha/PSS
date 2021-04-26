package com.printShop.printshopserver.repository.entity;

import com.printShop.printshopserver.model.Address;
import com.printShop.printshopserver.model.Name;
import com.printShop.printshopserver.model.Phone;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Payer {
    @Id
    private String payer_id;
    private String address;
    private String email_address;
    private String name;
    private String phone;
}
