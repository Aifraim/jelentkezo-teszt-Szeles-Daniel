package com.teszt.demo.szemely;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SzemelyService {

    private final SzemelyRepository szemelyRepository;

    public SzemelyService(SzemelyRepository szemelyRepository) {
        this.szemelyRepository = szemelyRepository;
    }

    public List<Szemely> findAllSzemelyek() {
        return szemelyRepository.findAll();
    }

    public Optional<Szemely> findSzemelyById(Integer id) {
        return szemelyRepository.findById(id);
    }

    public Szemely saveSzemely(Szemely szemely) {
        return szemelyRepository.save(szemely);
    }

    public void deleteSzemely(Integer id) {
        szemelyRepository.deleteById(id);
    }
}
