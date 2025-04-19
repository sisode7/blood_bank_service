
package com.bbank.app.controller;

import com.bbank.app.model.Storage;
import com.bbank.app.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @GetMapping("/storage")
    public ResponseEntity<List<Storage>> getAllStorage(){
        List<Storage> storageUnits = storageService.getAllUnits();
        return new ResponseEntity<List<Storage>>(storageUnits,HttpStatus.OK);
    }
}
