package com.printShop.printshopserver.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Phone {
    PhoneType phone_number;
    String phone_type;

}
@NoArgsConstructor
@AllArgsConstructor
@Data

class PhoneType {
    String national_number;

}