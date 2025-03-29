package org.job_listing.job_listing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Job Listing API", version = "1.0", description = "API for listing and Managing Job Openings",
					contact = @Contact(name = "Harshith N J", email = "Harshith.dev2024@outlook.com")))
public class JobListingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobListingApplication.class, args);
	}

}
