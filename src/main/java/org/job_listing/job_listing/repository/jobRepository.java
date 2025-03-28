package org.job_listing.job_listing.repository;

import java.util.List;
import java.util.Optional;

import org.job_listing.job_listing.dto.job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface jobRepository extends JpaRepository<job, Long>{

    List<job> findByTitle(String title);

    List<job> findByCompanyName(String companyName);

    List<job> findByLocation(String location);

    boolean existsByJobId(String jobId);

    Optional<job> findByJobId(String jobId);

}
