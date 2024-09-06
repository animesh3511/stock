package com.example.stock.serviceimpl;

import com.example.stock.model.Stock;
import com.example.stock.model.User;
import com.example.stock.model.request.StockRequest;
import com.example.stock.model.request.UserRequest;
import com.example.stock.repository.StockRepository;
import com.example.stock.repository.UserRepository;
import com.example.stock.service.StockService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Object saveOrUpdateStock(StockRequest stockRequest) {

        if (stockRepository.existsById(stockRequest.getId())) {
            Stock stock = stockRepository.findById(stockRequest.getId()).get();
            stock.setIsActive(true);
            stock.setIsDeleted(false);
            saveOrUpdateStockDetails(stock, stockRequest);
            return "Updated";
        } else {
            Stock stock = new Stock();
            stock.setIsActive(true);
            stock.setIsDeleted(false);
            saveOrUpdateStockDetails(stock, stockRequest);
            return "Created";
        }

    }

    private void saveOrUpdateStockDetails(Stock stock, StockRequest stockRequest) {
        stock.setId(stockRequest.getId());
        stock.setPrice(stockRequest.getPrice());
        stock.setPriceDate(stockRequest.getPriceDate());
        stock.setQuantity(stockRequest.getQuantity());
        stock.setStockName(stockRequest.getStockName());
        stock.setVolume(stockRequest.getVolume());
        stockRepository.save(stock);
    }

    @Override
    public Object saveOrUpdateUser(UserRequest userRequest) {

        if (userRepository.existsById(userRequest.getUserId())) {
            User user = userRepository.findById(userRequest.getUserId()).get();
            user.setIsActive(true);
            user.setIsDeleted(false);
            saveOrUpdateUserDetails(user, userRequest);
            return "Updated";
        } else {
            User user = new User();
            user.setIsActive(true);
            user.setIsDeleted(false);
            saveOrUpdateUserDetails(user, userRequest);
            return "Created";
        }

    }


    private void saveOrUpdateUserDetails(User user, UserRequest userRequest) {
        user.setUserId(userRequest.getUserId());
        user.setLocation(userRequest.getLocation());
        user.setPassword(hashPassword(userRequest.getPassword()));
        user.setUserName(userRequest.getUserName());
        userRepository.save(user);
    }


    @Override
    public Object findById(Long id) {
        if (stockRepository.existsByIdAndIsDeleted(id, false)) {
            return stockRepository.findById(id);
        } else {
            return "not found";
        }
    }

    @Override
    public Object deleteById(Long id) {
        if (stockRepository.existsById(id)) {
            stockRepository.deleteById(id);
            return "deleted";
        } else {
            return "not found";
        }
    }

    @Override
    public Object searchByName(String name) {
        if (stockRepository.existsByStockName(name)) {
            return stockRepository.findByStockName(name);
        } else {
            return "Not found";
        }
    }


    public String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }


//class ends here
}
