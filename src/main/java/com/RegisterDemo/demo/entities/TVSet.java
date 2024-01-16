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
    @CollectionTable(name="")
    private Set<String> modelsAvailableSet;

}
