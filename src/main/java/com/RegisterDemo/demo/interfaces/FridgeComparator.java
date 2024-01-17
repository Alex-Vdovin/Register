package com.RegisterDemo.demo.interfaces;

import com.RegisterDemo.demo.entities.Fridge;

import java.util.Comparator;

public interface FridgeComparator extends Comparator<Fridge> {
    @Override
    int compare(Fridge o1, Fridge o2);
}
