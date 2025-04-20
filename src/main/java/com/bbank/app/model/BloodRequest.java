package com.bbank.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "blood_request")
public class BloodRequest {
    @Id
    @Column(name = "request_id")
    private Long requestId;

    @Column(name = "consumer_id")
    private Long consumerId;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "units")
    private Integer units;

    @Column(name = "type")
    private String requestType;

}
