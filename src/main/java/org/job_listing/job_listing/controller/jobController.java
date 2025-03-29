package org.job_listing.job_listing.controller;

import java.util.List;

import org.job_listing.job_listing.dto.job;
import org.job_listing.job_listing.service.jobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class jobController {
    
    @Autowired
    jobService service;


    //To Post the Job Listing
    @PostMapping("/jobs")
    @Operation(summary = "Post the Job Listing", description = "Post the Job Listing")
    @ApiResponse(responseCode = "201", description = "Job posting Successfull")
    @ApiResponse(responseCode = "400", description = "Job Already Exists")
    public ResponseEntity<Object> postJob(@RequestBody job job) {
        return service.postJob(job);
    }

    @PostMapping("/jobs/multiple")
    @Operation(summary = "Post Multiple Job Listings", description = "Post Multiple Job Listings")
    @ApiResponse(responseCode = "201", description = "Multiple Jobs Posting Successfull")
    @ApiResponse(responseCode = "400", description = "One or More Jobs Already Exists")
    public ResponseEntity<Object> postJobs(@RequestBody List<job> jobs) {
        return service.postJobs(jobs);
    }








    //To fetch the jobs from database
    @GetMapping("/jobs")
    @Operation(summary = "Get all jobs from database", description = "Get all jobs from database")
    @ApiResponse(responseCode = "302", description = "Job Fetched successfully")
    @ApiResponse(responseCode = "404", description = "Database is Empty")
    public ResponseEntity<Object> getJobs() {
        return service.getJobs();
    }

    @GetMapping("/jobs/{title}")
    @Operation(summary = "Get Jobs by Title", description = "Get Jobs by Title")
    @ApiResponse(responseCode = "302", description = "Job Fetched successfully")
    @ApiResponse(responseCode = "404", description = "No Job found with given Title")
    public ResponseEntity<Object> getJobByTitle(@PathVariable String title) {
        return service.getJobByTitle(title);
    }

    @GetMapping("/jobs/company/{companyName}")
    @Operation(summary = "Get the list of jobs for a company", description = "Get the list of jobs for a company")
    @ApiResponse(responseCode = "302", description = "List of jobs for a company successfully fetched")
    @ApiResponse(responseCode = "404", description = "No Jobs found in the company")
    public ResponseEntity<Object> getJobByCompanyName(@PathVariable String companyName) {
        return service.getJobByCompanyName(companyName);
    }

    @GetMapping("/jobs/{location}/location")
    @Operation(summary = "Get the list of jobs for a location", description = "Get the list of jobs for a location")
    @ApiResponse(responseCode = "302", description = "List of jobs for a location successfully fetched")
    @ApiResponse(responseCode = "404", description = "No Jobs found in the location")
    public ResponseEntity<Object> getJobByLocation(@PathVariable String location) {
        return service.getJobByLocation(location);
    }











    @DeleteMapping("/jobs/{id}")
    @Operation(summary = "Delete a job by ID", description = "Delete a job by ID")
    @ApiResponse(responseCode = "200", description = "Job deleted successfully")
    @ApiResponse(responseCode = "404", description = "No Job found with given ID")
    public ResponseEntity<Object> deleteJob(@PathVariable long id) {
        return service.deleteJob(id);
    }








    @PatchMapping("/jobs/{jobId}")
    @Operation(summary = "Update a job by ID", description = "Update a job by ID")
    @ApiResponse(responseCode = "200", description = "Job updated successfully")
    @ApiResponse(responseCode = "404", description = "No Job found with given ID")
    public ResponseEntity<Object> updateJob(@PathVariable String jobId, @RequestBody job job) {
        return service.updateJob(jobId, job);
    }
}