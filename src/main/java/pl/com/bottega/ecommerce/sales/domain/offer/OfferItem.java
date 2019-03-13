/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class OfferItem {

    public Money money;
    final Product product = new Product();
    final Discount discount = new Discount();
    private int quantity;

    public OfferItem(int quantity, String currency, BigDecimal totalCost) {
        this.quantity = quantity;
        money.setValue(totalCost);
        setCurrency(currency);

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discount.getDiscountValue().setValue(discountValue.subtract(discount.getDiscountValue().getValue()));
        }
        money.setValue(product.getProductPrice().getValue().multiply(new BigDecimal(quantity))
                .subtract(discount.getDiscountValue().getValue()));

    }

    public Money getTotalCost() {
        return money;
    }


    public String getCurrency() {
        return money.getCurrency();
    }

    public void setCurrency(String currency) {
        money.setCurrency(currency);
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OfferItem)) return false;
        OfferItem offerItem = (OfferItem) o;
        return quantity == offerItem.quantity &&
                Objects.equals(product, offerItem.product) &&
                Objects.equals(discount, offerItem.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, product, discount);
    }

    /**
     * @param other
     * @param delta acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (product.getProductPrice() == null) {
            if (other.product.getProductPrice() != null) {
                return false;
            }
        } else if (!product.getProductPrice().equals(other.product.getProductPrice())) {
            return false;
        }
        if (product.getProductName() == null) {
            if (other.product.getProductName() != null) {
                return false;
            }
        } else if (!product.getProductName().equals(other.product.getProductName())) {
            return false;
        }

        if (product.getProductId() == null) {
            if (other.product.getProductId() != null) {
                return false;
            }
        } else if (!product.getProductId().equals(other.product.getProductId())) {
            return false;
        }
        if (product.getProductType() != other.product.getProductType()) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (getTotalCost().getValue().compareTo(other.getTotalCost().getValue()) > 0) {
            max = getTotalCost().getValue();
            min = other.getTotalCost().getValue();
        } else {
            max = other.getTotalCost().getValue();
            min = getTotalCost().getValue();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
