package br.usp.josin.university_admin.controler;

import br.usp.josin.university_admin.entities.inter.Login;
import br.usp.josin.university_admin.entities.inter.Person;
import br.usp.josin.university_admin.sevices.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    LoginService loginService;

    @PostMapping
    public Person auth(@RequestBody Map<String, String> userData){
        String login = userData.get("login");
        String pass = userData.get("pass");
        Login auth =  loginService.validateLogin(login, pass);
        return auth.getPerson();
    }
}
