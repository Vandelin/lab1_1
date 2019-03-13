package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount extends Money {
    String discountCause;

    public Discount(String discountCause, BigDecimal discountValue, String currency) {
        super(currency, discountValue);
        this.discountCause = discountCause;
    }

    public Discount(String currency, BigDecimal totalCost) {
        super(currency, totalCost);
    }


    public String getDiscountCause() {
        return discountCause;
    }

    @Override
    public String getCurrency() {
        return super.getCurrency();
    }

    public BigDecimal getDiscountValue() {
        return super.getValue();
    }
}