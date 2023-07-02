package br.usp.josin.university_admin.sevices;

import br.usp.josin.university_admin.entities.inter.Login;
import br.usp.josin.university_admin.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Login validateLogin(String login, String pass){
        return loginRepository.findLoginByAuth(login, pass);
    }
}
