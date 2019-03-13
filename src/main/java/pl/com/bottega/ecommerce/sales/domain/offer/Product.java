package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;

public class Product extends Money {// product
    String productId;
    String productName;
    Date productSnapshotDate;
    String productType;

    public Product(String productId, String productName, Date productSnapshotDate, String productType) {
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


}