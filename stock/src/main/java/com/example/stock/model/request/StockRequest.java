package com.example.stock.model.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StockRequest {

    private Long id;
    private String stockName;
    private LocalDate priceDate;
    private String price;
    private Long quantity;
    private int volume;

}
