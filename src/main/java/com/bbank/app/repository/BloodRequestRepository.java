package com.bbank.app.repository;

import com.bbank.app.model.BloodRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodRequestRepository extends JpaRepository<BloodRequest,Long> {
    @Query("SELECT br FROM BloodRequest br")
    public List<BloodRequest> getAll();

    @Query("SELECT br FROM BloodRequest br WHERE br.requestType=:requestType")
    public List<BloodRequest> getAllByRequestType(@Param("requestType") String requestType);
}
