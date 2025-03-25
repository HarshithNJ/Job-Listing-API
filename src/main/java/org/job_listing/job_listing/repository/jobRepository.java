package org.job_listing.job_listing.repository;

import org.job_listing.job_listing.dto.job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface jobRepository extends JpaRepository<job, Long>{

}
