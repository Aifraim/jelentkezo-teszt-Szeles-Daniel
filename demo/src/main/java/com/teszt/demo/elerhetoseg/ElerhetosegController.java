package com.teszt.demo.elerhetoseg;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/elerhetosegek")
public class ElerhetosegController {

    private final ElerhetosegService elerhetosegService;

    public ElerhetosegController(ElerhetosegService elerhetosegService) {
        this.elerhetosegService = elerhetosegService;
    }

    @GetMapping
    public ResponseEntity<List<Elerhetoseg>> getAllElerhetosegek() {
        return ResponseEntity.ok(elerhetosegService.findAllElerhetosegek());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Elerhetoseg> getElerhetosegById(@PathVariable Integer id) {
        return elerhetosegService.findElerhetosegById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Elerhetoseg> createElerhetoseg(@RequestBody Elerhetoseg elerhetoseg) {
        Elerhetoseg savedElerhetoseg = elerhetosegService.saveElerhetoseg(elerhetoseg);
        return ResponseEntity.ok(savedElerhetoseg);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Elerhetoseg> updateElerhetoseg(@PathVariable Integer id, @RequestBody Elerhetoseg elerhetoseg) {
        return elerhetosegService.findElerhetosegById(id)
                .map(existingElerhetoseg -> {
                    existingElerhetoseg.setTipus(elerhetoseg.getTipus());
                    existingElerhetoseg.setErtek(elerhetoseg.getErtek());
                    Elerhetoseg updatedElerhetoseg = elerhetosegService.saveElerhetoseg(existingElerhetoseg);
                    return ResponseEntity.ok(updatedElerhetoseg);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteElerhetoseg(@PathVariable Integer id) {
        elerhetosegService.deleteElerhetoseg(id);
        return ResponseEntity.ok().build();
    }
}
