package com.lifesup.jpadata.service;

import com.lifesup.jpadata.dto.response.DispenseResponse;
import com.lifesup.jpadata.dto.response.ApiResponse;
import com.lifesup.jpadata.exception.DispenseException;
import com.lifesup.jpadata.service.impl.Dollar10Dispenser;
import com.lifesup.jpadata.service.impl.Dollar20Dispenser;
import com.lifesup.jpadata.service.impl.Dollar50Dispenser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ATMDispenseService {

    public DispenseResponse dispense(Integer amount) {
        if (amount % 10 != 0) {
            log.error("Amount should be in multiple of 10s.");
            throw new DispenseException("Amount should be in multiple of 10s.");
        }
        // initialize the chain
        DispenseResponse data = new DispenseResponse();
        DispenseChain chain1 = new Dollar50Dispenser(data);
        DispenseChain chain2 = new Dollar20Dispenser(data);
        DispenseChain chain3 = new Dollar10Dispenser(data);

        // set the chain of responsibility
        chain1.setNextChain(chain2);
        chain2.setNextChain(chain3);

        Thread t1 = new Thread();

        t1.start();

        new Thread(() -> {
            System.out.println(1);
        }).start();



        // handle
        chain1.dispense(amount);

        return data;
    }
}
