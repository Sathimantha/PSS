package com.printShop.printshopserver.service.impl;

import com.printShop.printshopserver.model.PayerDTO;
import com.printShop.printshopserver.repository.PayerRepository;
import com.printShop.printshopserver.repository.entity.Payer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PayerServiceImpl {

    @Autowired
    PayerRepository payerRepository;

    public ResponseEntity<Object> savePayerDetails(PayerDTO payerDTO) {
        Payer payerEntity = new Payer();
        payerEntity.setName(payerDTO.getName().getGiven_name()+ " "+payerDTO.getName().getSurname());
        payerEntity.setEmail_address(payerDTO.getEmail_address());
        payerEntity.setPayer_id(payerDTO.getPayer_id());
        payerEntity.setAddress(payerDTO.getAddress().getAddress_line_1()+", "+payerDTO.getAddress().getAdmin_area_1()+", "+payerDTO.getAddress().getAdmin_area_2()+", "+payerDTO.getAddress().getCountry_code()+", "+payerDTO.getAddress().getPostal_code()+", ");

//        payerEntity.setPhone(payerDTO.getPhone().getPhone_number());
        payerRepository.save(payerEntity);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
