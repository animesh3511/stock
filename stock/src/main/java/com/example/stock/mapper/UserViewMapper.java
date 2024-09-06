package com.example.stock.mapper;

import com.example.stock.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
public class UserViewMapper {


    public UserView toUserView(User user) {

        UserView userView = new UserView();
        userView.setUserId(user.getUserId());
        userView.setUserName(user.getUserName());
        userView.setLocation(user.getLocation());
        userView.setPassword(user.getPassword());
        userView.setIsActive(user.getIsActive());
        userView.setIsDeleted(user.getIsDeleted());
        return userView;

    }



}
