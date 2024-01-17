package com.RegisterDemo.demo.repositories;

import com.RegisterDemo.demo.entities.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface FridgeRepository extends JpaRepository<Fridge, Long> {
    Optional<Fridge> findById(Long id);
    List<Fridge> findAllByNameIgnoreCase(String name);
    List<Fridge> findAllByCountryIgnoreCase(String country);
    List<Fridge> findAllByManufacturerIgnoreCase(String manufacturer);
    Optional<Fridge> findBySerialNumber(Long serialNumber);
    List<Fridge> findAllByColourIgnoreCase(String colour);
    List<Fridge> findAllBySize(Integer size);
    List<Fridge> findAllByPrice(Integer price);
    List<Fridge> findAllByDoorsAmount(Integer doorAmount);
    List<Fridge> findAllByCompressorTypeIgnoreCase(String compressorType);
    List<Fridge> findAllByOnlineOrderAvailable(boolean onlineOrderAvailability);
    List<Fridge> findAllByInstallmentAvailable(boolean installmentAvailability);
    List<Fridge> findAllByGadgetAvailable(boolean gadgetAvailability);

}
