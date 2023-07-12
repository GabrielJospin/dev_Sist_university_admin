package br.usp.josin.university_admin.controler;

import br.usp.josin.university_admin.entities.inter.Service;
import br.usp.josin.university_admin.entities.intra.RelPersonProfile;
import br.usp.josin.university_admin.sevices.HistoricalServices;
import br.usp.josin.university_admin.sevices.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @Autowired
    HistoricalServices historicalServices;

    @PostMapping
    public RelPersonProfile addPermission(@RequestHeader Map<String, Object> headerData, @RequestBody Map<String, Object> bodyData){

        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'C', "RPP");
        if ( service == null){
            return null;
        }

        Long person = Long.valueOf( (String)bodyData.get("person"));
        Long profile = Long.valueOf( (String)bodyData.get("profile"));
        Date initDate = Timestamp.valueOf( (String)bodyData.get("initDate") + " 00:00:00");
        Date endDate = Timestamp.valueOf( (String)bodyData.get("endDate") + " 00:00:00");

        RelPersonProfile out = permissionService.addPersonProfile(person, profile, initDate, endDate);

        historicalServices.log(personId, service.getIdService());
        return out;
    }

    @PutMapping
    public RelPersonProfile putPermission(@RequestHeader Map<String, Object> headerData, @RequestBody RelPersonProfile relPersonProfile){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'U', "RPP");
        if ( service == null){
            return null;
        }

        RelPersonProfile out = permissionService.updateProfile(relPersonProfile);

        historicalServices.log(personId, service.getIdService());
        return out;
    }

    @GetMapping("/")
    public List<RelPersonProfile> getPermissions(@RequestHeader Map<String, Object> headerData){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'R', "RPP");
        if ( service == null){
            return null;
        }

        List<RelPersonProfile> out = permissionService.getAllPermissions();

        historicalServices.log(personId, service.getIdService());
        return out;

    }

}
