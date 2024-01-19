package com.RegisterDemo.demo.controllers;

import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetNameComparator;
import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetPriceComparator;
import com.RegisterDemo.demo.entities.VacuumCleaner;
import com.RegisterDemo.demo.services.VacuumCleanerService;
import com.RegisterDemo.demo.util.JsonUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
@RequestMapping("/VacuumCleaners")
@Tag(name="Контроллер пылесосов", description = "Позволяет работать с таблицей пылесосов")
public class VacuumCleanerController {
    @Autowired
    private VacuumCleanerService vacuumCleanerService;

    @RequestMapping("/getById")
    @ResponseBody
    @Operation(summary = "Поиск пылесоса по ID")
    String getById(@Parameter(description = "ID пылесоса") @RequestParam(value = "id") Long id) {
        return JsonUtil.writeEntityToJson(vacuumCleanerService.getVacuumCleanerRepository().findById(id).get());
    }

    @RequestMapping("/getByName")
    @ResponseBody
    @Operation(summary = "Поиск пылесоса по названию")
    String getByName(@Parameter(description = "Название пылесоса") @RequestParam(value = "name") String name) {
        return JsonUtil.writeListToJson(vacuumCleanerService.getVacuumCleanerRepository().findAllByNameIgnoreCase(name));
    }

    @RequestMapping("/getByCountry")
    @ResponseBody
    @Operation(summary = "Поиск пылесоса по стране")
    String getByCountry(@Parameter(description = "Страна изготовления пылесоса") @RequestParam(value = "country") String country) {
        return JsonUtil.writeListToJson(vacuumCleanerService.getVacuumCleanerRepository().findAllByCountryIgnoreCase(country));
    }

    @RequestMapping("/getByManufacturer")
    @ResponseBody
    @Operation(summary = "Поиск пылесоса по производителю")
    String getByManufacturer(@Parameter(description = "Производитель пылесоса") @RequestParam(value = "manufacturer") String manufacturer) {
        return JsonUtil.writeListToJson(vacuumCleanerService.getVacuumCleanerRepository().findAllByManufacturerIgnoreCase(manufacturer));
    }

    @RequestMapping("/getBySerialNumber")
    @ResponseBody
    @Operation(summary = "Поиск пылесоса по серийному номеру")
    String getBySerialNumber(@Parameter(description = "Серийный номер пылесоса") @RequestParam(value = "serialNumber") Long serialNumber) {
        return JsonUtil.writeEntityToJson(vacuumCleanerService.getVacuumCleanerRepository().findBySerialNumber(serialNumber).get());
    }

    @RequestMapping("/getByColour")
    @ResponseBody
    @Operation(summary = "Поиск пылесоса по цвету")
    String getsByColour(@Parameter(description = "Цвет") @RequestParam(value = "colour") String colour) {
        return JsonUtil.writeListToJson(vacuumCleanerService.getVacuumCleanerRepository().findAllByColourIgnoreCase(colour));
    }

    @RequestMapping("/getBySize")
    @ResponseBody
    @Operation(summary = "Поиск пылесоса по размеру")
    String getBySize(@Parameter(description = "Размер") @RequestParam(value = "size") Integer size) {
        return JsonUtil.writeListToJson(vacuumCleanerService.getVacuumCleanerRepository().findAllBySize(size));
    }

    @RequestMapping("/getByPrice")
    @ResponseBody
    @Operation(summary = "Поиск пылесоса по цене")
    String getByPrice(@Parameter(description = "Цена") @RequestParam(value = "price") Integer price) {
        return JsonUtil.writeListToJson(vacuumCleanerService.getVacuumCleanerRepository().findAllByPrice(price));
    }

    @RequestMapping("/getByDustBoxCapacity")
    @ResponseBody
    @Operation(summary = "Поиск пылесоса по объему пылесборника")
    String getByDustBoxCapacity(@Parameter(description = "Размер пылесборника") @RequestParam(value = "dustBoxCapacity") Integer dustBoxCapacity) {
        return JsonUtil.writeListToJson(vacuumCleanerService.getVacuumCleanerRepository().findAllByDustBoxCapacity(dustBoxCapacity));
    }

    @RequestMapping("/getByModesAmount")
    @ResponseBody
    @Operation(summary = "Поиск пылесоса по количеству режимов работы")
    String getByModesAmount(@Parameter(description = "Количество режимов работы") @RequestParam(value = "modesAmount") Integer modesAmount) {
        return JsonUtil.writeListToJson(vacuumCleanerService.getVacuumCleanerRepository().findAllByModesAmount(modesAmount));
    }

    @RequestMapping("/getByOnlineOrderAvailability")
    @ResponseBody
    @Operation(summary = "Возможность заказать пылесос онлайн")
    String getByOnlineOrderAvailability(@Parameter(description = "Возможность заказать пылесос онлайн") @RequestParam(value = "onlineOrderAvailability") boolean onlineOrderAvailability) {
        return JsonUtil.writeListToJson(vacuumCleanerService.getVacuumCleanerRepository().findAllByOnlineOrderAvailable(onlineOrderAvailability));
    }

    @RequestMapping("/getByInstallmentAvailability")
    @ResponseBody
    @Operation(summary = "Возможность взять пылесос в рассрочку")
    String getByInstallmentAvailability(@Parameter(description = "Возможность взять пылесос в рассрочку") @RequestParam(value = "installmentAvailability") boolean installmentAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(vacuumCleanerService.getVacuumCleanerRepository().findAllByInstallmentAvailable(installmentAvailability)));
    }

    @RequestMapping("/getByGadgetAvailability")
    @ResponseBody
    @Operation(summary = "Доступность пылесоса к покупке")
    String getByGadgetAvailability(@Parameter(description = "Доступность пылесоса к покупке") @RequestParam(value = "gadgetAvailability") boolean gadgetAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(vacuumCleanerService.getVacuumCleanerRepository().findAllByGadgetAvailable(gadgetAvailability)));
    }

    @RequestMapping("/addModel")
    @Operation(summary = "Добавление моделей к пылесосу", description = "Позволяет добавлять модели к конкретному пылесосу, использует ID пылесоса и название модели")
    void addModels(@Parameter(description = "ID пылесоса") @RequestParam(value = "id") Long id, @Parameter(description = "Название модели") @RequestParam(value = "model") String model) {
        vacuumCleanerService.addModels(id, model);
    }

    @RequestMapping("/addNew")
    @Operation(summary = "Добавление нового пылесоса")
    void addNew(@Parameter(description = "Название пылесоса") @RequestParam(value = "name") String name, @Parameter(description = "Страна изготовления пылесоса") @RequestParam(value = "country") String country, @Parameter(description = "Производитель пылесоса") @RequestParam(value = "manufacturer") String manufacturer, @Parameter(description = "Серийный номер") @RequestParam(value = "serialNumber") Long serialNumber, @Parameter(description = "Цвет") @RequestParam(value = "colour") String colour, @Parameter(description = "Размер") @RequestParam(value = "size") Integer size,
                @Parameter(description = "Цена") @RequestParam(value = "price") Integer price, @Parameter(description = "Объем пылесборника") @RequestParam(value = "dustBoxCapacity") Integer dustBoxCapacity, @Parameter(description = "Количество режимов работы  ") @RequestParam(value = "modesAmount") Integer modesAmount) {
        vacuumCleanerService.getVacuumCleanerRepository().save(new VacuumCleaner(name, country, manufacturer, serialNumber, colour, size, price, dustBoxCapacity, modesAmount));
    }

    @RequestMapping("/alphabetSorting")
    @ResponseBody
    @Operation(summary = "Сортировка по алфавиту")
    String sortsByAlphabet() {
        List<VacuumCleaner> result = vacuumCleanerService.getVacuumCleanerRepository().findAll();
        result.sort(new GadgetNameComparator());
        ;
        return JsonUtil.writeListToJson(result);
    }

    @RequestMapping("/priceSorting")
    @ResponseBody
    @Operation(summary = "Сортировка по цене")
    String sortsByPrice() {
        List<VacuumCleaner> result = vacuumCleanerService.getVacuumCleanerRepository().findAll();
        result.sort(new GadgetPriceComparator());
        ;
        return JsonUtil.writeListToJson(result);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    @Operation(summary = "Возвращает все пылесосы")
    String gets() {
        return JsonUtil.writeListToJson(vacuumCleanerService.getVacuumCleanerRepository().findAll());
    }


}
