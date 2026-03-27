package com.bank;

import java.time.LocalDateTime;
import java.util.*;

public class Account {
    private final String id;
    private Amount balance;
    private final List<Transaction> history = new ArrayList<>();

    public Account(String id, Amount initial) {
        this.id = id;
        this.balance = initial;
        record("OPENING", initial);
    }

    public void deposit(Amount amount) {
        this.balance = this.balance.add(amount);
        record("DEPOSIT", amount);
    }

    public void withdraw(Amount amount) {
        if (this.balance.isLessThan(amount)) throw new RuntimeException("残高不足");
        this.balance = this.balance.subtract(amount);
        record("WITHDRAW", amount);
    }

    private void record(String type, Amount amt) {
        history.add(new Transaction(LocalDateTime.now(), type, amt, this.balance));
    }

    public void printHistory() {
        System.out.println("--- Account: " + id + " ---");
        history.forEach(System.out::println);
    }
}
