package com.bbank.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "blood_request")
public class BloodRequest {
    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @Column(name = "consumer_id")
    private Long consumerId;

    @Column(name = "consumer_name")
    private String consumerName;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "units")
    private Integer units;

    @Column(name = "type")
    private String requestType;

}
