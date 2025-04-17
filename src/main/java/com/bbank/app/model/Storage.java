package com.bbank.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "storage")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "units")
    private Integer units;

}
