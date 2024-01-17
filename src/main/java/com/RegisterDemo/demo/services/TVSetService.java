package com.RegisterDemo.demo.services;

import com.RegisterDemo.demo.entities.TVSet;
import com.RegisterDemo.demo.repositories.TVSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TVSetService extends GadgetService {
    private final TVSetRepository tvSetRepository;

    @Override
    public void addModels(Long id, String model) {
        TVSet tvSet = tvSetRepository.findById(id).get();
        tvSet.getModelsAvailableSet().add(model);
        tvSetRepository.save(tvSet);
    }
}
