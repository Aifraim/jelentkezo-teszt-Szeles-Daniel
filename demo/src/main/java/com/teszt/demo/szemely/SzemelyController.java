package com.teszt.demo.szemely;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/szemelyek")
public class SzemelyController {

    private final SzemelyService szemelyService;

    public SzemelyController(SzemelyService szemelyService) {
        this.szemelyService = szemelyService;
    }

    @GetMapping
    public ResponseEntity<List<Szemely>> getAllSzemelyek() {
        return ResponseEntity.ok(szemelyService.findAllSzemelyek());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Szemely> getSzemelyById(@PathVariable Integer id) {
        return szemelyService.findSzemelyById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Szemely> createSzemely(@RequestBody Szemely szemely) {
        Szemely savedSzemely = szemelyService.saveSzemely(szemely);
        return ResponseEntity.ok(savedSzemely);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Szemely> updateSzemely(@PathVariable Integer id, @RequestBody Szemely szemely) {
        return szemelyService.findSzemelyById(id)
                .map(existingSzemely -> {
                    existingSzemely.setNev(szemely.getNev());
                    existingSzemely.setSzuletesiDatum(szemely.getSzuletesiDatum());
                    Szemely updatedSzemely = szemelyService.saveSzemely(existingSzemely);
                    return ResponseEntity.ok(updatedSzemely);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSzemely(@PathVariable Integer id) {
        szemelyService.deleteSzemely(id);
        return ResponseEntity.ok().build();
    }
}
