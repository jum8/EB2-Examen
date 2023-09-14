package com.example.msusers.dto;

import com.example.msusers.domain.Bill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class UserBills {

    private String id;
    private String username;
    private String firstName;
    private String email;
    private List<Bill> bills;
}
