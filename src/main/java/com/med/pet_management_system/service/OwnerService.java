package com.med.pet_management_system.service;

import com.med.pet_management_system.model.Owner;
import com.med.pet_management_system.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Optional<Owner> getOwnerById(Long id) {
        return ownerRepository.findById(id);
    }

    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Optional<Owner> updateOwner(Long id, Owner updateOwner) {
        return ownerRepository.findById(id).map(owner -> {
            owner.setName(updateOwner.getName());
            owner.setEmail(updateOwner.getEmail());
            owner.setPhone(updateOwner.getPhone());
            return ownerRepository.save(owner);
        });
    }

    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }
}
