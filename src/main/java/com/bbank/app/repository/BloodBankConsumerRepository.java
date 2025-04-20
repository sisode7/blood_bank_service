package com.bbank.app.repository;

import com.bbank.app.model.BloodBankConsumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodBankConsumerRepository extends JpaRepository<BloodBankConsumer, Long> {

    @Query("SELECT bbc FROM BloodBankConsumer bbc")
    public List<BloodBankConsumer> getAll();

    @Query("SELECT bbc FROM BloodBankConsumer bbc WHERE bbc.aadharId=:aadharId")
    public BloodBankConsumer getByAadharId(@Param("aadharId") String aadharId);
}
