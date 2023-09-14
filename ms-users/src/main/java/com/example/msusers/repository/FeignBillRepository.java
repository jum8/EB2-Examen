package com.example.msusers.repository;

import com.example.msusers.config.feign.FeignInterceptor;
import com.example.msusers.domain.Bill;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ms-bill", configuration = FeignInterceptor.class)
public interface FeignBillRepository {
    @GetMapping("bills/find")
    public List<Bill> getByCustomerId(@RequestParam(name = "customer-id") String customerId);
}
