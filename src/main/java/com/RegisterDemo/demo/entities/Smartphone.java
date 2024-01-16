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
    @CollectionTable(name="")
    private Set<String> modelsAvailableSet;

}
