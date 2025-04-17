package com.bbank.app.repository;

import com.bbank.app.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {
    @Query("SELECT st FROM Storage st")
    public List<Storage> getStorages();
}
