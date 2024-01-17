package com.RegisterDemo.demo.controllers;

import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetNameComparator;
import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetPriceComparator;
import com.RegisterDemo.demo.entities.Smartphone;
import com.RegisterDemo.demo.repositories.SmartphoneRepository;
import com.RegisterDemo.demo.services.SmartphoneService;
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
@RequestMapping("/smartphones")
@RequiredArgsConstructor
@Tag(name="Контроллер смартфонов", description = "Позволяет работать с таблицей смартфонов")
public class SmartphoneController {
    private SmartphoneService smartphoneService;
    private SmartphoneRepository smartphoneRepository;

    @RequestMapping("/getById")
    @ResponseBody
    String getById(@RequestParam(value = "id") Long id) {
        return JsonUtil.writeEntityToJson(smartphoneRepository.findById(id).get());
    }

    @RequestMapping("/getByName")
    @ResponseBody
    String getByName(@RequestParam(value = "name") String name) {
        return JsonUtil.writeListToJson(smartphoneRepository.findAllByNameIgnoreCase(name));
    }

    @RequestMapping("/getByCountry")
    @ResponseBody
    String getByCountry(@RequestParam(value = "country") String country) {
        return JsonUtil.writeListToJson(smartphoneRepository.findAllByCountryIgnoreCase(country));
    }

    @RequestMapping("/getByManufacturer")
    @ResponseBody
    String getByManufacturer(@RequestParam(value = "manufacturer") String manufacturer) {
        return JsonUtil.writeListToJson(smartphoneRepository.findAllByManufacturerIgnoreCase(manufacturer));
    }

    @RequestMapping("/getBySerialNumber")
    @ResponseBody
    String getBySerialNumber(@RequestParam(value = "serialNumber") Long serialNumber) {
        return JsonUtil.writeEntityToJson(smartphoneRepository.findBySerialNumber(serialNumber).get());
    }

    @RequestMapping("/getByColour")
    @ResponseBody
    String getsByColour(@RequestParam(value = "colour") String colour) {
        return JsonUtil.writeListToJson(smartphoneRepository.findAllByColourIgnoreCase(colour));
    }

    @RequestMapping("/getBySize")
    @ResponseBody
    String getBySize(@RequestParam(value = "size") Integer size) {
        return JsonUtil.writeListToJson(smartphoneRepository.findAllBySize(size));
    }

    @RequestMapping("/getByPrice")
    @ResponseBody
    String getByPrice(@RequestParam(value = "price") Integer price) {
        return JsonUtil.writeListToJson(smartphoneRepository.findAllByPrice(price));
    }

    @RequestMapping("/getByCategory")
    @ResponseBody
    String getByCamerasAmount(@RequestParam(value = "camerasAmount") Integer camerasAmount) {
        return JsonUtil.writeListToJson(smartphoneRepository.findAllByCamerasAmount(camerasAmount));
    }

    @RequestMapping("/getByProcessType")
    @ResponseBody
    String getByMemoryCapacity(@RequestParam(value = "memoryCapacity") Integer memoryCapacity) {
        return JsonUtil.writeListToJson(smartphoneRepository.findAllByMemoryCapacity(memoryCapacity));
    }

    @RequestMapping("/getByOnlineOrderAvailability")
    @ResponseBody
    String getByOnlineOrderAvailability(@RequestParam(value = "onlineOrderAvailability") boolean onlineOrderAvailability) {
        return JsonUtil.writeListToJson(smartphoneRepository.findAllByOnlineOrderAvailable(onlineOrderAvailability));
    }

    @RequestMapping("/getByInstallmentAvailability")
    @ResponseBody
    String getByInstallmentAvailability(@RequestParam(value = "installmentAvailability") boolean installmentAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(smartphoneRepository.findAllByInstallmentAvailable(installmentAvailability)));
    }

    @RequestMapping("/getByGadgetAvailability")
    @ResponseBody
    String getByGadgetAvailability(@RequestParam(value = "gadgetAvailability") boolean gadgetAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(smartphoneRepository.findAllByGadgetAvailable(gadgetAvailability)));
    }

    @RequestMapping("/addModel")
    void addModels(@RequestParam(value = "id") Long id, @RequestParam(value = "model") String model) {
        smartphoneService.addModels(id, model);
    }

    @RequestMapping("/addNew")
    void addNew(String name, String country, String manufacturer, Long serialNumber, String colour, Integer size,
                Integer price, Integer memoryCapacity, Integer camerasAmount) {
        smartphoneRepository.save(new Smartphone(name, country, manufacturer, serialNumber, colour, size, price, memoryCapacity, camerasAmount));
    }

    @RequestMapping("/alphabetSorting")
    @ResponseBody
    String sortsByAlphabet() {
        List<Smartphone> result = smartphoneRepository.findAll();
        result.sort(new GadgetNameComparator());
        ;
        return JsonUtil.writeListToJson(result);
    }

    @RequestMapping("/priceSorting")
    @ResponseBody
    String sortsByPrice() {
        List<Smartphone> result = smartphoneRepository.findAll();
        result.sort(new GadgetPriceComparator());
        ;
        return JsonUtil.writeListToJson(result);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    String gets() {
        return JsonUtil.writeListToJson(smartphoneRepository.findAll());
    }


}
