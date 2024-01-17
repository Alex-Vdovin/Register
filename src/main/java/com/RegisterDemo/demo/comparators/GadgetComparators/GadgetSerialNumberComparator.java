package com.RegisterDemo.demo.comparators.GadgetComparators;

import com.RegisterDemo.demo.entities.Gadget;
import com.RegisterDemo.demo.interfaces.GadgetComparator;

public class GadgetSerialNumberComparator implements GadgetComparator {
    @Override
    public int compare(Gadget o1, Gadget o2) {
        return Long.compare(o1.getSerialNumber(), o2.getSerialNumber());
    }
}
