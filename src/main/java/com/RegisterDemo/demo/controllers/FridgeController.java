package com.RegisterDemo.demo.controllers;

import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetNameComparator;
import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetPriceComparator;
import com.RegisterDemo.demo.entities.Fridge;
import com.RegisterDemo.demo.repositories.FridgeRepository;
import com.RegisterDemo.demo.services.FridgeService;
import com.RegisterDemo.demo.util.JsonUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/fridges")
@Tag(name="Контроллер Холодильников", description = "Позволяет работать с таблицей холодильников")
public class FridgeController {

    private FridgeService fridgeService;
    private FridgeRepository fridgeRepository;

    @RequestMapping("/getById")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильника по ID"
    )
    String getById(@RequestParam(value = "id") Long id) {
        return JsonUtil.writeEntityToJson(fridgeRepository.findById(id).get());
    }

    @RequestMapping("/getByName")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильников по названию",
            description = "Возвращает список холодильников с одним названием (можно использовать без учета регистра)"
    )
    String getByName(@RequestParam(value = "name") String name) {
        return JsonUtil.writeListToJson(fridgeRepository.findAllByNameIgnoreCase(name));
    }

    @RequestMapping("/getByCountry")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильников по стране",
            description = "Возвращает список холодильников из конкретной страны (можно использовать без учета регистра)"
    )
    String getByCountry(@RequestParam(value = "country") String country) {
        return JsonUtil.writeListToJson(fridgeRepository.findAllByCountryIgnoreCase(country));
    }

    @RequestMapping("/getByManufacturer")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильников по производителю",
            description = "Возвращает список холодильников от конкретного производителя (можно использовать без учета регистра)"
    )
    String getByManufacturer(@RequestParam(value = "manufacturer") String manufacturer) {
        return JsonUtil.writeListToJson(fridgeRepository.findAllByManufacturerIgnoreCase(manufacturer));
    }

    @RequestMapping("/getBySerialNumber")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильника по серийному номеру"
    )
    String getBySerialNumber(@RequestParam(value = "serialNumber") Long serialNumber) {
        return JsonUtil.writeEntityToJson(fridgeRepository.findBySerialNumber(serialNumber).get());
    }

    @RequestMapping("/getByColour")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильника по цвету",
            description = "Возвращает список холодильников конкретного цвета (можно использовать без учета регистра)"
    )
    String getByColour(@RequestParam(value = "colour") String colour) {
        return JsonUtil.writeListToJson(fridgeRepository.findAllByColourIgnoreCase(colour));
    }

    @RequestMapping("/getBySize")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильника по размеру",
            description = "Возвращает список холодильников конкретного размера"
    )
    String getBySize(@RequestParam(value = "size") Integer size) {
        return JsonUtil.writeListToJson(fridgeRepository.findAllBySize(size));
    }

    @RequestMapping("/getByPrice")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильника по цене",
            description = "Возвращает список холодильников по конкретной цене"
    )
    String getByPrice(@RequestParam(value = "price") Integer price) {
        return JsonUtil.writeListToJson(fridgeRepository.findAllByPrice(price));
    }

    @RequestMapping("/getByDoorsAmount")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильника по количеству дверей",
            description = "Возвращает список холодильников с конкретным количеством дверей"
    )
    String getByDoorsAmount(@RequestParam(value = "doorsAmount") Integer doorsAmount) {
        return JsonUtil.writeListToJson(fridgeRepository.findAllByDoorsAmount(doorsAmount));
    }

    @RequestMapping("/getByCompressorType")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильника по типу компрессора",
            description = "Возвращает список холодильников с конкретным типом компрессора"
    )
    String getByCompressorType(@RequestParam(value = "compressorType") String compressorType) {
        return JsonUtil.writeListToJson(fridgeRepository.findAllByCompressorTypeIgnoreCase(compressorType));
    }

    @RequestMapping("/getByOnlineOrderAvailability")
    @ResponseBody
    @Operation(
            summary = "Возможно заказать холодильник онлайн",
            description = "Возвращает список холодильников, которые можно заказать онлайн"
    )
    String getByOnlineOrderAvailability(@RequestParam(value = "onlineOrderAvailability") boolean onlineOrderAvailability) {
        return JsonUtil.writeListToJson(fridgeRepository.findAllByOnlineOrderAvailable(onlineOrderAvailability));
    }

    @RequestMapping("/getByInstallmentAvailability")
    @ResponseBody
    @Operation(
            summary = "Возможна рассрочка",
            description = "Возвращает список холодильников, которые можно купить в рассрочку"
    )
    String getByInstallmentAvailability(@RequestParam(value = "installmentAvailability") boolean installmentAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(fridgeRepository.findAllByInstallmentAvailable(installmentAvailability)));
    }

    @RequestMapping("/getByGadgetAvailability")
    @ResponseBody
    @Operation(
            summary = "Холодильник доступен к покупке",
            description = "Возвращает список холодильников, которые можно купить"
    )
    String getByGadgetAvailability(@RequestParam(value = "gadgetAvailability") boolean gadgetAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(fridgeRepository.findAllByGadgetAvailable(gadgetAvailability)));
    }

    @RequestMapping("/addModel")
    @Operation(
            summary = "Добавление моделей",
            description = "Позволяет добавлять модели к конкретному холодильнику, использует ID холодильника и название модели"
    )
    void addModels(@RequestParam(value = "id") Long id, @RequestParam(value = "model") String model) {
        fridgeService.addModels(id, model);
    }

    @RequestMapping("/addNew")
    @Operation(
            summary = "Добавление холодильника",
            description = "Позволяет добавить новый холодильник. По умолчанию он будет доступен к покупке, рассрочке и заказу онлайн"
    )
    void addNew(String name, String country, String manufacturer, Long serialNumber, String colour, Integer size,
                      Integer price, Integer doorsAmount, String compressorType, boolean onlineOrderAvailability,
                      boolean installmentAvailability, boolean gadgetAvailability) {
        fridgeRepository.save(new Fridge(name, country, manufacturer, serialNumber, colour, size, price, doorsAmount,
                compressorType, onlineOrderAvailability, installmentAvailability, gadgetAvailability));
    }

    @RequestMapping("/alphabetSorting")
    @ResponseBody
    @Operation(
            summary = "Сортировка в алфавитном порядке"
    )
    String sortByAlphabet() {
        List<Fridge> result = fridgeRepository.findAll();
        result.sort(new GadgetNameComparator());
        ;
        return JsonUtil.writeListToJson(result);
    }

    @RequestMapping("/priceSorting")
    @ResponseBody
    @Operation(
            summary = "Сортировка по цене"
    )
    String sortByPrice() {
        List<Fridge> result = fridgeRepository.findAll();
        result.sort(new GadgetPriceComparator());
        ;
        return JsonUtil.writeListToJson(result);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    @Operation(
            summary = "Возвращает все холодильники"
    )
    String getAll() {
        return JsonUtil.writeListToJson(fridgeRepository.findAll());
    }
}
