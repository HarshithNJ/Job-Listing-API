package org.job_listing.job_listing.controller;

import java.util.List;

import org.job_listing.job_listing.dto.job;
import org.job_listing.job_listing.service.jobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/jobs/{title}")
    public ResponseEntity<Object> getJobByTitle(@PathVariable String title) {
        return service.getJobByTitle(title);
    }

    @GetMapping("/jobs/company/{companyName}")
    public ResponseEntity<Object> getJobByCompanyName(@PathVariable String companyName) {
        return service.getJobByCompanyName(companyName);
    }

    @GetMapping("/jobs/{location}/location")
    public ResponseEntity<Object> getJobByLocation(@PathVariable String location) {
        return service.getJobByLocation(location);
    }











    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<Object> deleteJob(@PathVariable long id) {
        return service.deleteJob(id);
    }
}