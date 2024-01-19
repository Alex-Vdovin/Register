package com.RegisterDemo.demo.services;

import com.RegisterDemo.demo.entities.Smartphone;
import com.RegisterDemo.demo.repositories.SmartphoneRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
public class SmartphoneService extends GadgetService {
    @Autowired
    private final SmartphoneRepository smartphoneRepository;

    @Override
    public void addModels(Long id, String model) {
        Smartphone smartphone = smartphoneRepository.findById(id).get();
        smartphone.getModelsAvailableSet().add(model);
        smartphoneRepository.save(smartphone);
    }
}
