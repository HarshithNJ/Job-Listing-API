package org.job_listing.job_listing.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.job_listing.job_listing.dto.job;
import org.job_listing.job_listing.repository.jobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class jobService {
    
    @Autowired
    jobRepository repository;

    public ResponseEntity<Object> postJob(job job) {
        if(repository.existsById(job.getId())){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", "Job already exists");

            return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
        }else{
            repository.save(job);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", "Job posted successfully");
            map.put("job", job);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<Object> postJobs(List<job> jobs) {
        for(job job : jobs){
            if(repository.existsById(job.getId())){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("message", "Job already exists");
    
                return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
            }
        }
        repository.saveAll(jobs);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "Jobs posted successfully");
        map.put("jobs", jobs);

        return new ResponseEntity<Object>(map, HttpStatus.CREATED);
    }


















    public ResponseEntity<Object> getJobs() {
        List<job> jobs = repository.findAll();

        if(jobs.isEmpty()) {
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("error", "No jobs found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("success", "Jobs found");
            map.put("jobs", jobs);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getJobByTitle(String title) {
        List<job> jobs = repository.findByTitle(title);

        if(jobs.isEmpty()) {
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("error", "No jobs found with title : " +title);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("success", "Jobs found");
            map.put("jobs", jobs);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getJobByCompanyName(String companyName) {
        List<job> jobs = repository.findByCompanyName(companyName);

        if(jobs.isEmpty()) {
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("error", "No jobs found in the company : " +companyName);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        } else {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("success", "Jobs found");
            map.put("jobs", jobs);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getJobByLocation(String location) {
        List<job> jobs = repository.findByLocation(location);

        if(jobs.isEmpty()) {
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("error", "No jobs found in the location : " +location);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        } else {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("success", "Jobs found");
            map.put("jobs", jobs);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }
}