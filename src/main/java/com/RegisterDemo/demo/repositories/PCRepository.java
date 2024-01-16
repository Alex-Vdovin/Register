package com.RegisterDemo.demo.repositories;

import com.RegisterDemo.demo.entities.PC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PCRepository extends JpaRepository<PC, Long> {
    Optional<PC> findById(Long id);
    Optional<PC> findByNameIgnoreCase(String name);
    Optional<PC> findByCountryIgnoreCase(String country);
    Optional<PC> findByManufacturerIgnoreCase(String manufacturer);
    Optional<PC> findBySerialNumber(Long serialNumber);
    Optional<PC> findByColourIgnoreCase(String colour);
    Optional<PC> findBySize(Integer size);
    Optional<PC> findByPrice(Integer price);
    Optional<PC> findByCategoryIgnoreCase(String category);
    Optional<PC> findByProcessTypeIgnoreCase(String processType);
    Optional<PC> findByOnlineOrderAvailability(boolean onlineOrderAvailability);
    Optional<PC> findByInstallmentAvailability(boolean installmentAvailability);
    Optional<PC> findByGadgetAvailability(boolean gadgetAvailability);
}
