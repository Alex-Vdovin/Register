package com.RegisterDemo.demo.repositories;

import com.RegisterDemo.demo.entities.TVSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TVSetRepository extends JpaRepository<TVSet, Long> {
    Optional<TVSet> findById(Long id);
    List<TVSet> findAllByNameIgnoreCase(String name);
    List<TVSet> findAllByCountryIgnoreCase(String country);
    List<TVSet> findAllByManufacturerIgnoreCase(String manufacturer);
    Optional<TVSet> findBySerialNumber(Long serialNumber);
    List<TVSet> findAllByColourIgnoreCase(String colour);
    List<TVSet> findAllBySize(Integer size);
    List<TVSet> findAllByPrice(Integer price);
    List<TVSet> findAllByCategoryIgnoreCase(String category);
    List<TVSet> findAllByTechnologyIgnoreCase(String technology);
    List<TVSet> findAllByOnlineOrderAvailable(boolean onlineOrderAvailability);
    List<TVSet> findAllByInstallmentAvailable(boolean installmentAvailability);
    List<TVSet> findAllByGadgetAvailable(boolean gadgetAvailability);
}
