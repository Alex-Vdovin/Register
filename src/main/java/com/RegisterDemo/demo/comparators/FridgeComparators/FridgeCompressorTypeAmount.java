package com.RegisterDemo.demo.comparators.FridgeComparators;

import com.RegisterDemo.demo.entities.Fridge;
import com.RegisterDemo.demo.interfaces.FridgeComparator;
import org.apache.commons.lang3.StringUtils;

public class FridgeCompressorTypeAmount implements FridgeComparator {
    @Override
    public int compare(Fridge o1, Fridge o2) {
        return StringUtils.compare(o1.getCompressorType(), o2.getCompressorType());
    }
}
