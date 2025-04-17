package com.bbank.app.controller;

import com.bbank.app.model.Storage;
import com.bbank.app.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @GetMapping("/storage")
    public List<Storage> getAllStorage(){
        return storageService.getAllUnits();
    }
}
