package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product extends Money {// product
    String productId;
    String productName;
    Date productSnapshotDate;
    String productType;

    public Product(String productId, String productName, Date productSnapshotDate, String productType, BigDecimal productPrice, String currency) {
        super(currency, productPrice);
        this.productId = productId;
        this.productName = productName;
        this.productSnapshotDate = productSnapshotDate;
        this.productType = productType;
    }

    public Product(String currency, BigDecimal value) {
        super(currency, value);
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public String getProductType() {
        return productType;
    }

    @Override
    public String getCurrency() {
        return super.getCurrency();
    }

    public BigDecimal getProductPrice() {
        return super.getValue();
    }
}