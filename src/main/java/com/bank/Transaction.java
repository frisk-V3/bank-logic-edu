package com.bank;

import java.time.LocalDateTime;

public record Transaction(LocalDateTime time, String type, Amount amount, Amount balance) {
    @Override
    public String toString() {
        return String.format("[%s] %-10s : %12s (残高: %12s)", time, type, amount, balance);
    }
}
