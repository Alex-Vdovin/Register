package com.RegisterDemo.demo.comparators.VacuumCleanerComparators;

import com.RegisterDemo.demo.entities.VacuumCleaner;
import com.RegisterDemo.demo.interfaces.VacuumCleanerComparator;

public class VacuumCleanerDustBoxCapacityComparator implements VacuumCleanerComparator {
    @Override
    public int compare(VacuumCleaner o1, VacuumCleaner o2) {
        return o1.getDustBoxCapacity() - o2.getDustBoxCapacity();
    }
}
