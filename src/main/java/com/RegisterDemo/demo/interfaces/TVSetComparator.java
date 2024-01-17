package com.RegisterDemo.demo.interfaces;

import com.RegisterDemo.demo.entities.TVSet;

import java.util.Comparator;

public interface TVSetComparator extends Comparator<TVSet> {
    @Override
    int compare(TVSet o1, TVSet o2);
}
