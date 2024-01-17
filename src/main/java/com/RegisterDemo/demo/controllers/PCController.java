package com.RegisterDemo.demo.controllers;

import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetNameComparator;
import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetPriceComparator;
import com.RegisterDemo.demo.entities.PC;
import com.RegisterDemo.demo.repositories.PCRepository;
import com.RegisterDemo.demo.services.PCService;
import com.RegisterDemo.demo.util.JsonUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/PC")
@Tag(name="Контроллер ПК", description = "Позволяет работать с таблицей ПК")
public class PCController {
    private PCService pcService;
    private PCRepository pcRepository;

    @RequestMapping("/getById")
    @ResponseBody
    String getsById(@RequestParam(value = "id") Long id) {
        return JsonUtil.writeEntityToJson(pcRepository.findById(id).get());
    }

    @RequestMapping("/getByName")
    @ResponseBody
    String getByName(@RequestParam(value = "name") String name) {
        return JsonUtil.writeListToJson(pcRepository.findAllByNameIgnoreCase(name));
    }

    @RequestMapping("/getByCountry")
    @ResponseBody
    String getByCountry(@RequestParam(value = "country") String country) {
        return JsonUtil.writeListToJson(pcRepository.findAllByCountryIgnoreCase(country));
    }

    @RequestMapping("/getByManufacturer")
    @ResponseBody
    String getByManufacturer(@RequestParam(value = "manufacturer") String manufacturer) {
        return JsonUtil.writeListToJson(pcRepository.findAllByManufacturerIgnoreCase(manufacturer));
    }

    @RequestMapping("/getBySerialNumber")
    @ResponseBody
    String getBySerialNumber(@RequestParam(value = "serialNumber") Long serialNumber) {
        return JsonUtil.writeEntityToJson(pcRepository.findBySerialNumber(serialNumber).get());
    }

    @RequestMapping("/getByColour")
    @ResponseBody
    String getsByColour(@RequestParam(value = "colour") String colour) {
        return JsonUtil.writeListToJson(pcRepository.findAllByColourIgnoreCase(colour));
    }

    @RequestMapping("/getBySize")
    @ResponseBody
    String getBySize(@RequestParam(value = "size") Integer size) {
        return JsonUtil.writeListToJson(pcRepository.findAllBySize(size));
    }

    @RequestMapping("/getByPrice")
    @ResponseBody
    String getByPrice(@RequestParam(value = "price") Integer price) {
        return JsonUtil.writeListToJson(pcRepository.findAllByPrice(price));
    }

    @RequestMapping("/getByCategory")
    @ResponseBody
    String getByDoorsAmount(@RequestParam(value = "category") String category) {
        return JsonUtil.writeListToJson(pcRepository.findAllByCategoryIgnoreCase(category));
    }

    @RequestMapping("/getByProcessType")
    @ResponseBody
    String getByCompressorType(@RequestParam(value = "processType") String processType) {
        return JsonUtil.writeListToJson(pcRepository.findAllByProcessTypeIgnoreCase(processType));
    }

    @RequestMapping("/getByOnlineOrderAvailability")
    @ResponseBody
    String getByOnlineOrderAvailability(@RequestParam(value = "onlineOrderAvailability") boolean onlineOrderAvailability) {
        return JsonUtil.writeListToJson(pcRepository.findAllByOnlineOrderAvailable(onlineOrderAvailability));
    }

    @RequestMapping("/getByInstallmentAvailability")
    @ResponseBody
    String getByInstallmentAvailability(@RequestParam(value = "installmentAvailability") boolean installmentAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(pcRepository.findAllByInstallmentAvailable(installmentAvailability)));
    }

    @RequestMapping("/getByGadgetAvailability")
    @ResponseBody
    String getByGadgetAvailability(@RequestParam(value = "gadgetAvailability") boolean gadgetAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(pcRepository.findAllByGadgetAvailable(gadgetAvailability)));
    }

    @RequestMapping("/addModel")
    void addModels(@RequestParam(value = "id") Long id, @RequestParam(value = "model") String model) {
        pcService.addModels(id, model);
    }

    @RequestMapping("/addNew")
    void addNew(String name, String country, String manufacturer, Long serialNumber, String colour, Integer size,
                Integer price, String category, String processType) {
        pcRepository.save(new PC(name, country, manufacturer, serialNumber, colour, size, price, category, processType));
    }

    @RequestMapping("/alphabetSorting")
    @ResponseBody
    String sortsByAlphabet() {
        List<PC> result = pcRepository.findAll();
        result.sort(new GadgetNameComparator());
        ;
        return JsonUtil.writeListToJson(result);
    }

    @RequestMapping("/priceSorting")
    @ResponseBody
    String sortsByPrice() {
        List<PC> result = pcRepository.findAll();
        result.sort(new GadgetPriceComparator());
        ;
        return JsonUtil.writeListToJson(result);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    String gets() {
        return JsonUtil.writeListToJson(pcRepository.findAll());
    }


}
