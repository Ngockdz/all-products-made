package assgiment.ass.Staff;

import java.math.BigDecimal;

import assgiment.ass.Model.Product;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem() {
        // Constructor mặc định cho mục đích serialization
    }

    public CartItem(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        this.product = product;
        this.quantity = quantity;
    }

    // Getter và Setter
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        if (product == null) {
            throw new IllegalStateException("Product is not initialized");
        }
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        
        if (product == null || cartItem.product == null) {
            return false;
        }
        
        return product.getId() == cartItem.product.getId();
    }

    @Override
    public int hashCode() {
        return product != null ? Long.hashCode(product.getId()) : 0;
    }
}