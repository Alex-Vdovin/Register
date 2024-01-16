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


}
