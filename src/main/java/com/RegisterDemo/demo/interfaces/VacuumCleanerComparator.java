package com.RegisterDemo.demo.interfaces;

import com.RegisterDemo.demo.entities.VacuumCleaner;

import java.util.Comparator;

public interface VacuumCleanerComparator extends Comparator<VacuumCleaner> {
    @Override
    int compare(VacuumCleaner o1, VacuumCleaner o2);
}
