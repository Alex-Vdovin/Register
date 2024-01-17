package com.RegisterDemo.demo.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@Table(name="fridges")
@NoArgsConstructor
public class Fridge extends Gadget{

    @NonNull
    @Column(name="doors_amount")
    private Integer doorsAmount;
    @NonNull
    @Column(name="compressor_type")
    private String compressorType;
    @ElementCollection
    @CollectionTable(name="fridge_models", joinColumns = @JoinColumn(name="fridge_id"))
    @Column(name="model")
    private Set<String> modelsAvailableSet;

    public Fridge(@NonNull String name, @NonNull String country, @NonNull String manufacturer, @NonNull Long serialNumber, @NonNull String colour, @NonNull Integer size, @NonNull Integer price, @NonNull Integer doorsAmount, @NonNull String compressorType, Set<String> modelsAvailableSet) {
        super(name, country, manufacturer, serialNumber, colour, size, price);
        this.doorsAmount = doorsAmount;
        this.compressorType = compressorType;
    }

    public Fridge(String name, String country, String manufacturer, Long serialNumber, String colour, Integer size, Integer price, Integer doorsAmount, String compressorType, boolean onlineOrderAvailability, boolean installmentAvailability, boolean gadgetAvailability) {
    }
}
