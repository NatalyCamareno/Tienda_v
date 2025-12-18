
package com.Tienda.Tienda.service;

import com.Tienda.Tienda.domain.Role;
import com.Tienda.Tienda.repository.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service 
public class RoleService {

    @Autowired 
    private RoleRepository roleRepository;

  
    @Transactional(readOnly = true)
    public List<Role> getRoles() { 
        var lista = roleRepository.findAll();
        return lista;
    }

    @Transactional(readOnly = true)
    public Role getRole(Role role) {
        return roleRepository.findById(role.getRol()).orElse(null);
    }

    @Transactional
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Transactional
    public boolean delete(Role role) {
        try {
            roleRepository.delete(role);
            roleRepository.flush(); //Con esto se hace una solicitud de que se borre el registro
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
