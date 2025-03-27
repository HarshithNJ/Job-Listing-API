package org.job_listing.job_listing.controller;

import java.util.List;

import org.job_listing.job_listing.dto.job;
import org.job_listing.job_listing.service.jobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class jobController {
    
    @Autowired
    jobService service;


    //To Post the Job Listing
    @PostMapping("/jobs")
    public ResponseEntity<Object> postJob(@RequestBody job job) {
        return service.postJob(job);
    }

    @PostMapping("/jobs/multiple")
    public ResponseEntity<Object> postJobs(@RequestBody List<job> jobs) {
        return service.postJobs(jobs);
    }









    @GetMapping("/jobs")
    public ResponseEntity<Object> getJobs() {
        return service.getJobs();
    }
}