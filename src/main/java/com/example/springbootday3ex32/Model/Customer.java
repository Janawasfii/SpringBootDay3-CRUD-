package com.example.springbootday3ex32.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String id;
    private String userName;
    private double balance;

}
