package com.example.duongnl_assignment_java4.service;

import com.example.duongnl_assignment_java4.request.AccountRequest;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface AccountService {

   ResponseEntity<List<AccountRequest>> findAll();



}
