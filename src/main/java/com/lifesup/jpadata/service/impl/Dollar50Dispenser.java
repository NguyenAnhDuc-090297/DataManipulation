package com.lifesup.jpadata.service.impl;

import com.lifesup.jpadata.dto.response.DispenseResponse;
import com.lifesup.jpadata.service.DispenseChain;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dollar50Dispenser implements DispenseChain {

    private DispenseChain chain;
    private final DispenseResponse response;

    public Dollar50Dispenser(DispenseResponse response) {
        this.response = response;
    }

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Integer amount) {
        if (amount >= 50) {
            int num = amount / 50;
            int remainder = amount % 50;
            response.increment50Count(num);
            log.info("Dispensing " + num + " 50$ note.");
            if (remainder != 0) {
                this.chain.dispense(remainder);
            }
        } else {
            this.chain.dispense(amount);
        }
    }
}
