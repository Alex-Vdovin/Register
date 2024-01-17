package com.RegisterDemo.demo.comparators.PCComparators;

import com.RegisterDemo.demo.entities.PC;
import com.RegisterDemo.demo.interfaces.PCComparator;
import org.apache.commons.lang3.StringUtils;

public class PCProcessTypeComparator implements PCComparator {
    @Override
    public int compare(PC o1, PC o2) {
        return StringUtils.compare(o1.getProcessType(), o2.getProcessType());
    }
}
