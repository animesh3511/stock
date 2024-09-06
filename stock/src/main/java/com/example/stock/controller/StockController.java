package com.example.stock.controller;

import com.example.stock.model.request.StockRequest;
import com.example.stock.model.request.UserRequest;
import com.example.stock.model.response.CustomEntityResponse;
import com.example.stock.model.response.EntityResponse;
import com.example.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/saveOrUpdateStock")
    public ResponseEntity<?> saveOrUpdateStock(@RequestBody StockRequest stockRequest) {
        try {
            return new ResponseEntity<>(new EntityResponse(stockService.saveOrUpdateStock(stockRequest), 0), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/saveOrUpdateUser")
    public ResponseEntity<?> saveOrUpdateUser(@RequestBody UserRequest userRequest) {
        try {
            return new ResponseEntity(new EntityResponse(stockService.saveOrUpdateUser(userRequest), 0), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        try {
            return new ResponseEntity(new EntityResponse(stockService.findById(id), 0), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<?> deleteById(@RequestParam Long id) {
        try {
            return new ResponseEntity(new EntityResponse(stockService.deleteById(id), 0), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/searchByName")
    public ResponseEntity<?> searchByName(@RequestParam String name) {
        try {
            return new ResponseEntity(new EntityResponse(stockService.searchByName(name), 0), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new CustomEntityResponse(e.getMessage(), -1), HttpStatus.BAD_REQUEST);
        }
    }

//class ends here
}
