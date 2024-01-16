package com.RegisterDemo.demo.controllers;

import com.RegisterDemo.demo.entities.Fridge;
import com.RegisterDemo.demo.repositories.FridgeRepository;
import com.RegisterDemo.demo.services.FridgeService;
import com.RegisterDemo.demo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/fridges")
public class FridgeController {
    @Autowired
    private FridgeService fridgeService;
    @Autowired
    private FridgeRepository fridgeRepository;
    @RequestMapping("/getById")
    @ResponseBody
    String getFridgesById(@RequestParam(value = "id") Long id){
        return JsonUtil.writeEntityToJson(fridgeRepository.findById(id).get());
    }
    @RequestMapping("/getByName")
    @ResponseBody
    String getFridgeByName(@RequestParam(value = "name") String name){
        return JsonUtil.writeListToJson(fridgeRepository.findAllByNameIgnoreCase(name));
    }
    @RequestMapping("/getByCountry")
    @ResponseBody
    String getFridgeByCountry(@RequestParam(value = "country") String country){
        return JsonUtil.writeListToJson(fridgeRepository.findAllByCountryIgnoreCase(country));
    }
    @RequestMapping("/getByManufacturer")
    @ResponseBody
    String getFridgeByManufacturer(@RequestParam(value = "manufacturer") String manufacturer){
        return JsonUtil.writeListToJson(fridgeRepository.findAllByManufacturerIgnoreCase(manufacturer));
    }
    @RequestMapping("/getBySerialNumber")
    @ResponseBody
    String getFridgeBySerialNumber(@RequestParam(value = "serialNumber") Long serialNumber){
        return JsonUtil.writeEntityToJson(fridgeRepository.findBySerialNumber(serialNumber).get());
    }
    @RequestMapping("/getByColour")
    @ResponseBody
    String getFridgesByColour(@RequestParam(value = "colour") String colour){
        return JsonUtil.writeListToJson(fridgeRepository.findAllByColourIgnoreCase(colour));
    }
    @RequestMapping("/getBySize")
    @ResponseBody
    String getFridgeBySize(@RequestParam(value = "size") Integer size){
        return JsonUtil.writeListToJson(fridgeRepository.findAllBySize(size));
    }
    @RequestMapping("/getByPrice")
    @ResponseBody
    String getFridgeByPrice(@RequestParam(value = "price") Integer price){
        return JsonUtil.writeListToJson(fridgeRepository.findAllByPrice(price));
    }
    @RequestMapping("/getByDoorsAmount")
    @ResponseBody
    String getFridgeByDoorsAmount(@RequestParam(value = "doorsAmount") Integer doorsAmount){
        return JsonUtil.writeListToJson(fridgeRepository.findAllByDoorsAmount(doorsAmount));
    }
    @RequestMapping("/getByCompressorType")
    @ResponseBody
    String getFridgeByCompressorType(@RequestParam(value = "compressorType") String compressorType){
        return JsonUtil.writeListToJson(fridgeRepository.findAllByCompressorTypeIgnoreCase(compressorType));
    }
    @RequestMapping("/getByOnlineOrderAvailability")
    @ResponseBody
    String getFridgeByOnlineOrderAvailability(@RequestParam(value = "onlineOrderAvailability") boolean onlineOrderAvailability){
        return JsonUtil.writeListToJson(fridgeRepository.findAllByOnlineOrderAvailability(onlineOrderAvailability));
    }
    @RequestMapping("/getByInstallmentAvailability")
    @ResponseBody
    String getFridgeByInstallmentAvailability(@RequestParam(value = "installmentAvailability") boolean installmentAvailability){
        return JsonUtil.writeListToJson(Collections.singletonList(fridgeRepository.findAllByInstallmentAvailability(installmentAvailability)));
    }
    @RequestMapping("/getByGadgetAvailability")
    @ResponseBody
    String getFridgeByGadgetAvailability(@RequestParam(value = "gadgetAvailability") boolean gadgetAvailability){
        return JsonUtil.writeListToJson(Collections.singletonList(fridgeRepository.findAllByGadgetAvailability(gadgetAvailability)));
    }
    @RequestMapping("/addModel")
    void addFridgeModels(@RequestParam(value = "id") Long id, @RequestParam(value = "model") String model){
        fridgeService.addModels(id, model);
    }
    @RequestMapping("/addNew")
    void addNewFridge(String name, String country, String manufacturer, Long serialNumber, String colour, Integer size,
                      Integer price, Integer doorsAmount, String compressorType, boolean onlineOrderAvailability,
                      boolean installmentAvailability, boolean gadgetAvailability){
        fridgeRepository.save(new Fridge(name, country, manufacturer, serialNumber, colour, size, price, doorsAmount,
                compressorType, onlineOrderAvailability, installmentAvailability, gadgetAvailability));
    }
}
