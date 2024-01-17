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
@Table(name="tvsets")
public class TVSet extends Gadget{
    @NonNull
    @Column
    private String category;
    @NonNull
    @Column
    private String technology;
    @ElementCollection
    @CollectionTable(name="tvset_models", joinColumns = @JoinColumn(name="tvset_id"))
    @Column(name="model")
    private Set<String> modelsAvailableSet;

    public TVSet(@NonNull String name, @NonNull String country, @NonNull String manufacturer, @NonNull Long serialNumber, @NonNull String colour,
                 @NonNull Integer size, @NonNull Integer price, @NonNull String category, @NonNull String technology) {
        super(name, country, manufacturer, serialNumber, colour, size, price);
        this.category = category;
        this.technology = technology;
    }
}
