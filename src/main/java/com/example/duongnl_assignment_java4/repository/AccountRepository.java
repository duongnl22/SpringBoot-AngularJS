package com.example.duongnl_assignment_java4.repository;

import com.example.duongnl_assignment_java4.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUserName(String userName);
}
