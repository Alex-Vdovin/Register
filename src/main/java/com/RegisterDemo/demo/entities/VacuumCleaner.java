package com.RegisterDemo.demo.entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
@Table(name="vacuum_cleaners")
@NoArgsConstructor
public class VacuumCleaner extends Gadget{
    @NonNull
    @Column(name = "dust_box_capacity")
    private Integer dustBoxCapacity;
    @NonNull
    @Column(name = "modes_amount")
    private Integer modesAmount;
    @ElementCollection
    @CollectionTable(name="vacuum_cleaner_models", joinColumns = @JoinColumn(name="vacuum_cleaner_id"))
    @Column(name="model")
    private Set<String> modelsAvailableSet;

    public VacuumCleaner(@NonNull String name, @NonNull String country, @NonNull String manufacturer, @NonNull Long serialNumber, @NonNull String colour, @NonNull Integer size, @NonNull Integer price, @NonNull Integer dustBoxCapacity, @NonNull Integer modesAmount) {
        super(name, country, manufacturer, serialNumber, colour, size, price);
        this.dustBoxCapacity = dustBoxCapacity;
        this.modesAmount = modesAmount;
    }
}
