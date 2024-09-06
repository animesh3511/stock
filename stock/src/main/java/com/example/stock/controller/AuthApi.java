package com.example.stock.controller;

import com.example.stock.mapper.UserViewMapper;
import com.example.stock.model.User;
import com.example.stock.model.request.AuthRequest;
import com.example.stock.serviceimpl.UserDetailsImpl;
import com.example.stock.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthApi {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserViewMapper userViewMapper;



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {

        try {

            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                    (authRequest.getUserName(), authRequest.getPassword()));
            UserDetailsImpl userDetails = (UserDetailsImpl) authenticate.getPrincipal();
            //User user = (User) authenticate.getPrincipal();
            //String userName=user.getUserName();
            User user = userDetails.getUser();
            String userName = user.getUserName();
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, jwtTokenUtil.generateToken(userName))
                    .body(userViewMapper.toUserView(user));
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }

}
