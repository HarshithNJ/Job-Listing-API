package org.job_listing.job_listing.service;

import java.util.HashMap;
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
}
