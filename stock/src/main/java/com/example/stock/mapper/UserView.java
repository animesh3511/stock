package com.example.stock.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserView {


    private Long userId;
    private String userName;
    private String location;
    private String password;
    private Boolean isActive;
    private Boolean isDeleted;




}
