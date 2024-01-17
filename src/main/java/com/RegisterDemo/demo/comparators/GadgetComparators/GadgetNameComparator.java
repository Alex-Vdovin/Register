package com.RegisterDemo.demo.comparators.GadgetComparators;

import com.RegisterDemo.demo.entities.Gadget;
import com.RegisterDemo.demo.interfaces.GadgetComparator;
import org.apache.commons.lang3.StringUtils;

public class GadgetNameComparator implements GadgetComparator {
    @Override
    public int compare(Gadget o1, Gadget o2) {
        return StringUtils.compare(o1.getName(), o2.getName());
    }
}
