package com.med.pet_management_system.service;

import com.med.pet_management_system.model.Vet;
import com.med.pet_management_system.repository.VetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VetService {
    private final VetRepository vetRepository;

    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    public List<Vet> getAllVets() {
        return vetRepository.findAll();
    }

    public Optional<Vet> getVetById(Long id) {
        return vetRepository.findById(id);
    }

    public Vet createVet(Vet vet) {
        return vetRepository.save(vet);
    }

    public Optional<Vet> updateVet(Long id, Vet updatedVet) {
        return vetRepository.findById(id).map(vet -> {
            vet.setName(updatedVet.getName());
            vet.setSpecialization(updatedVet.getSpecialization());
            return vetRepository.save(vet);
        });
    }

    public void deleteVet(Long id) {
        vetRepository.deleteById(id);
    }
}
