package com.example.duongnl_assignment_java4.service.Impl;

import com.example.duongnl_assignment_java4.entity.Account;
import com.example.duongnl_assignment_java4.repository.AccountRepository;
import com.example.duongnl_assignment_java4.request.AccountRequest;
import com.example.duongnl_assignment_java4.service.AccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ResponseEntity<List<AccountRequest>> findAll() {
        List<Account> listAccounts = accountRepository.findAll();

        TypeToken<List<AccountRequest>> typeToken = new TypeToken<>() {
        };

        List<AccountRequest> listAccountRespons = mapper.map(listAccounts, typeToken.getType());

        return ResponseEntity.ok(listAccountRespons);
    }

}
