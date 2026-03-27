package com.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record Amount(BigDecimal value) {
    public static final Amount ZERO = new Amount(BigDecimal.ZERO);

    public Amount {
        if (value == null || value.signum() < 0) throw new IllegalArgumentException("金額は0以上");
        value = value.setScale(0, RoundingMode.DOWN); // 円単位
    }

    public Amount add(Amount other) { return new Amount(this.value.add(other.value)); }
    public Amount subtract(Amount other) { return new Amount(this.value.subtract(other.value)); }
    public boolean isLessThan(Amount other) { return this.value.compareTo(other.value) < 0; }
    
    @Override
    public String toString() { return String.format("%,d JPY", value.toLongExact()); }
}
