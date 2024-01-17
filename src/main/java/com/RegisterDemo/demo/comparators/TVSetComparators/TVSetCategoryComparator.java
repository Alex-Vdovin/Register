package com.RegisterDemo.demo.comparators.TVSetComparators;

import com.RegisterDemo.demo.entities.TVSet;
import com.RegisterDemo.demo.interfaces.TVSetComparator;
import org.apache.commons.lang3.StringUtils;

public class TVSetCategoryComparator implements TVSetComparator {
    @Override
    public int compare(TVSet o1, TVSet o2) {
        return StringUtils.compare(o1.getCategory(), o2.getCategory());
    }
}
