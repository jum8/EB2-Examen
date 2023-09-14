package com.msbills.controller;

import com.msbills.models.Bill;
import com.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService service;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_user')")
    public ResponseEntity<List<Bill>> getAll() {
        return ResponseEntity.ok().body(service.getAllBill());
    }

    @GetMapping("{id}")
    public Bill getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping("/find")
    public List<Bill> getByCustomerId(@RequestParam(name = "customer-id") String customerId) {
        return service.getByCustomerId(customerId);
    }

    @PreAuthorize("hasAuthority('GROUP_PROVIDERS')")
    @PostMapping
    public ResponseEntity<String> createBill(@RequestBody Bill bill) {
        return new ResponseEntity<String>(service.create(bill), HttpStatus.CREATED) ;
    }

}
