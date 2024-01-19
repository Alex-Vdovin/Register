package com.RegisterDemo.demo.controllers;

import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetNameComparator;
import com.RegisterDemo.demo.comparators.GadgetComparators.GadgetPriceComparator;
import com.RegisterDemo.demo.entities.TVSet;
import com.RegisterDemo.demo.services.TVSetService;
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
@RequestMapping("/TVSets")
@Tag(name="Контроллер телевизоров", description = "Позволяет работать с таблицей телевизоров")
public class TVSetController {
    @Autowired
    private TVSetService tvSetService;

    @RequestMapping("/getById")
    @ResponseBody
    @Operation(summary = "Поиск телевизора по ID")
    String getById(@Parameter(description = "ID Телевизора") @RequestParam(value = "id") Long id) {
        return JsonUtil.writeEntityToJson(tvSetService.getTvSetRepository().findById(id).get());
    }

    @RequestMapping("/getByName")
    @ResponseBody
    @Operation(summary = "Поиск телевизоров по названию")
    String getByName(@Parameter(description = "Название телевизора")@RequestParam(value = "name") String name) {
        return JsonUtil.writeListToJson(tvSetService.getTvSetRepository().findAllByNameIgnoreCase(name));
    }

    @RequestMapping("/getByCountry")
    @ResponseBody
    @Operation(summary = "Поиск телевизоров по стране")
    String getByCountry(@Parameter(description = "Страна телевизора")@RequestParam(value = "country") String country) {
        return JsonUtil.writeListToJson(tvSetService.getTvSetRepository().findAllByCountryIgnoreCase(country));
    }

    @RequestMapping("/getByManufacturer")
    @ResponseBody
    @Operation(summary = "Поиск телевизоров по производителю")
    String getByManufacturer(@Parameter(description = "Производитель телевизора")@RequestParam(value = "manufacturer") String manufacturer) {
        return JsonUtil.writeListToJson(tvSetService.getTvSetRepository().findAllByManufacturerIgnoreCase(manufacturer));
    }

    @RequestMapping("/getBySerialNumber")
    @ResponseBody
    @Operation(summary = "Поиск телевизоров по серийному номеру")
    String getBySerialNumber(@Parameter(description = "Серийный номер")@RequestParam(value = "serialNumber") Long serialNumber) {
        return JsonUtil.writeEntityToJson(tvSetService.getTvSetRepository().findBySerialNumber(serialNumber).get());
    }

    @RequestMapping("/getByColour")
    @ResponseBody
    @Operation(summary = "Поиск телевизоров по цвету")
    String getsByColour(@Parameter(description = "Цвет")@RequestParam(value = "colour") String colour) {
        return JsonUtil.writeListToJson(tvSetService.getTvSetRepository().findAllByColourIgnoreCase(colour));
    }

    @RequestMapping("/getBySize")
    @ResponseBody
    @Operation(summary = "Поиск телевизоров по размеру")
    String getBySize(@Parameter(description = "Размер")@RequestParam(value = "size") Integer size) {
        return JsonUtil.writeListToJson(tvSetService.getTvSetRepository().findAllBySize(size));
    }

    @RequestMapping("/getByPrice")
    @ResponseBody
    @Operation(summary = "Поиск телевизоров по цене")
    String getByPrice(@Parameter(description = "Цена")@RequestParam(value = "price") Integer price) {
        return JsonUtil.writeListToJson(tvSetService.getTvSetRepository().findAllByPrice(price));
    }

    @RequestMapping("/getByCategory")
    @ResponseBody
    @Operation(summary = "Поиск телевизоров по категории")
    String getByCategory(@Parameter(description = "Категория")@RequestParam(value = "category") String category) {
        return JsonUtil.writeListToJson(tvSetService.getTvSetRepository().findAllByCategoryIgnoreCase(category));
    }

    @RequestMapping("/getByTechnology")
    @ResponseBody
    @Operation(summary = "Поиск телевизоров по технологии экрана")
    String getByTechnology(@Parameter(description = "Технология Экрана")@RequestParam(value = "technology") String technology) {
        return JsonUtil.writeListToJson(tvSetService.getTvSetRepository().findAllByTechnologyIgnoreCase(technology));
    }

    @RequestMapping("/getByOnlineOrderAvailability")
    @ResponseBody
    @Operation(summary = "Возможность заказать телевизор онлайн")
    String getByOnlineOrderAvailability(@RequestParam(value = "onlineOrderAvailability") boolean onlineOrderAvailability) {
        return JsonUtil.writeListToJson(tvSetService.getTvSetRepository().findAllByOnlineOrderAvailable(onlineOrderAvailability));
    }

    @RequestMapping("/getByInstallmentAvailability")
    @ResponseBody
    @Operation(summary = "Возможность взять телевизор в рассрочку")
    String getByInstallmentAvailability(@RequestParam(value = "installmentAvailability") boolean installmentAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(tvSetService.getTvSetRepository().findAllByInstallmentAvailable(installmentAvailability)));
    }

    @RequestMapping("/getByGadgetAvailability")
    @ResponseBody
    @Operation(summary = "Доступность телевизора к покупке")
    String getByGadgetAvailability(@RequestParam(value = "gadgetAvailability") boolean gadgetAvailability) {
        return JsonUtil.writeListToJson(Collections.singletonList(tvSetService.getTvSetRepository().findAllByGadgetAvailable(gadgetAvailability)));
    }

    @RequestMapping("/addModel")
    @Operation(summary = "Добавление моделей к телевизору", description = "Позволяет добавлять модели к конкретному телевизора, использует ID телевизора и название модели")
    void addModels(@Parameter(description = "ID телевизора") @RequestParam(value = "id") Long id, @Parameter(description = "Название модели") @RequestParam(value = "model") String model) {
        tvSetService.addModels(id, model);
    }

    @RequestMapping("/addNew")
    @Operation(summary = "Добавление нового телевизора")
    void addNew(@Parameter(description = "Название телевизора") @RequestParam(value = "name")String name, @Parameter(description = "Страна изготовления телевизора") @RequestParam(value = "country")String country, @Parameter(description = "Производитель") @RequestParam(value = "manufacturer")String manufacturer, @Parameter(description = "Серийный номер") @RequestParam(value = "serialNumber")Long serialNumber, @Parameter(description = "Цвет") @RequestParam(value = "colour")String colour, @Parameter(description = "Размер") @RequestParam(value = "size")Integer size,
                @Parameter(description = "Цена") @RequestParam(value = "price")Integer price, @Parameter(description = "Категория") @RequestParam(value = "category")String category, @Parameter(description = "Технология экрана") @RequestParam(value = "technology")String technology) {
        tvSetService.getTvSetRepository().save(new TVSet(name, country, manufacturer, serialNumber, colour, size, price, category, technology));
    }

    @RequestMapping("/alphabetSorting")
    @ResponseBody
    @Operation(summary = "Сортировка по алфавиту")
    String sortsByAlphabet() {
        List<TVSet> result = tvSetService.getTvSetRepository().findAll();
        result.sort(new GadgetNameComparator());
        ;
        return JsonUtil.writeListToJson(result);
    }

    @RequestMapping("/priceSorting")
    @ResponseBody
    @Operation(summary = "Сортировка по цене")
    String sortsByPrice() {
        List<TVSet> result = tvSetService.getTvSetRepository().findAll();
        result.sort(new GadgetPriceComparator());
        ;
        return JsonUtil.writeListToJson(result);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    @Operation(summary = "Возвращает все телевизоры")
    String gets() {
        return JsonUtil.writeListToJson(tvSetService.getTvSetRepository().findAll());
    }


}
