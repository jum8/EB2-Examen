package com.msbills.service;

import com.msbills.models.Bill;
import com.msbills.repositories.BillRepository;
import com.msbills.util.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository repository;

    public List<Bill> getAllBill() {
        return repository.findAll();
    }

    public Bill getById(String id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public List<Bill> getByCustomerId(String customerId) {
        return repository.getByCustomerBill(customerId);
    }

    public String create(final Bill bill) {
        return repository.save(bill).getIdBill();
    }

}
