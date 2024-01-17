package com.RegisterDemo.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Gadget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
//    @ApiModelProperty(value = "Название")
    private String name;
    @NonNull
//    @ApiModelProperty(value = "Страна")
    private String country;
    @NonNull
    @Column(name="manufacturer")
//    @ApiModelProperty(value = "Производитель")
    private String manufacturer;
    @NonNull
    @Column(name="serial_number")
//    @ApiModelProperty(value = "Серийный номер")
    private Long serialNumber;
    @NonNull
//    @ApiModelProperty(value = "Цвет")
    private String colour;
    @NonNull
//    @ApiModelProperty(value = "Размер")
    private Integer size;
    @NonNull
//    @ApiModelProperty(value = "Цена")
    private Integer price;
    @Column(name="online_order_available")
//    @ApiModelProperty(value = "Возможность купить онлайн")
    private boolean onlineOrderAvailable = true;
    @Column(name="installment_available")
//    @ApiModelProperty(value = "Возможность рассрочки")
    private boolean installmentAvailable = true;
    @Column(name="gadget_available")
//    @ApiModelProperty(value = "Наличие товара")
    private boolean gadgetAvailable = true;


}
