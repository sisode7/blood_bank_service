package com.bbank.app.controller;

import com.bbank.app.model.BloodRequest;
import com.bbank.app.service.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloodRequest")
public class BloodRequestController {

    @Autowired
    private BloodRequestService bloodRequestService;

    @GetMapping("/all")
    public ResponseEntity<List<BloodRequest>> getAll() {
        return new ResponseEntity<>(bloodRequestService.getAllRequests(), HttpStatus.OK);
    }
    @GetMapping("/demands")
    public ResponseEntity<List<BloodRequest>> getAllDemands() {
        return new ResponseEntity<>(bloodRequestService.getAllRequestByType("DEMAND"), HttpStatus.OK);
    }
    @GetMapping("/donations")
    public ResponseEntity<List<BloodRequest>> getAllDonations() {
        return new ResponseEntity<>(bloodRequestService.getAllRequestByType("DONATE"), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<BloodRequest> saveBloodRequest(@RequestBody BloodRequest bloodRequest) throws Exception {
        BloodRequest request = bloodRequestService.saveOrUpdateDonation(bloodRequest);
        return new ResponseEntity<>(request,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteRequest(@PathVariable Long id) {
        boolean deleted = bloodRequestService.deleteRequest(id);
        return new ResponseEntity<>(deleted,HttpStatus.OK);
    }

}
