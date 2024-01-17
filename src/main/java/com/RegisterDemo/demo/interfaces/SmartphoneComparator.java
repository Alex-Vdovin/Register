package com.RegisterDemo.demo.interfaces;

import com.RegisterDemo.demo.entities.Smartphone;

import java.util.Comparator;

public interface SmartphoneComparator extends Comparator<Smartphone> {
    @Override
    int compare(Smartphone o1, Smartphone o2);
}
