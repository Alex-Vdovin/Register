package com.RegisterDemo.demo.util;
import com.RegisterDemo.demo.entities.Gadget;
import com.google.gson.GsonBuilder;


import java.util.List;

public class JsonUtil {
    private JsonUtil() {
    }
    public static String writeListToJson(List<?> list){
        return new GsonBuilder().setPrettyPrinting().create().toJson(list);
    }
    public static String writeEntityToJson(Gadget gadget){
        return new GsonBuilder().setPrettyPrinting().create().toJson(gadget);
    }
}
