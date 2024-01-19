package com.RegisterDemo.demo.controllers;

import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetNameComparator;
import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetPriceComparator;
import com.RegisterDemo.demo.entities.PC;
import com.RegisterDemo.demo.services.PCService;
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
@RequestMapping("/PC")
@Tag(name="Контроллер ПК", description = "Позволяет работать с таблицей ПК")
public class PCController {
    @Autowired
    private PCService pcService;

    @RequestMapping("/getById")
    @ResponseBody
    @Operation(summary = "Поиск PC по ID")
    String getsById(@Parameter(description = "ID PC") @RequestParam(value = "id") Long id) {
        return JsonUtil.writeEntityToJson(pcService.getPcRepository().findById(id).get());
    }

    @RequestMapping("/getByName")
    @ResponseBody
    @Operation(summary = "Поиск PC по названию")
    String getByName(@Parameter(description = "Название") @RequestParam(value = "name") String name) {
        return JsonUtil.writeListToJson(pcService.getPcRepository().findAllByNameIgnoreCase(name));
    }

    @RequestMapping("/getByCountry")
    @ResponseBody
    @Operation(summary = "Поиск PC по стране")
    String getByCountry(@Parameter(description = "Страна") @RequestParam(value = "country") String country) {
        return JsonUtil.writeListToJson(pcService.getPcRepository().findAllByCountryIgnoreCase(country));
    }

    @RequestMapping("/getByManufacturer")
    @ResponseBody
    @Operation(summary = "Поиск PC по производителю")
    String getByManufacturer(@Parameter(description = "Производитель") @RequestParam(value = "manufacturer") String manufacturer) {
        return JsonUtil.writeListToJson(pcService.getPcRepository().findAllByManufacturerIgnoreCase(manufacturer));
    }

    @RequestMapping("/getBySerialNumber")
    @ResponseBody
    @Operation(summary = "Поиск PC по серийному номеру")
    String getBySerialNumber(@Parameter(description = "Серийный номер") @RequestParam(value = "serialNumber") Long serialNumber) {
        return JsonUtil.writeEntityToJson(pcService.getPcRepository().findBySerialNumber(serialNumber).get());
    }

    @RequestMapping("/getByColour")
    @ResponseBody
    @Operation(summary = "Поиск PC по цвету")
    String getsByColour(@Parameter(description = "Цвет") @RequestParam(value = "colour") String colour) {
        return JsonUtil.writeListToJson(pcService.getPcRepository().findAllByColourIgnoreCase(colour));
    }

    @RequestMapping("/getBySize")
    @ResponseBody
    @Operation(summary = "Поиск PC по размеру")
    String getBySize(@Parameter(description = "Название") @RequestParam(value = "size") Integer size) {
        return JsonUtil.writeListToJson(pcService.getPcRepository().findAllBySize(size));
    }

    @RequestMapping("/getByPrice")
    @ResponseBody
    @Operation(summary = "Поиск PC по цене")
    String getByPrice(@Parameter(description = "Цена") @RequestParam(value = "price") Integer price) {
        return JsonUtil.writeListToJson(pcService.getPcRepository().findAllByPrice(price));
    }

    @RequestMapping("/getByCategory")
    @ResponseBody
    @Operation(summary = "Поиск PC по категории")
    String getByDoorsAmount(@Parameter(description = "Категория") @RequestParam(value = "category") String category) {
        return JsonUtil.writeListToJson(pcService.getPcRepository().findAllByCategoryIgnoreCase(category));
    }

    @RequestMapping("/getByProcessType")
    @ResponseBody
    @Operation(summary = "Поиск PC по типу процессора")
    String getByCompressorType(@Parameter(description = "Тип процессора") @RequestParam(value = "processType") String processType) {
        return JsonUtil.writeListToJson(pcService.getPcRepository().findAllByProcessTypeIgnoreCase(processType));
    }

    @RequestMapping("/getByOnlineOrderAvailability")
    @ResponseBody
    @Operation(summary = "Возможность покупки онлайн")
    String getByOnlineOrderAvailability(@Parameter(description = "Возможность покупки онлайн true / false") @RequestParam(value = "onlineOrderAvailability") boolean onlineOrderAvailability) {
        return JsonUtil.writeListToJson(pcService.getPcRepository().findAllByOnlineOrderAvailable(onlineOrderAvailability));
    }

    @RequestMapping("/getByInstallmentAvailability")
    @ResponseBody
    @Operation(summary = "Возможность рассрочки")
    String getByInstallmentAvailability(@Parameter(description = "Возможность рассрочки true / false") @RequestParam(value = "installmentAvailability") boolean installmentAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(pcService.getPcRepository().findAllByInstallmentAvailable(installmentAvailability)));
    }

    @RequestMapping("/getByGadgetAvailability")
    @ResponseBody
    @Operation(summary = "Доступность к покупке")
    String getByGadgetAvailability(@Parameter(description = "Доступность к покупке true / false") @RequestParam(value = "gadgetAvailability") boolean gadgetAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(pcService.getPcRepository().findAllByGadgetAvailable(gadgetAvailability)));
    }

    @RequestMapping("/addModel")
    @Operation(summary = "Добавление моделей к PC", description = "Позволяет добавлять модели к конкретному PC, использует ID PC и название модели")
    void addModels(@Parameter(description = "ID PC, к которому будут добавлять модели")@RequestParam(value = "id") Long id, @Parameter(description = "Модель")@RequestParam(value = "model") String model) {
        pcService.addModels(id, model);
    }

    @RequestMapping("/addNew")
    @Operation(summary = "Добавление нового PC",
    description = "Позволяет добавлять новый PC в таблицу")
    void addNew(@Parameter(description = "Название PC")@RequestParam(value = "name") String name, @Parameter(description = "Страна") @RequestParam(value = "country")  String country, @Parameter(description = "Производитель") @RequestParam(value = "manufacturer") String manufacturer, @Parameter(description = "Серийный номер") @RequestParam(value = "serialNumber")  Long serialNumber, @Parameter(description = "Цвет") @RequestParam(value = "colour")  String colour, @Parameter(description = "Размер") @RequestParam(value = "size")  Integer size,
                @Parameter(description = "Цена") @RequestParam(value = "price")  Integer price, @Parameter(description = "Категория") @RequestParam(value = "category")  String category, @Parameter(description = "Тип процессора") @RequestParam(value = "processType")  String processType) {
        pcService.getPcRepository().save(new PC(name, country, manufacturer, serialNumber, colour, size, price, category, processType));
    }

    @RequestMapping("/alphabetSorting")
    @ResponseBody
    @Operation(summary = "Сортировка по алфавиту")
    String sortsByAlphabet() {
        List<PC> result = pcService.getPcRepository().findAll();
        result.sort(new GadgetNameComparator());
        ;
        return JsonUtil.writeListToJson(result);
    }

    @RequestMapping("/priceSorting")
    @ResponseBody
    @Operation(summary = "Сортировка по цене")
    String sortsByPrice() {
        List<PC> result = pcService.getPcRepository().findAll();
        result.sort(new GadgetPriceComparator());
        ;
        return JsonUtil.writeListToJson(result);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    @Operation(summary = "Возвращает все PC в таблице")
    String gets() {
        return JsonUtil.writeListToJson(pcService.getPcRepository().findAll());
    }


}
