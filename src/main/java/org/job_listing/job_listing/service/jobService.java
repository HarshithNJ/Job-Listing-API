package org.job_listing.job_listing.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        if(repository.existsByJobId(job.getJobId())){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", "Job already exists with the id " + job.getJobId());

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
            if(repository.existsByJobId(job.getJobId())){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("message", "Job already exists with the id " + job.getJobId());
    
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




















    public ResponseEntity<Object> deleteJob(long id) {
        Optional<job> job = repository.findById(id);

        if(job.isPresent()) {
            repository.deleteById(id);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Job Deleted successfully");
            map.put("job", job);

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } else {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No job found with id : " + id);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }

















    public ResponseEntity<Object> updateJob(String jobId, job job) {
        Optional<job> job1 = repository.findByJobId(jobId);

        if(job1.isPresent()) {
            job j = job1.get();

            if(job.getTitle() != null)
                j.setTitle(job.getTitle());

            if(job.getDescription() != null)
                j.setDescription(job.getDescription());

            if(job.getCompanyName() != null)
                j.setCompanyName(job.getCompanyName());

            if(job.getLocation() != null)
                j.setLocation(job.getLocation());

            repository.save(j);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Job updated successfully");
            map.put("job", j);

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } else {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No job found with id : " + jobId);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }  
}