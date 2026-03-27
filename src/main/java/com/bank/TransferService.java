package com.bank;

public class TransferService {
    public void transfer(Account from, Account to, Amount amount) {
        // 本来はここでDBトランザクションを開始する
        from.withdraw(amount);
        to.deposit(amount);
        System.out.println(">> 振込完了: " + amount);
    }
}
