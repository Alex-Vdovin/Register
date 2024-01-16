package com.RegisterDemo.demo.repositories;

import com.RegisterDemo.demo.entities.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {
    Optional<Smartphone> findById(Long id);
    Optional<Smartphone> findByNameIgnoreCase(String name);
    Optional<Smartphone> findByCountryIgnoreCase(String country);
    Optional<Smartphone> findByManufacturerIgnoreCase(String manufacturer);
    Optional<Smartphone> findBySerialNumber(Long serialNumber);
    Optional<Smartphone> findByColourIgnoreCase(String colour);
    Optional<Smartphone> findBySize(Integer size);
    Optional<Smartphone> findByPrice(Integer price);
    Optional<Smartphone> findByMemoryCapacity(Integer memoryCapacity);
    Optional<Smartphone> findByCamerasAmount(Integer camerasAmount);
    Optional<Smartphone> findByOnlineOrderAvailability(boolean onlineOrderAvailability);
    Optional<Smartphone> findByInstallmentAvailability(boolean installmentAvailability);
    Optional<Smartphone> findByGadgetAvailability(boolean gadgetAvailability);
}
