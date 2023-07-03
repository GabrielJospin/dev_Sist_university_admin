package br.usp.josin.university_admin.sevices;

import br.usp.josin.university_admin.entities.inter.Service;
import br.usp.josin.university_admin.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public boolean hasPermission(Long idPerson, Character type, String entity){
        if(type != 'C' && type != 'R' && type != 'U' && type != 'D')
            return false;
        if(entity.length() != 3)
            return false;
        String filter = "%" + type + "_" + entity;
        List<Service> services = permissionRepository.findServiceByIdPersonAndFilter(idPerson, filter);
        if(services.isEmpty())
            return false;
        return true;
    }

}
