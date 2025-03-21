package com.example.SpringAOP.service;

import com.example.SpringAOP.model.JobPost;
import com.example.SpringAOP.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {
    @Autowired
    public JobRepo repo;


    public List<JobPost> getAllJobs() {
        // System.out.println("Method called"); // This prints in the console.
        // But is not a right way to change the business logic. So AOP comes into picture, and here we
        // use the concept of AOP by creating separate packages and classes.
        return repo.findAll();
    }

    public void addJobPost(JobPost jobPost) {
        repo.save(jobPost);
    }

    public JobPost getJob(int id) {
        return repo.findById(id).orElse(null);
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int id) {
        repo.deleteById(id);
    }

    public void loadData() {
        List<JobPost> jobs = new ArrayList<>(List.of(
                new JobPost(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3, List.of("Java", "Spring", "SQL")),
                new JobPost(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5, List.of("Python", "Machine Learning", "TensorFlow")),
                new JobPost(3, "Frontend Developer", "Create amazing user interfaces with our talented frontend team.", 2, List.of("JavaScript", "React", "CSS")),
                new JobPost(4, "Network Engineer", "Design and maintain our robust network infrastructure.", 4, List.of("Cisco", "Routing", "Firewalls")),
                new JobPost(5, "UX Designer", "Shape the user experience with your creative design skills.", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping"))
        ));
        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }
}
