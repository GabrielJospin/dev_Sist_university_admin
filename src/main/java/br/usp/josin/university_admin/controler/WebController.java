package br.usp.josin.university_admin.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(value = "*")
public class WebController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/persons")
    public String persons(){
        return "persons";
    }

    @GetMapping("/project")
    public String project(){return "project";}

    @GetMapping("/courses")
    public String courses(){return "courses";}

    @GetMapping("/offerings")
    public String offerings(){return "offerings";}

    @GetMapping("/students")
    public String students(){return "students";}

    @GetMapping("/professors")
    public String professors(){return "professors";}

    @GetMapping("/employers")
    public String employers(){return "employers";}

    @GetMapping("/researches")
    public String researches(){return "researches";}

    @GetMapping("/perfis")
    public String perfis(){return "perfis";}
}
