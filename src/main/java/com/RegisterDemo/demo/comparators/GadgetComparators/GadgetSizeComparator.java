package com.RegisterDemo.demo.comparators.GadgetComparators;

import com.RegisterDemo.demo.entities.Gadget;
import com.RegisterDemo.demo.interfaces.GadgetComparator;

public class GadgetSizeComparator implements GadgetComparator {
    @Override
    public int compare(Gadget o1, Gadget o2) {
        return o1.getSize() - o2.getSize();
    }
}
