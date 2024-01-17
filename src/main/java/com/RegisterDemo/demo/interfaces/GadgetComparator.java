package com.RegisterDemo.demo.interfaces;

import com.RegisterDemo.demo.entities.Gadget;

import java.util.Comparator;

public interface GadgetComparator extends Comparator<Gadget> {
    @Override
    int compare(Gadget o1, Gadget o2);
}
