package com.bank;

import java.math.BigDecimal;

public class BankApp {
    public static void main(String[] args) {
        Account taro = new Account("TARO-001", new Amount(new BigDecimal("100000")));
        Account hanako = new Account("HANA-002", new Amount(new BigDecimal("50000")));
        
        TransferService service = new TransferService();
        
        try {
            service.transfer(taro, hanako, new Amount(new BigDecimal("30000")));
            taro.printHistory();
            hanako.printHistory();
        } catch (Exception e) {
            System.err.println("エラー: " + e.getMessage());
        }
    }
}
