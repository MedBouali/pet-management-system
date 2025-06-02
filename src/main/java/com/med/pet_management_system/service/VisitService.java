package com.med.pet_management_system.service;

import com.med.pet_management_system.model.Visit;
import com.med.pet_management_system.repository.VisitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitService {
    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    public Optional<Visit> getVisitById(Long id) {
        return visitRepository.findById(id);
    }

    public Visit createVisit(Visit visit) {
        return visitRepository.save(visit);
    }

    public Optional<Visit> updateVisit(Long id, Visit updatedVisit) {
        return visitRepository.findById(id).map(visit -> {
            visit.setVisitDate(updatedVisit.getVisitDate());
            visit.setReason(updatedVisit.getReason());
            visit.setNotes(updatedVisit.getNotes());
            visit.setPet(updatedVisit.getPet());
            visit.setVet(updatedVisit.getVet());
            return visitRepository.save(visit);
        });
    }

    public void deleteVisit(Long id) {
        visitRepository.deleteById(id);
    }
}
