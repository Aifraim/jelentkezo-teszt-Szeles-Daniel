package com.teszt.demo.cim;

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
@RequestMapping("/api/cimek")
public class CimController {

    private final CimService cimService;

    public CimController(CimService cimService) {
        this.cimService = cimService;
    }

    @GetMapping
    public ResponseEntity<List<Cim>> getAllCimek() {
        return ResponseEntity.ok(cimService.findAllCimek());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cim> getCimById(@PathVariable Integer id) {
        return cimService.findCimById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cim> createCim(@RequestBody Cim cim) {
        Cim savedCim = cimService.saveCim(cim);
        return ResponseEntity.ok(savedCim);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cim> updateCim(@PathVariable Integer id, @RequestBody Cim cim) {
        return cimService.findCimById(id)
                .map(existingCim -> {
                    existingCim.setCimTipus(cim.getCimTipus());
                    existingCim.setUtca(cim.getUtca());
                    existingCim.setVaros(cim.getVaros());
                    existingCim.setAllam(cim.getAllam());
                    existingCim.setOrszag(cim.getOrszag());
                    existingCim.setIranyitoszam(cim.getIranyitoszam());
                    Cim updatedCim = cimService.saveCim(existingCim);
                    return ResponseEntity.ok(updatedCim);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCim(@PathVariable Integer id) {
        cimService.deleteCim(id);
        return ResponseEntity.ok().build();
    }

}
