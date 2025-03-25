package org.job_listing.job_listing.controller;

import org.job_listing.job_listing.service.jobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class jobController {
    
    @Autowired
    jobService service;
}
