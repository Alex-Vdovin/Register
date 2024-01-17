package com.RegisterDemo.demo.interfaces;

import com.RegisterDemo.demo.entities.PC;

import java.util.Comparator;

public interface PCComparator extends Comparator<PC> {
    @Override
    int compare(PC o1, PC o2);
}
