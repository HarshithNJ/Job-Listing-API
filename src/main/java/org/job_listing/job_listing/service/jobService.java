package org.job_listing.job_listing.service;

import org.job_listing.job_listing.repository.jobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class jobService {
    
    @Autowired
    jobRepository repository;
}
