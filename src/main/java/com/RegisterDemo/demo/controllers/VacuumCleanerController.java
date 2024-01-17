package com.RegisterDemo.demo.controllers;

import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetNameComparator;
import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetPriceComparator;
import com.RegisterDemo.demo.entities.VacuumCleaner;
import com.RegisterDemo.demo.repositories.VacuumCleanerRepository;
import com.RegisterDemo.demo.services.VacuumCleanerService;
import com.RegisterDemo.demo.util.JsonUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/VacuumCleaners")
@Tag(name="Контроллер пылесосов", description = "Позволяет работать с таблицей пылесосов")
public class VacuumCleanerController {
    private VacuumCleanerService vacuumCleanerService;
    private VacuumCleanerRepository vacuumCleanerRepository;

    @RequestMapping("/getById")
    @ResponseBody
    String getById(@RequestParam(value = "id") Long id) {
        return JsonUtil.writeEntityToJson(vacuumCleanerRepository.findById(id).get());
    }

    @RequestMapping("/getByName")
    @ResponseBody
    String getByName(@RequestParam(value = "name") String name) {
        return JsonUtil.writeListToJson(vacuumCleanerRepository.findAllByNameIgnoreCase(name));
    }

    @RequestMapping("/getByCountry")
    @ResponseBody
    String getByCountry(@RequestParam(value = "country") String country) {
        return JsonUtil.writeListToJson(vacuumCleanerRepository.findAllByCountryIgnoreCase(country));
    }

    @RequestMapping("/getByManufacturer")
    @ResponseBody
    String getByManufacturer(@RequestParam(value = "manufacturer") String manufacturer) {
        return JsonUtil.writeListToJson(vacuumCleanerRepository.findAllByManufacturerIgnoreCase(manufacturer));
    }

    @RequestMapping("/getBySerialNumber")
    @ResponseBody
    String getBySerialNumber(@RequestParam(value = "serialNumber") Long serialNumber) {
        return JsonUtil.writeEntityToJson(vacuumCleanerRepository.findBySerialNumber(serialNumber).get());
    }

    @RequestMapping("/getByColour")
    @ResponseBody
    String getsByColour(@RequestParam(value = "colour") String colour) {
        return JsonUtil.writeListToJson(vacuumCleanerRepository.findAllByColourIgnoreCase(colour));
    }

    @RequestMapping("/getBySize")
    @ResponseBody
    String getBySize(@RequestParam(value = "size") Integer size) {
        return JsonUtil.writeListToJson(vacuumCleanerRepository.findAllBySize(size));
    }

    @RequestMapping("/getByPrice")
    @ResponseBody
    String getByPrice(@RequestParam(value = "price") Integer price) {
        return JsonUtil.writeListToJson(vacuumCleanerRepository.findAllByPrice(price));
    }

    @RequestMapping("/getByDustBoxCapacity")
    @ResponseBody
    String getByDustBoxCapacity(@RequestParam(value = "dustBoxCapacity") Integer dustBoxCapacity) {
        return JsonUtil.writeListToJson(vacuumCleanerRepository.findAllByDustBoxCapacity(dustBoxCapacity));
    }

    @RequestMapping("/getByModesAmount")
    @ResponseBody
    String getByModesAmount(@RequestParam(value = "modesAmount") Integer modesAmount) {
        return JsonUtil.writeListToJson(vacuumCleanerRepository.findAllByModesAmount(modesAmount));
    }

    @RequestMapping("/getByOnlineOrderAvailability")
    @ResponseBody
    String getByOnlineOrderAvailability(@RequestParam(value = "onlineOrderAvailability") boolean onlineOrderAvailability) {
        return JsonUtil.writeListToJson(vacuumCleanerRepository.findAllByOnlineOrderAvailable(onlineOrderAvailability));
    }

    @RequestMapping("/getByInstallmentAvailability")
    @ResponseBody
    String getByInstallmentAvailability(@RequestParam(value = "installmentAvailability") boolean installmentAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(vacuumCleanerRepository.findAllByInstallmentAvailable(installmentAvailability)));
    }

    @RequestMapping("/getByGadgetAvailability")
    @ResponseBody
    String getByGadgetAvailability(@RequestParam(value = "gadgetAvailability") boolean gadgetAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(vacuumCleanerRepository.findAllByGadgetAvailable(gadgetAvailability)));
    }

    @RequestMapping("/addModel")
    void addModels(@RequestParam(value = "id") Long id, @RequestParam(value = "model") String model) {
        vacuumCleanerService.addModels(id, model);
    }

    @RequestMapping("/addNew")
    void addNew(String name, String country, String manufacturer, Long serialNumber, String colour, Integer size,
                Integer price, Integer dustBoxCapacity, Integer modesAmount) {
        vacuumCleanerRepository.save(new VacuumCleaner(name, country, manufacturer, serialNumber, colour, size, price, dustBoxCapacity, modesAmount));
    }

    @RequestMapping("/alphabetSorting")
    @ResponseBody
    String sortsByAlphabet() {
        List<VacuumCleaner> result = vacuumCleanerRepository.findAll();
        result.sort(new GadgetNameComparator());
        ;
        return JsonUtil.writeListToJson(result);
    }

    @RequestMapping("/priceSorting")
    @ResponseBody
    String sortsByPrice() {
        List<VacuumCleaner> result = vacuumCleanerRepository.findAll();
        result.sort(new GadgetPriceComparator());
        ;
        return JsonUtil.writeListToJson(result);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    String gets() {
        return JsonUtil.writeListToJson(vacuumCleanerRepository.findAll());
    }


}
