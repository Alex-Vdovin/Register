package com.RegisterDemo.demo.comparators.SmartphoneComparators;

import com.RegisterDemo.demo.entities.Smartphone;
import com.RegisterDemo.demo.interfaces.SmartphoneComparator;

public class SmartphoneMemoryCapacityComparator implements SmartphoneComparator {
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getMemoryCapacity() - o2.getMemoryCapacity();
    }
}
