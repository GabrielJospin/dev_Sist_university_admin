package br.usp.josin.university_admin.controler;

import br.usp.josin.university_admin.entities.inter.Login;
import br.usp.josin.university_admin.entities.inter.Person;
import br.usp.josin.university_admin.sevices.LoginService;
import br.usp.josin.university_admin.sevices.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    LoginService loginService;

    @Autowired
    PersonService personService;

    @PostMapping
    public Person auth(@RequestBody Map<String, String> userData){
        String login = userData.get("login");
        String pass = userData.get("pass");
        Login auth =  loginService.validateLogin(login, pass);

        if(auth == null)
            return null;
        return auth.getPerson();
    }

    @PostMapping("/register/")
    public Person register(@RequestBody Map<String, Object> userData){
        String login = (String) userData.get("login");
        String pass = (String) userData.get("pass");
        String idPerson = (String) userData.get("id_person");

        Long id = Long.valueOf(idPerson);
        Person person = personService.getPerson(id);
        person.setIdPerson(id);
        String md5Pass = md5Converter(pass).toLowerCase();

        Login auth = loginService.createPerson(login, md5Pass, person);
        return auth.getPerson();
    }

    private String md5Converter(String string){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(string.getBytes());
            byte[] digest = md.digest();
            return DatatypeConverter.printHexBinary(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
