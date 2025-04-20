package com.bbank.app.controller;

import com.bbank.app.model.BloodBankConsumer;
import com.bbank.app.service.BloodBankConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class BloodBankConsumerController {

    @Autowired
    private BloodBankConsumerService bloodBankConsumerService;

    @GetMapping("/all")
    public ResponseEntity<List<BloodBankConsumer>> getAllConsumers() {
        return new ResponseEntity<>(bloodBankConsumerService.getAllConsumers(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveConsumer(@RequestBody BloodBankConsumer bloodBankConsumer) {
        bloodBankConsumerService.saveOrUpdateConsumer(bloodBankConsumer);
        return new ResponseEntity<>("SUCCESS",HttpStatus.OK);
    }

}
