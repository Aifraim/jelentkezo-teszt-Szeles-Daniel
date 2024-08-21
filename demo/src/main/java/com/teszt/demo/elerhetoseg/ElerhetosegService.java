package com.teszt.demo.elerhetoseg;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElerhetosegService {

    private final ElerhetosegRepository elerhetosegRepository;

    public ElerhetosegService(ElerhetosegRepository elerhetosegRepository) {
        this.elerhetosegRepository = elerhetosegRepository;
    }

    public List<Elerhetoseg> findAllElerhetosegek() {
        return elerhetosegRepository.findAll();
    }

    public Optional<Elerhetoseg> findElerhetosegById(Integer id) {
        return elerhetosegRepository.findById(id);
    }

    public Elerhetoseg saveElerhetoseg(Elerhetoseg elerhetoseg) {
        return elerhetosegRepository.save(elerhetoseg);
    }

    public void deleteElerhetoseg(Integer id) {
        elerhetosegRepository.deleteById(id);
    }
}
