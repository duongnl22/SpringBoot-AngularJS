package com.example.duongnl_assignment_java4.request;

import com.example.duongnl_assignment_java4.entity.Account;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductRequest {

    private Long id;

    @NotBlank(message = "Name is required!!!")
    @Length(max = 200 , message = "Name phải nhỏ hơn 200 kí tự!!")
    private String name;

    @NotNull(message = "Size is required!!!")
    @Min(value = 30, message = "Size phải lớn hơn 30!")
    @Max(value = 50 , message = "Size phải nhỏ hơn 50 !!")
    private Integer size;

    @NotBlank(message = "Color is required!!")
    @Length(max = 200 , message = "Color phải nhỏ hơn 200 kí tự!!")
    private String color;

    @NotNull(message = "Price is required!!")
    @DecimalMin(value = "1000" , inclusive = false , message = "Price phải lớn hơn 1000!")
    @DecimalMax(value = "1000000000" , inclusive = true , message = "Price phải nhỏ hơn 1 tỉ")
    private BigDecimal price;

    @NotNull(message = "Quantity is required!!")
    @Min(value = 1, message = "Quantity phải lớn hơn 0!")
    @Max(value = 100000 , message = "Quantity phải nhỏ hơn 100000 !!")
    private Integer quantity;

    @Length(max = 200 , message = "Description phải nhỏ hơn 200 kí tự!!")
    private String description;

    private String createdUser;

    private LocalDateTime createdDate;

    private String lastModifiedUser;

    private LocalDateTime lastModifiedDate;

    private Boolean deleted;


}
