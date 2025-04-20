package com.bbank.app.service;

import com.bbank.app.model.BloodBankConsumer;
import com.bbank.app.repository.BloodBankConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodBankConsumerService {

    @Autowired
    private BloodBankConsumerRepository bloodBankConsumerRepository;

    public List<BloodBankConsumer> getAllConsumers(){
        return bloodBankConsumerRepository.getAll();
    }

    public BloodBankConsumer getBloodDonorByAadharId(String aadharId) {
        return bloodBankConsumerRepository.getByAadharId(aadharId);
    }

    public BloodBankConsumer saveOrUpdateConsumer(BloodBankConsumer bloodBankConsumer) {
        return bloodBankConsumerRepository.save(bloodBankConsumer);
    }
}
