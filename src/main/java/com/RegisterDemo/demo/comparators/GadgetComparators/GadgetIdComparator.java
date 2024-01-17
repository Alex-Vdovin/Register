package com.RegisterDemo.demo.comparators.GadgetComparators;

import com.RegisterDemo.demo.entities.Gadget;
import com.RegisterDemo.demo.interfaces.GadgetComparator;
import org.apache.commons.lang3.StringUtils;

public class GadgetIdComparator implements GadgetComparator {
    @Override
    public int compare(Gadget o1, Gadget o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}
