package br.usp.josin.university_admin.controler;

import br.usp.josin.university_admin.entities.intra.RelPersonProfile;
import br.usp.josin.university_admin.sevices.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @PostMapping
    public RelPersonProfile addPermission(@RequestHeader Map<String, Object> headerData, @RequestBody Map<String, Object> bodyData){
        System.out.println(bodyData);
        System.out.println(headerData);
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Long person = Long.valueOf( (String)bodyData.get("person"));
        Long profile = Long.valueOf( (String)bodyData.get("profile"));
        Date initDate = Timestamp.valueOf( (String)bodyData.get("initDate"));
        Date endDate = Timestamp.valueOf( (String)bodyData.get("endDate"));
        if (!permissionService.hasPermission(personId, 'C', "RPP")){
            return null;
        }
        return permissionService.addPersonProfile(person, profile, initDate, endDate);
    }
}
