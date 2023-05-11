package com.example.duongnl_assignment_java4.controller;

import com.example.duongnl_assignment_java4.request.AccountRequest;
import com.example.duongnl_assignment_java4.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
//    private AuthenticationManagerBuilder authenticationManagerBuilder;
    @GetMapping
    public ResponseEntity<List<AccountRequest>> getAll() {
        return accountService.findAll();
    }


//    @PostMapping
//    public ResponseEntity<?> login(@RequestBody AccountRequest accountRequest) throws Exception {
//        authenticationManagerBuilder.inMemoryAuthentication()
//                .withUser(accountRequest.getUserName())
//                .password(accountRequest.getPassword())
//                .roles(String.valueOf(accountRequest.getRole()));
//        System.out.println(accountRequest.getUserName());
//        return ResponseEntity.ok().build();
//    }


}
