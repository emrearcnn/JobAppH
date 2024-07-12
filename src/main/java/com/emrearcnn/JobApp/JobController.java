package com.emrearcnn.JobApp;



import com.emrearcnn.JobApp.model.JobPost;
import com.emrearcnn.JobApp.repo.JobRepo;
import com.emrearcnn.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping({"/","home"})
    public String home(){
        //System.out.println("Called to method");
        return "home";
    }

    @GetMapping("addjob")
    public String addJob(){
        //System.out.println("Called to addjob method");
        return "addjob";
    }

    @PostMapping("handleForm")
    //veri almak için get veri göndermek için post
    public String handleForm(JobPost jobPost){
        service.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewJobs(Model m){
        List<JobPost> jobs = service.getAllJobs();
        m.addAttribute("jobPosts",jobs);

        return "viewalljobs";
    }
}
