package com.example.msusers.service;

import com.example.msusers.domain.Bill;
import com.example.msusers.domain.User;
import com.example.msusers.dto.UserBills;
import com.example.msusers.repository.BillRepository;
import com.example.msusers.repository.KeycloakRepository;
import com.example.msusers.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private KeycloakRepository keycloakRepository;
    private BillRepository billRepository;

    public UserService(KeycloakRepository keycloakRepository, BillRepository billRepository) {
        this.keycloakRepository = keycloakRepository;
        this.billRepository = billRepository;
    }

    public List<User> findAll() {
        return keycloakRepository.findAll();
    }


    public User findById(String id) {
        return keycloakRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public UserBills findUserBillsByUserId(String id) {
        User user = keycloakRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        List<Bill> bills = billRepository.getBillsByCustomerBill(id);


        return UserBills.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .bills(bills).build();
    }


}
