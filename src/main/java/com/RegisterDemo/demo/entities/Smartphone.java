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
@NoArgsConstructor
@Table(name="smartphones")
public class Smartphone extends Gadget{
    @NonNull
    @Column(name="memory_capacity")
    private Integer memoryCapacity;
    @NonNull
    @Column(name="cameras_amount")
    private Integer camerasAmount;
    @ElementCollection
    @CollectionTable(name="smartphone_models", joinColumns = @JoinColumn(name="smartphone_id"))
    @Column(name="model")
    private Set<String> modelsAvailableSet;

    public Smartphone(@NonNull String name, @NonNull String country, @NonNull String manufacturer,
                      @NonNull Long serialNumber, @NonNull String colour, @NonNull Integer size,
                      @NonNull Integer price, @NonNull Integer memoryCapacity, @NonNull Integer camerasAmount) {
        super(name, country, manufacturer, serialNumber, colour, size, price);
        this.memoryCapacity = memoryCapacity;
        this.camerasAmount = camerasAmount;
    }
}
