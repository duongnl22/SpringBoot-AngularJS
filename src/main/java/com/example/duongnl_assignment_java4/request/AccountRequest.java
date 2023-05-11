package com.example.duongnl_assignment_java4.request;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountRequest {


    private Long id;

    private String userName;

    private String password;

    private String name;

    private Integer role;
}
