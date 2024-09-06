package com.example.stock.repository;

import com.example.stock.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    //boolean existsByIdIsDeleted(Long id, boolean b);

    boolean existsByStockName(String name);

    List<Stock> findByStockName(String name);

    boolean existsByIdAndIsDeleted(Long id, boolean b);
}
