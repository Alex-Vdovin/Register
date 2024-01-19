package com.RegisterDemo.demo.services;

import com.RegisterDemo.demo.entities.TVSet;
import com.RegisterDemo.demo.repositories.TVSetRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
public class TVSetService extends GadgetService {
    @Autowired
    private final TVSetRepository tvSetRepository;

    @Override
    public void addModels(Long id, String model) {
        TVSet tvSet = tvSetRepository.findById(id).get();
        tvSet.getModelsAvailableSet().add(model);
        tvSetRepository.save(tvSet);
    }
}
