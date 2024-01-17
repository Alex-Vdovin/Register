package com.RegisterDemo.demo.comparators.GadgetComparators;

import com.RegisterDemo.demo.entities.Gadget;
import com.RegisterDemo.demo.interfaces.GadgetComparator;

public class GadgetAvailabilityComparator implements GadgetComparator {
    @Override
    public int compare(Gadget o1, Gadget o2) {
        return Boolean.compare(o1.isGadgetAvailable(), o2.isGadgetAvailable());
    }
}
