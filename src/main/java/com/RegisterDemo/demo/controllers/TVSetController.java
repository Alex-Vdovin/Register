package com.RegisterDemo.demo.controllers;

import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetNameComparator;
import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetPriceComparator;
import com.RegisterDemo.demo.entities.TVSet;
import com.RegisterDemo.demo.repositories.TVSetRepository;
import com.RegisterDemo.demo.services.TVSetService;
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
@RequestMapping("/TVSets")
@Tag(name="Контроллер телевизоров", description = "Позволяет работать с таблицей телевизоров")
public class TVSetController {
    private TVSetService tvSetService;
    private TVSetRepository tvSetRepository;

    @RequestMapping("/getById")
    @ResponseBody
    String getById(@RequestParam(value = "id") Long id) {
        return JsonUtil.writeEntityToJson(tvSetRepository.findById(id).get());
    }

    @RequestMapping("/getByName")
    @ResponseBody
    String getByName(@RequestParam(value = "name") String name) {
        return JsonUtil.writeListToJson(tvSetRepository.findAllByNameIgnoreCase(name));
    }

    @RequestMapping("/getByCountry")
    @ResponseBody
    String getByCountry(@RequestParam(value = "country") String country) {
        return JsonUtil.writeListToJson(tvSetRepository.findAllByCountryIgnoreCase(country));
    }

    @RequestMapping("/getByManufacturer")
    @ResponseBody
    String getByManufacturer(@RequestParam(value = "manufacturer") String manufacturer) {
        return JsonUtil.writeListToJson(tvSetRepository.findAllByManufacturerIgnoreCase(manufacturer));
    }

    @RequestMapping("/getBySerialNumber")
    @ResponseBody
    String getBySerialNumber(@RequestParam(value = "serialNumber") Long serialNumber) {
        return JsonUtil.writeEntityToJson(tvSetRepository.findBySerialNumber(serialNumber).get());
    }

    @RequestMapping("/getByColour")
    @ResponseBody
    String getsByColour(@RequestParam(value = "colour") String colour) {
        return JsonUtil.writeListToJson(tvSetRepository.findAllByColourIgnoreCase(colour));
    }

    @RequestMapping("/getBySize")
    @ResponseBody
    String getBySize(@RequestParam(value = "size") Integer size) {
        return JsonUtil.writeListToJson(tvSetRepository.findAllBySize(size));
    }

    @RequestMapping("/getByPrice")
    @ResponseBody
    String getByPrice(@RequestParam(value = "price") Integer price) {
        return JsonUtil.writeListToJson(tvSetRepository.findAllByPrice(price));
    }

    @RequestMapping("/getByCategory")
    @ResponseBody
    String getByCategory(@RequestParam(value = "category") String category) {
        return JsonUtil.writeListToJson(tvSetRepository.findAllByCategoryIgnoreCase(category));
    }

    @RequestMapping("/getByTechnology")
    @ResponseBody
    String getByTechnology(@RequestParam(value = "technology") String technology) {
        return JsonUtil.writeListToJson(tvSetRepository.findAllByTechnologyIgnoreCase(technology));
    }

    @RequestMapping("/getByOnlineOrderAvailability")
    @ResponseBody
    String getByOnlineOrderAvailability(@RequestParam(value = "onlineOrderAvailability") boolean onlineOrderAvailability) {
        return JsonUtil.writeListToJson(tvSetRepository.findAllByOnlineOrderAvailable(onlineOrderAvailability));
    }

    @RequestMapping("/getByInstallmentAvailability")
    @ResponseBody
    String getByInstallmentAvailability(@RequestParam(value = "installmentAvailability") boolean installmentAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(tvSetRepository.findAllByInstallmentAvailable(installmentAvailability)));
    }

    @RequestMapping("/getByGadgetAvailability")
    @ResponseBody
    String getByGadgetAvailability(@RequestParam(value = "gadgetAvailability") boolean gadgetAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(tvSetRepository.findAllByGadgetAvailable(gadgetAvailability)));
    }

    @RequestMapping("/addModel")
    void addModels(@RequestParam(value = "id") Long id, @RequestParam(value = "model") String model) {
        tvSetService.addModels(id, model);
    }

    @RequestMapping("/addNew")
    void addNew(String name, String country, String manufacturer, Long serialNumber, String colour, Integer size,
                Integer price, String category, String technology) {
        tvSetRepository.save(new TVSet(name, country, manufacturer, serialNumber, colour, size, price, category, technology));
    }

    @RequestMapping("/alphabetSorting")
    @ResponseBody
    String sortsByAlphabet() {
        List<TVSet> result = tvSetRepository.findAll();
        result.sort(new GadgetNameComparator());
        ;
        return JsonUtil.writeListToJson(result);
    }

    @RequestMapping("/priceSorting")
    @ResponseBody
    String sortsByPrice() {
        List<TVSet> result = tvSetRepository.findAll();
        result.sort(new GadgetPriceComparator());
        ;
        return JsonUtil.writeListToJson(result);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    String gets() {
        return JsonUtil.writeListToJson(tvSetRepository.findAll());
    }


}
