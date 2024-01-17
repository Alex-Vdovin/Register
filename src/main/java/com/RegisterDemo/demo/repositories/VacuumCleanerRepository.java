package com.RegisterDemo.demo.repositories;

import com.RegisterDemo.demo.entities.VacuumCleaner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface VacuumCleanerRepository extends JpaRepository<VacuumCleaner, Long> {
    Optional<VacuumCleaner> findById(Long id);
    List<VacuumCleaner> findAllByNameIgnoreCase(String name);
    List<VacuumCleaner> findAllByCountryIgnoreCase(String country);
    List<VacuumCleaner> findAllByManufacturerIgnoreCase(String manufacturer);
    Optional<VacuumCleaner> findBySerialNumber(Long serialNumber);
    List<VacuumCleaner> findAllByColourIgnoreCase(String colour);
    List<VacuumCleaner> findAllBySize(Integer size);
    List<VacuumCleaner> findAllByPrice(Integer price);
    List<VacuumCleaner> findAllByDustBoxCapacity(Integer dustBoxCapacity);
    List<VacuumCleaner> findAllByModesAmount(Integer modesAmount);
    List<VacuumCleaner> findAllByOnlineOrderAvailable(boolean onlineOrderAvailability);
    List<VacuumCleaner> findAllByInstallmentAvailable(boolean installmentAvailability);
    List<VacuumCleaner> findAllByGadgetAvailable(boolean gadgetAvailability);
}
