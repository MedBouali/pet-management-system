package com.med.pet_management_system.service;

import com.med.pet_management_system.model.Pet;
import com.med.pet_management_system.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Optional<Pet> getPetById(Long id) {
        return petRepository.findById(id);
    }

    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    public Optional<Pet> updatePet(Long id, Pet updatedPet) {
        return petRepository.findById(id).map(pet -> {
            pet.setName(updatedPet.getName());
            pet.setSpecies(updatedPet.getSpecies());
            pet.setBreed(updatedPet.getBreed());
            pet.setBirthDate(updatedPet.getBirthDate());
            pet.setOwner(updatedPet.getOwner());
            return petRepository.save(pet);
        });
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
}
