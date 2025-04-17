package com.bbank.app.service;

import com.bbank.app.model.Storage;
import com.bbank.app.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageService {
    @Autowired
    private StorageRepository storageRepository;
    public List<Storage> getAllUnits(){
        return storageRepository.getStorages();
    }
}
