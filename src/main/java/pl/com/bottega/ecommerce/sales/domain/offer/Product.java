package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {// product
    private String productId;
    private String productName;
    private Date productSnapshotDate;
    private String productType;
    private Money money;

    public Product(String productId, String productName, Date productSnapshotDate, String productType, BigDecimal productPrice, String currency) {
        money.setCurrency(currency);
        money.setValue(productPrice);
        this.productId = productId;
        this.productName = productName;
        this.productSnapshotDate = productSnapshotDate;
        this.productType = productType;
    }

    public Product() {
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

    public Money getProductPrice() {
        return money;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductSnapshotDate(Date productSnapshotDate) {
        this.productSnapshotDate = productSnapshotDate;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}