package com.printShop.printshopserver.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class PayerDTO {

    private Address address;
    private  String email_address;
    private Name name;
    private String payer_id;
    private Phone phone;


}
