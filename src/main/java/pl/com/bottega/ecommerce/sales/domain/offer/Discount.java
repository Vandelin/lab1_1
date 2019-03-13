package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount extends Money {
    String discountCause;

    public Discount(String discountCause) {
        this.discountCause = discountCause;
    }

    public Discount() {
    }

    public String getDiscountCause() {
        return discountCause;
    }
}