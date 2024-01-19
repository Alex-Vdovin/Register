package com.RegisterDemo.demo.controllers;

import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetNameComparator;
import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetPriceComparator;
import com.RegisterDemo.demo.entities.Smartphone;
import com.RegisterDemo.demo.services.SmartphoneService;
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
@RequestMapping("/smartphones")
@RequiredArgsConstructor
@Tag(name = "Контроллер смартфонов", description = "Позволяет работать с таблицей смартфонов")
public class SmartphoneController {
    @Autowired
    private SmartphoneService smartphoneService;

    @RequestMapping("/getById")
    @ResponseBody
    @Operation(summary = "Поиск поID Смартфона")
    String getById(@Parameter(description = "ID Смартфоны") @RequestParam(value = "id") Long id) {
        return JsonUtil.writeEntityToJson(smartphoneService.getSmartphoneRepository().findById(id).get());
    }

    @RequestMapping("/getByName")
    @ResponseBody
    @Operation(summary = "Поиск по названию смартфона")
    String getByName(@Parameter(description = "Название") @RequestParam(value = "name") String name) {
        return JsonUtil.writeListToJson(smartphoneService.getSmartphoneRepository().findAllByNameIgnoreCase(name));
    }

    @RequestMapping("/getByCountry")
    @ResponseBody
    @Operation(summary = "Поиск по стране смартфона")
    String getByCountry(@Parameter(description = "Страна") @RequestParam(value = "country") String country) {
        return JsonUtil.writeListToJson(smartphoneService.getSmartphoneRepository().findAllByCountryIgnoreCase(country));
    }

    @RequestMapping("/getByManufacturer")
    @ResponseBody
    @Operation(summary = "Поиск по производителю смартфона")
    String getByManufacturer(@Parameter(description = "Производитель") @RequestParam(value = "manufacturer") String manufacturer) {
        return JsonUtil.writeListToJson(smartphoneService.getSmartphoneRepository().findAllByManufacturerIgnoreCase(manufacturer));
    }

    @RequestMapping("/getBySerialNumber")
    @ResponseBody
    @Operation(summary = "Поиск по серийному номеру смартфона")
    String getBySerialNumber(@Parameter(description = "Серийный номер") @RequestParam(value = "serialNumber") Long serialNumber) {
        return JsonUtil.writeEntityToJson(smartphoneService.getSmartphoneRepository().findBySerialNumber(serialNumber).get());
    }

    @RequestMapping("/getByColour")
    @ResponseBody
    @Operation(summary = "Поиск по цвету смартфона")
    String getsByColour(@Parameter(description = "Цвет") @RequestParam(value = "colour") String colour) {
        return JsonUtil.writeListToJson(smartphoneService.getSmartphoneRepository().findAllByColourIgnoreCase(colour));
    }

    @RequestMapping("/getBySize")
    @ResponseBody
    @Operation(summary = "Поиск по размеру смартфона")
    String getBySize(@Parameter(description = "Размер") @RequestParam(value = "size") Integer size) {
        return JsonUtil.writeListToJson(smartphoneService.getSmartphoneRepository().findAllBySize(size));
    }

    @RequestMapping("/getByPrice")
    @ResponseBody
    @Operation(summary = "Поиск по цене смартфона")
    String getByPrice(@Parameter(description = "Цена") @RequestParam(value = "price") Integer price) {
        return JsonUtil.writeListToJson(smartphoneService.getSmartphoneRepository().findAllByPrice(price));
    }

    @RequestMapping("/getByCategory")
    @ResponseBody
    @Operation(summary = "Поиск по количеству камер у смартфона")
    String getByCamerasAmount(@Parameter(description = "Количество камер") @RequestParam(value = "camerasAmount") Integer camerasAmount) {
        return JsonUtil.writeListToJson(smartphoneService.getSmartphoneRepository().findAllByCamerasAmount(camerasAmount));
    }

    @RequestMapping("/getByProcessType")
    @ResponseBody
    @Operation(summary = "Поиск по объему памяти смартфона")
    String getByMemoryCapacity(@Parameter(description = "Объем памяти") @RequestParam(value = "memoryCapacity") Integer memoryCapacity) {
        return JsonUtil.writeListToJson(smartphoneService.getSmartphoneRepository().findAllByMemoryCapacity(memoryCapacity));
    }

    @RequestMapping("/getByOnlineOrderAvailability")
    @ResponseBody
    @Operation(summary = "Возможность заказать смартфон онлайн")
    String getByOnlineOrderAvailability(@Parameter(description = "Возможность заказа онлайн true / false") @RequestParam(value = "onlineOrderAvailability") boolean onlineOrderAvailability) {
        return JsonUtil.writeListToJson(smartphoneService.getSmartphoneRepository().findAllByOnlineOrderAvailable(onlineOrderAvailability));
    }

    @RequestMapping("/getByInstallmentAvailability")
    @ResponseBody
    @Operation(summary = "Возможность взять смартфон в рассрочку")
    String getByInstallmentAvailability(@Parameter(description = "Возможность рассрочки true / false") @RequestParam(value = "installmentAvailability") boolean installmentAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(smartphoneService.getSmartphoneRepository().findAllByInstallmentAvailable(installmentAvailability)));
    }

    @RequestMapping("/getByGadgetAvailability")
    @ResponseBody
    @Operation(summary = "Доступность смартфона к покупке")
    String getByGadgetAvailability(@Parameter(description = "Доступность к покупке true / false") @RequestParam(value = "gadgetAvailability") boolean gadgetAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(smartphoneService.getSmartphoneRepository().findAllByGadgetAvailable(gadgetAvailability)));
    }

    @RequestMapping("/addModel")
    @Operation(summary = "Добавление моделей к смартфону", description = "Позволяет добавлять модели к конкретному смартфону, использует ID смартфона и название модели")
    void addModels(@Parameter(description = "ID смартфона") @RequestParam(value = "id") Long id, @Parameter(description = "Название модели") @RequestParam(value = "model") String model) {
        smartphoneService.addModels(id, model);
    }

    @RequestMapping("/addNew")
    @Operation(summary = "Добавление нового смартфона")
    void addNew(@Parameter(description = "Название") @RequestParam(value = "name") String name, @Parameter(description = "Страна") @RequestParam(value = "country") String country, @Parameter(description = "Производитель") @RequestParam(value = "manufacturer") String manufacturer, @Parameter(description = "Серийный номер") @RequestParam(value = "serialNumber") Long serialNumber, @Parameter(description = "Цвет") @RequestParam(value = "colour") String colour, @Parameter(description = "Размер") @RequestParam(value = "size") Integer size,
                @Parameter(description = "Цена") @RequestParam(value = "price") Integer price, @Parameter(description = "Объём памяти") @RequestParam(value = "memoryCapacity") Integer memoryCapacity, @Parameter(description = "Количество камер") @RequestParam(value = "camerasAmount") Integer camerasAmount) {
        smartphoneService.getSmartphoneRepository().save(new Smartphone(name, country, manufacturer, serialNumber, colour, size, price, memoryCapacity, camerasAmount));
    }

    @RequestMapping("/alphabetSorting")
    @ResponseBody
    @Operation(summary = "Сортировка по алфавиту")
    String sortsByAlphabet() {
        List<Smartphone> result = smartphoneService.getSmartphoneRepository().findAll();
        result.sort(new GadgetNameComparator());
        ;
        return JsonUtil.writeListToJson(result);
    }

    @RequestMapping("/priceSorting")
    @ResponseBody
    @Operation(summary = "Сортировка по цене")
    String sortsByPrice() {
        List<Smartphone> result = smartphoneService.getSmartphoneRepository().findAll();
        result.sort(new GadgetPriceComparator());
        ;
        return JsonUtil.writeListToJson(result);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    @Operation(summary = "Возвращает все смартфоны")
    String gets() {
        return JsonUtil.writeListToJson(smartphoneService.getSmartphoneRepository().findAll());
    }


}
