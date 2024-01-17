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
@Table(name="pc")
public class PC extends Gadget{
    @NonNull
    @Column
    private String category;
    @NonNull
    @Column(name="process_type")
    private String processType;
    @ElementCollection
    @CollectionTable(name="pc_models", joinColumns = @JoinColumn(name="pc_id"))
    @Column(name="model")
    private Set<String> modelsAvailableSet;

    public PC(@NonNull String name, @NonNull String country, @NonNull String manufacturer, @NonNull Long serialNumber, @NonNull String colour,
              @NonNull Integer size, @NonNull Integer price, @NonNull String category, @NonNull String processType) {
        super(name, country, manufacturer, serialNumber, colour, size, price);
        this.category = category;
        this.processType = processType;
    }
}
