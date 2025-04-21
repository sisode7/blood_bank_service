package com.bbank.app.service;

import com.bbank.app.model.BloodBankConsumer;
import com.bbank.app.repository.BloodBankConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public BloodBankConsumer saveOrUpdateConsumer(BloodBankConsumer bloodBankConsumer) {
        BloodBankConsumer updateConsumer = null;
        if(bloodBankConsumer.getId() == null) {
            updateConsumer = bloodBankConsumerRepository.save(bloodBankConsumer);
        } else {
            BloodBankConsumer consumer = bloodBankConsumerRepository.getReferenceById(bloodBankConsumer.getId());
            consumer.setName(bloodBankConsumer.getName());
            consumer.setAddress(bloodBankConsumer.getAddress());
            consumer.setAadharId(bloodBankConsumer.getAadharId());
            consumer.setBloodGroup(bloodBankConsumer.getBloodGroup());
            updateConsumer = bloodBankConsumerRepository.save(consumer);
        }
        return updateConsumer;
    }

    @Transactional
    public Boolean deleteConsumer(Long consumerId) {
        BloodBankConsumer consumer = bloodBankConsumerRepository.getReferenceById(consumerId);
        bloodBankConsumerRepository.delete(consumer);
        return true;
    }
}
