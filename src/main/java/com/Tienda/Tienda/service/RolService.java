
package com.Tienda.Tienda.service;


import com.Tienda.Tienda.domain.Rol;
import com.Tienda.Tienda.repository.RolRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service 
public class RolService {

    @Autowired 
    private RolRepository rolRepository;

  
    @Transactional(readOnly = true)
    public List<Rol> getRols() { 
        var lista = rolRepository.findAll();
        return lista;
    }

    @Transactional(readOnly = true)
    public Rol getRol(Rol rol) {
        return rolRepository.findById(rol.getIdRol()).orElse(null);
    }

    @Transactional
    public void save(Rol rol) {
        rolRepository.save(rol);
    }

    @Transactional
    public boolean delete(Rol rol) {
        try {
            rolRepository.delete(rol);
            rolRepository.flush(); //Con esto se hace una solicitud de que se borre el registro
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

