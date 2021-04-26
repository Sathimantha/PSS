package com.printShop.printshopserver.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Address {

    String address_line_1;
    String admin_area_1;
    String admin_area_2;
    String country_code;
    String postal_code;

}

