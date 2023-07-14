package com.lifesup.jpadata.controller;

import com.lifesup.jpadata.dto.response.ApiResponse;
import com.lifesup.jpadata.exception.DispenseException;
import com.lifesup.jpadata.service.ATMDispenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atm")
public class ATMDispenseController {

    private final ATMDispenseService atmDispenseService;

    public ATMDispenseController(ATMDispenseService atmDispenseService) {
        this.atmDispenseService = atmDispenseService;
    }

    @GetMapping("/get-money")
    public ResponseEntity<?> getMoneyFromATM (@RequestParam Integer amount) {
        return ResponseEntity.ok(new ApiResponse<>(200, "ok", atmDispenseService.dispense(amount)));
    }
}
