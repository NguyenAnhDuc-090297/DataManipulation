package com.lifesup.jpadata.service;

public interface DispenseChain {

    void setNextChain(DispenseChain nextChain);

    void dispense(Integer amount);
}
