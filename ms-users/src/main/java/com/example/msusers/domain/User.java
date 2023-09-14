package com.example.msusers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class User {
    private String id;
    private String username;
    private String firstName;
    private String email;

}
