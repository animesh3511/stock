package com.example.stock.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "stockmarket")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Long id;

    @Column(name = "stockname")
    private String stockName;

    @Column(name = "pricedate")
    private LocalDate priceDate;

    @Column(name = "price")
    private String price;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "volume")
    private int volume;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;


}
