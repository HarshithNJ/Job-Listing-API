package org.job_listing.job_listing.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class job {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
