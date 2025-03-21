package com.example.SpringAOP.controller;

import com.example.SpringAOP.model.JobPost;
import com.example.SpringAOP.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
    @Autowired
    private JobService service;


    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{id}")
    public JobPost getJob(@PathVariable int id){
        return service.getJob(id);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJobPost(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{id}")
    public String deleteJob(@PathVariable int id){
        service.deleteJob(id);
        return "Job Deleted successfully";
    }

    //Loading data when we run the application
    @GetMapping("load")
    public String loadData(){
        service.loadData();
        return "success";
    }

    //Search by keyword
    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }
}
