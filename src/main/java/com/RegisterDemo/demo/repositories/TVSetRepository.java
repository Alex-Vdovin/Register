package com.RegisterDemo.demo.repositories;

import com.RegisterDemo.demo.entities.Smartphone;
import com.RegisterDemo.demo.entities.TVSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface TVSetRepository extends JpaRepository<TVSet, Long> {
    Optional<TVSet> findById(Long id);
    Optional<TVSet> findByNameIgnoreCase(String name);
    Optional<TVSet> findByCountryIgnoreCase(String country);
    Optional<TVSet> findByManufacturerIgnoreCase(String manufacturer);
    Optional<TVSet> findBySerialNumber(Long serialNumber);
    Optional<TVSet> findByColourIgnoreCase(String colour);
    Optional<TVSet> findBySize(Integer size);
    Optional<TVSet> findByPrice(Integer price);
    Optional<TVSet> findByCategoryIgnoreCase(String category);
    Optional<TVSet> findByTechnologyIgnoreCase(String technology);
    Optional<TVSet> findByOnlineOrderAvailability(boolean onlineOrderAvailability);
    Optional<TVSet> findByInstallmentAvailability(boolean installmentAvailability);
    Optional<TVSet> findByGadgetAvailability(boolean gadgetAvailability);
}
