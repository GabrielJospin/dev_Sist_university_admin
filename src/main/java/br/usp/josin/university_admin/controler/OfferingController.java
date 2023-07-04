package br.usp.josin.university_admin.controler;

import br.usp.josin.university_admin.entities.inter.Service;
import br.usp.josin.university_admin.entities.intra.Offering;
import br.usp.josin.university_admin.sevices.HistoricalServices;
import br.usp.josin.university_admin.sevices.OfferingService;
import br.usp.josin.university_admin.sevices.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/Offering")
public class OfferingController {

    @Autowired
    PermissionService permissionService;

    @Autowired
    OfferingService offeringService;

    @Autowired
    HistoricalServices historicalServices;

    @PostMapping
    public Offering createOffering(@RequestHeader Map<String, Object> headerData, @RequestBody Map<String, Object> bodyData){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'C', "OFF");
        if ( service == null){
            return null;
        }

        Long idStudent = Long.valueOf((String) bodyData.get("idStudent"));
        Long idProfessor = Long.valueOf((String) bodyData.get("idProfessor"));
        Long idCourse = Long.valueOf((String) bodyData.get("idCourse"));
        Date initDate = Timestamp.valueOf((String) bodyData.get("initDate"));
        Date endDate = Timestamp.valueOf((String) bodyData.get("endDate"));
        Double grade = Double.valueOf((String) bodyData.get("grade"));
        String classroom = (String) bodyData.get("classroom");
        String institution = (String) bodyData.get("institution");

        Offering out = offeringService.createOffering(idStudent, idProfessor, idCourse, initDate, endDate, grade, classroom, institution);

        historicalServices.log(personId, service.getIdService());
        return out;

    }

    @GetMapping
    public List<Offering> getOffering(@RequestHeader Map<String, Object> headerData){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'R', "OFF");
        if ( service == null){
            return null;
        }

        List<Offering> out = offeringService.getOfferings();

        historicalServices.log(personId, service.getIdService());
        return out;
    }

    @PutMapping
    public Offering updateOffering(@RequestHeader Map<String, Object> headerData, @RequestBody Offering offering){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'U', "OFF");
        if ( service == null){
            return null;
        }

        Offering out = offeringService.createOffering(offering);

        historicalServices.log(personId, service.getIdService());
        return out;
    }


}
