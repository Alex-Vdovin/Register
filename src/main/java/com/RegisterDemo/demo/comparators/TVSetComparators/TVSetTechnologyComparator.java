package com.RegisterDemo.demo.comparators.TVSetComparators;

import com.RegisterDemo.demo.entities.TVSet;
import com.RegisterDemo.demo.interfaces.TVSetComparator;
import org.apache.commons.lang3.StringUtils;

public class TVSetTechnologyComparator implements TVSetComparator {
    @Override
    public int compare(TVSet o1, TVSet o2) {
        return StringUtils.compare(o1.getTechnology(), o2.getTechnology());
    }
}
