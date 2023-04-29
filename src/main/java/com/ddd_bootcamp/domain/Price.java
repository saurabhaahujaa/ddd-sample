package com.ddd_bootcamp.domain;

import java.math.BigDecimal;
import java.util.Currency;

public class Price {
    private BigDecimal value;
    private Currency currency;

    public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Price(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        if (!value.equals(price.value)) return false;
        return currency.equals(price.currency);
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + currency.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                ", currency=" + currency +
                '}';
    }

	public Price reduceByPercent(int percentage) {
	        return new Price(value.subtract(value.divide(new BigDecimal(percentage))), Currency.getInstance("USD"));
	    }
	}