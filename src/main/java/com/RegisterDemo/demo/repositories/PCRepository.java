package com.RegisterDemo.demo.repositories;

import com.RegisterDemo.demo.entities.PC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PCRepository extends JpaRepository<PC, Long> {
    Optional<PC> findById(Long id);
    List<PC> findAllByNameIgnoreCase(String name);
    List<PC> findAllByCountryIgnoreCase(String country);
    List<PC> findAllByManufacturerIgnoreCase(String manufacturer);
    Optional<PC> findBySerialNumber(Long serialNumber);
    List<PC> findAllByColourIgnoreCase(String colour);
    List<PC> findAllBySize(Integer size);
    List<PC> findAllByPrice(Integer price);
    List<PC> findAllByCategoryIgnoreCase(String category);
    List<PC> findAllByProcessTypeIgnoreCase(String processType);
    List<PC> findAllByOnlineOrderAvailable(boolean onlineOrderAvailability);
    List<PC> findAllByInstallmentAvailable(boolean installmentAvailability);
    List<PC> findAllByGadgetAvailable(boolean gadgetAvailability);
}
