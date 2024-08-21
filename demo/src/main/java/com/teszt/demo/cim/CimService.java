package com.teszt.demo.cim;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CimService {

    private final CimRepository cimRepository;

    public CimService(CimRepository cimRepository) {
        this.cimRepository = cimRepository;
    }

    public List<Cim> findAllCimek() {
        return cimRepository.findAll();
    }

    public Optional<Cim> findCimById(Integer id) {
        return cimRepository.findById(id);
    }

    public Cim saveCim(Cim cim) {
        return cimRepository.save(cim);
    }

    public void deleteCim(Integer id) {
        cimRepository.deleteById(id);
    }

}
