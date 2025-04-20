package com.bbank.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "blood_bank_consumer")
public class BloodBankConsumer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loginUserId;

    @Column(name = "name")
    private String name;

    @Column(name = "aadhar_id")
    private String aadharId;

    @Column(name = "address")
    private String address;

    @Column(name = "blood_group")
    private String bloodGroup;

}
