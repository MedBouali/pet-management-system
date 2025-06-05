package com.med.pet_management_system.controller;

import com.med.pet_management_system.model.Vet;
import com.med.pet_management_system.service.VetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vets")
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping
    public List<Vet> getAllVets() {
        return vetService.getAllVets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vet> getVetById(@PathVariable Long id) {
        return vetService.getVetById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vet createVet(@RequestBody Vet vet) {
        return  vetService.createVet(vet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vet> updateVet(@PathVariable Long id, @RequestBody Vet vet) {
        return vetService.updateVet(id, vet)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVet(@PathVariable Long id) {
        if(vetService.getVetById(id).isPresent()) {
            vetService.deleteVet(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
