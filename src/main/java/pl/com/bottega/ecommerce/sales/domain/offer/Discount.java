package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
    private String discountCause;
    private Money money;

    public Discount(String discountCause, BigDecimal discountValue, String currency) {
        money.setValue(discountValue);
        money.setCurrency(currency);
        this.discountCause = discountCause;
    }

    public Discount() { }


    public String getDiscountCause() {
        return discountCause;
    }

    public void setDiscountCause(String discountCause) {
        this.discountCause = discountCause;
    }

    public Money getDiscountValue() {
        return money;
    }

}