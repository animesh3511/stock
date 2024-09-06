package com.example.stock.service;

import com.example.stock.model.request.StockRequest;
import com.example.stock.model.request.UserRequest;

public interface StockService {


    Object saveOrUpdateStock(StockRequest stockRequest);

    Object saveOrUpdateUser(UserRequest userRequest);

    Object findById(Long id);

    Object deleteById(Long id);

    Object searchByName(String name);
}
