package org.job_listing.job_listing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class swaggerController {
    
    @GetMapping("/")
    public String index() {
        return "redirect:/swagger-ui.html";
    }
}
