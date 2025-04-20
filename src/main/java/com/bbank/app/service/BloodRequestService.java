package com.bbank.app.service;

import com.bbank.app.model.BloodRequest;
import com.bbank.app.model.Storage;
import com.bbank.app.repository.BloodRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodRequestService {

    @Autowired
    private BloodRequestRepository bloodRequestRepository;

    @Autowired
    private StorageService storageService;

    public List<BloodRequest> getAllRequests() {
        return bloodRequestRepository.getAll();
    }

    public List<BloodRequest> getAllRequestByType(String requestType) {
        return bloodRequestRepository.getAllByRequestType(requestType);
    }

    public BloodRequest saveOrUpdateDonation(BloodRequest bloodRequest) throws Exception {
        if(bloodRequest.getUnits()>0) {
            Integer finalUnits = 0;
            Storage storage = storageService.getStorageByBloodGroup(bloodRequest.getBloodGroup());
            if(bloodRequest.getRequestType().equals("DEMAND") && storage.getUnits() < bloodRequest.getUnits()){
                throw new Exception("Insufficient units available");
            } else {
                finalUnits = calculateUnits(bloodRequest,storage);
            }
            storage.setUnits(finalUnits);
            storageService.updateStorage(storage);
        }
        return bloodRequestRepository.save(bloodRequest);
    }

    private Integer calculateUnits(BloodRequest request,Storage storage) {
        if(request.getRequestType().equals("DEMAND")) {
            return storage.getUnits() - request.getUnits();
        }else{
            return storage.getUnits()+request.getUnits();
        }
    }
}
