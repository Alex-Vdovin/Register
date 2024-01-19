package com.RegisterDemo.demo.services;

import com.RegisterDemo.demo.entities.Fridge;
import com.RegisterDemo.demo.repositories.FridgeRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
public class FridgeService extends GadgetService {
    @Autowired
    private final FridgeRepository fridgeRepository;

    @Override
    public void addModels(Long id, String model) {
        Fridge fridge = fridgeRepository.findById(id).get();
        fridge.getModelsAvailableSet().add(model);
        fridgeRepository.save(fridge);
    }
}
