package com.RegisterDemo.demo.controllers;

import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetNameComparator;
import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetPriceComparator;
import com.RegisterDemo.demo.entities.Fridge;
import com.RegisterDemo.demo.services.FridgeService;
import com.RegisterDemo.demo.util.JsonUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
    @Autowired
    private FridgeService fridgeService;

    @RequestMapping("/getById")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильника по ID"
    )
    String getById(@Parameter(description = "ID Холодильника") @RequestParam(value = "id") Long id) {
        return JsonUtil.writeEntityToJson(fridgeService.getFridgeRepository().findById(id).get());
    }

    @RequestMapping("/getByName")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильников по названию",
            description = "Возвращает список холодильников с одним названием (можно использовать без учета регистра)"
    )
    String getByName(@Parameter(description = "Название холодильника") @RequestParam(value = "name") String name) {
        return JsonUtil.writeListToJson(fridgeService.getFridgeRepository().findAllByNameIgnoreCase(name));
    }

    @RequestMapping("/getByCountry")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильников по стране",
            description = "Возвращает список холодильников из конкретной страны (можно использовать без учета регистра)"
    )
    String getByCountry(@Parameter(description = "Цвет холодильника")@RequestParam(value = "country") String country) {
        return JsonUtil.writeListToJson(fridgeService.getFridgeRepository().findAllByCountryIgnoreCase(country));
    }

    @RequestMapping("/getByManufacturer")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильников по производителю",
            description = "Возвращает список холодильников от конкретного производителя (можно использовать без учета регистра)"
    )
    String getByManufacturer(@Parameter(description = "Производитель")@RequestParam(value = "manufacturer") String manufacturer) {
        return JsonUtil.writeListToJson(fridgeService.getFridgeRepository().findAllByManufacturerIgnoreCase(manufacturer));
    }

    @RequestMapping("/getBySerialNumber")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильника по серийному номеру"
    )
    String getBySerialNumber(@Parameter(description = "Серийный номер")@RequestParam(value = "serialNumber") Long serialNumber) {
        return JsonUtil.writeEntityToJson(fridgeService.getFridgeRepository().findBySerialNumber(serialNumber).get());
    }

    @RequestMapping("/getByColour")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильника по цвету",
            description = "Возвращает список холодильников конкретного цвета (можно использовать без учета регистра)"
    )
    String getByColour(@Parameter(description = "Цвет")@RequestParam(value = "colour") String colour) {
        return JsonUtil.writeListToJson(fridgeService.getFridgeRepository().findAllByColourIgnoreCase(colour));
    }

    @RequestMapping("/getBySize")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильника по размеру",
            description = "Возвращает список холодильников конкретного размера"
    )
    String getBySize(@Parameter(description = "Размер") @RequestParam(value = "size") Integer size) {
        return JsonUtil.writeListToJson(fridgeService.getFridgeRepository().findAllBySize(size));
    }

    @RequestMapping("/getByPrice")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильника по цене",
            description = "Возвращает список холодильников по конкретной цене"
    )
    String getByPrice(@Parameter(description = "Цена") @RequestParam(value = "price") Integer price) {
        return JsonUtil.writeListToJson(fridgeService.getFridgeRepository().findAllByPrice(price));
    }

    @RequestMapping("/getByDoorsAmount")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильника по количеству дверей",
            description = "Возвращает список холодильников с конкретным количеством дверей"
    )
    String getByDoorsAmount(@Parameter(description = "Количество дверей") @RequestParam(value = "doorsAmount") Integer doorsAmount) {
        return JsonUtil.writeListToJson(fridgeService.getFridgeRepository().findAllByDoorsAmount(doorsAmount));
    }

    @RequestMapping("/getByCompressorType")
    @ResponseBody
    @Operation(
            summary = "Поиск холодильника по типу компрессора",
            description = "Возвращает список холодильников с конкретным типом компрессора"
    )
    String getByCompressorType(@Parameter(description = "Тип компрессора") @RequestParam(value = "compressorType") String compressorType) {
        return JsonUtil.writeListToJson(fridgeService.getFridgeRepository().findAllByCompressorTypeIgnoreCase(compressorType));
    }

    @RequestMapping("/getByOnlineOrderAvailability")
    @ResponseBody
    @Operation(
            summary = "Возможно заказать холодильник онлайн",
            description = "Возвращает список холодильников, которые можно заказать онлайн"
    )
    String getByOnlineOrderAvailability(@Parameter(description = "Возможность заказать холодильник онлайн true / false") @RequestParam(value = "onlineOrderAvailability") boolean onlineOrderAvailability) {
        return JsonUtil.writeListToJson(fridgeService.getFridgeRepository().findAllByOnlineOrderAvailable(onlineOrderAvailability));
    }

    @RequestMapping("/getByInstallmentAvailability")
    @ResponseBody
    @Operation(
            summary = "Возможна рассрочка",
            description = "Возвращает список холодильников, которые можно купить в рассрочку"
    )
    String getByInstallmentAvailability(@Parameter(description = "Возможность рассрочки true / false") @RequestParam(value = "installmentAvailability") boolean installmentAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(fridgeService.getFridgeRepository().findAllByInstallmentAvailable(installmentAvailability)));
    }

    @RequestMapping("/getByGadgetAvailability")
    @ResponseBody
    @Operation(
            summary = "Холодильник доступен к покупке",
            description = "Возвращает список холодильников, которые можно купить"
    )
    String getByGadgetAvailability(@Parameter(description = "Возможность покупки true / false ") @RequestParam(value = "gadgetAvailability") boolean gadgetAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(fridgeService.getFridgeRepository().findAllByGadgetAvailable(gadgetAvailability)));
    }

    @RequestMapping("/addModel")
    @Operation(
            summary = "Добавление моделей",
            description = "Позволяет добавлять модели к конкретному холодильнику, использует ID холодильника и название модели"
    )
    void addModels(@Parameter(description = "ID Холодильника") @RequestParam(value = "id") Long id, @Parameter(description = "Название модели")  @RequestParam(value = "model") String model) {
        fridgeService.addModels(id, model);
    }

    @RequestMapping("/addNew")
    @Operation(
            summary = "Добавление холодильника",
            description = "Позволяет добавить новый холодильник. По умолчанию он будет доступен к покупке, рассрочке и заказу онлайн"
    )
    void addNew(@Parameter(description = "Название холодильника")@RequestParam(value = "name") String name, @Parameter(description = "Страна")@RequestParam(value = "country")String country, @Parameter(description = "Производитель")@RequestParam(value = "manufacturer")String manufacturer, @Parameter(description = "Серийный номер")@RequestParam(value = "serialNumber")Long serialNumber, @Parameter(description = "Цвет")@RequestParam(value = "colour")String colour, @Parameter(description = "Размер")@RequestParam(value = "size")Integer size,
                @Parameter(description = "Цена")@RequestParam(value = "price")Integer price, @Parameter(description = "Количество дверей")@RequestParam(value = "doorsAmount")Integer doorsAmount, @Parameter(description = "Тип компрессора")@RequestParam(value = "compressorType")String compressorType, @Parameter(description = "Возможно заказать холодильник онлайн")@RequestParam(value = "onlineOrderAvailability")boolean onlineOrderAvailability,
                @Parameter(description = "Возможна рассрочка")@RequestParam(value = "installmentAvailability")boolean installmentAvailability, @Parameter(description = "Доступен к покупке")@RequestParam(value = "gadgetAvailability")boolean gadgetAvailability) {
        fridgeService.getFridgeRepository().save(new Fridge(name, country, manufacturer, serialNumber, colour, size, price, doorsAmount,
                compressorType, onlineOrderAvailability, installmentAvailability, gadgetAvailability));
    }

    @RequestMapping("/alphabetSorting")
    @ResponseBody
    @Operation(
            summary = "Сортировка в алфавитном порядке"
    )
    String sortByAlphabet() {
        List<Fridge> result = fridgeService.getFridgeRepository().findAll();
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
        List<Fridge> result = fridgeService.getFridgeRepository().findAll();
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
        return JsonUtil.writeListToJson(fridgeService.getFridgeRepository().findAll());
    }
}
