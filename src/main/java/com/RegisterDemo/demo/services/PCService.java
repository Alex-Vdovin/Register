package com.RegisterDemo.demo.services;

import com.RegisterDemo.demo.entities.PC;
import com.RegisterDemo.demo.repositories.PCRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
public class PCService extends GadgetService{
    @Autowired
    private final PCRepository pcRepository;
    @Override
    public void addModels(Long id, String model) {
        PC pc = pcRepository.findById(id).get();
        pc.getModelsAvailableSet().add(model);
        pcRepository.save(pc);
    }
}
