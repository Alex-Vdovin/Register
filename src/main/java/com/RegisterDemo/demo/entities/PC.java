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
    @CollectionTable(name="")
    private Set<String> modelsAvailableSet;

}
