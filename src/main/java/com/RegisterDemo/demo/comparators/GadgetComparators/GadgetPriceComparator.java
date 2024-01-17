package com.RegisterDemo.demo.comparators.GadgetComparators;

import com.RegisterDemo.demo.entities.Gadget;
import com.RegisterDemo.demo.interfaces.GadgetComparator;

public class GadgetPriceComparator implements GadgetComparator {
    @Override
    public int compare(Gadget o1, Gadget o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
