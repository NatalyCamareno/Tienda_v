package com.Tienda.Tienda.service;

import com.Tienda.Tienda.domain.Constante;
import com.Tienda.Tienda.repository.ConstanteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConstanteService {

    @Autowired
    private ConstanteRepository constanteRepository;

    @Transactional(readOnly = true)
    public List<Constante> getConstantes(boolean activos) {
        return constanteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Constante getConstante(Constante constante) {
        return constanteRepository.findById(constante.getIdConstante()).orElse(null);
    }

    @Transactional(readOnly = true)
    public String getValorPorAtributo(String atributo) {
        Constante constante = constanteRepository.findByAtributo(atributo);
        if (constante != null) {
            return constante.getValor();
        } else {
            return "";
        }
    }

    @Transactional
    public void save(Constante constante) {
        constanteRepository.save(constante);
    }

    @Transactional
    public boolean delete(Constante constante) {
        try {
            constanteRepository.delete(constante);
            constanteRepository.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
