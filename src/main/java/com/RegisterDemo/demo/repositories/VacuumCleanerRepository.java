package com.RegisterDemo.demo.repositories;

import com.RegisterDemo.demo.entities.TVSet;
import com.RegisterDemo.demo.entities.VacuumCleaner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface VacuumCleanerRepository extends JpaRepository<VacuumCleaner, Long> {
    Optional<VacuumCleaner> findById(Long id);
    Optional<VacuumCleaner> findByNameIgnoreCase(String name);
    Optional<VacuumCleaner> findByCountryIgnoreCase(String country);
    Optional<VacuumCleaner> findByManufacturerIgnoreCase(String manufacturer);
    Optional<VacuumCleaner> findBySerialNumber(Long serialNumber);
    Optional<VacuumCleaner> findByColourIgnoreCase(String colour);
    Optional<VacuumCleaner> findBySize(Integer size);
    Optional<VacuumCleaner> findByPrice(Integer price);
    Optional<VacuumCleaner> findByDustBoxCapacity(Integer dustBoxCapacity);
    Optional<VacuumCleaner> findByModesAmount(Integer modesAmount);
    Optional<VacuumCleaner> findByOnlineOrderAvailability(boolean onlineOrderAvailability);
    Optional<VacuumCleaner> findByInstallmentAvailability(boolean installmentAvailability);
    Optional<VacuumCleaner> findByGadgetAvailability(boolean gadgetAvailability);
}
