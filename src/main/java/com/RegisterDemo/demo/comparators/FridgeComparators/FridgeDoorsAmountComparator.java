package com.RegisterDemo.demo.comparators.FridgeComparators;

import com.RegisterDemo.demo.entities.Fridge;
import com.RegisterDemo.demo.interfaces.FridgeComparator;

public class FridgeDoorsAmountComparator implements FridgeComparator {
    @Override
    public int compare(Fridge o1, Fridge o2) {
        return o1.getDoorsAmount() - o2.getDoorsAmount();
    }
}
