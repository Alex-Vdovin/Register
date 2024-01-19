package com.RegisterDemo.demo.services;

import com.RegisterDemo.demo.entities.VacuumCleaner;
import com.RegisterDemo.demo.repositories.VacuumCleanerRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
public class VacuumCleanerService extends GadgetService {
    @Autowired
    private final VacuumCleanerRepository vacuumCleanerRepository;

    @Override
    public void addModels(Long id, String model) {
        VacuumCleaner vacuumCleaner = vacuumCleanerRepository.findById(id).get();
        vacuumCleaner.getModelsAvailableSet().add(model);
        vacuumCleanerRepository.save(vacuumCleaner);
    }
}
