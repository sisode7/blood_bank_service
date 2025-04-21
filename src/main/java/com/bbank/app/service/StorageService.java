package com.bbank.app.service;

import com.bbank.app.model.Storage;
import com.bbank.app.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StorageService {
    @Autowired
    private StorageRepository storageRepository;

    public List<Storage> getAllUnits(){
        return storageRepository.getStorages();
    }

    public Storage getStorageByBloodGroup(String bloodGroup) {
        return storageRepository.getByBloodGroup(bloodGroup);
    }

    @Transactional
    public void updateStorage(Storage storage) {
        storageRepository.save(storage);
    }
}
