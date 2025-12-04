package com.tiendat.service;

import com.tiendat.domain.Ruta;
import com.tiendat.repository.RutaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    public List<Ruta> getRutas() {
        return rutaRepository.findAllByOrderByRequiereRolAsc();
    }

}
