package com.RegisterDemo.demo.repositories;

import com.RegisterDemo.demo.entities.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {
    Optional<Smartphone> findById(Long id);
    List<Smartphone> findAllByNameIgnoreCase(String name);
    List<Smartphone> findAllByCountryIgnoreCase(String country);
    List<Smartphone> findAllByManufacturerIgnoreCase(String manufacturer);
    Optional<Smartphone> findBySerialNumber(Long serialNumber);
    List<Smartphone> findAllByColourIgnoreCase(String colour);
    List<Smartphone> findAllBySize(Integer size);
    List<Smartphone> findAllByPrice(Integer price);
    List<Smartphone> findAllByMemoryCapacity(Integer memoryCapacity);
    List<Smartphone> findAllByCamerasAmount(Integer camerasAmount);
    List<Smartphone> findAllByOnlineOrderAvailable(boolean onlineOrderAvailability);
    List<Smartphone> findAllByInstallmentAvailable(boolean installmentAvailability);
    List<Smartphone> findAllByGadgetAvailable(boolean gadgetAvailability);
}
