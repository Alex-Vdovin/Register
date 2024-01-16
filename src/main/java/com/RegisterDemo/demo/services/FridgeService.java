package com.RegisterDemo.demo.services;

import com.RegisterDemo.demo.entities.Fridge;
import com.RegisterDemo.demo.repositories.FridgeRepository;
import com.RegisterDemo.demo.repositories.VacuumCleanerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FridgeService extends GadgetService{
    @Autowired
    private final FridgeRepository fridgeRepository;
    @Autowired
    private final VacuumCleanerRepository vacuumCleanerRepository;

    @Override
    public void addModels(Long id, String model) {
        Fridge fridge = fridgeRepository.findById(id).get();
        fridge.getModelsAvailableSet().add(model);
        fridgeRepository.save(fridge);
    }
}
