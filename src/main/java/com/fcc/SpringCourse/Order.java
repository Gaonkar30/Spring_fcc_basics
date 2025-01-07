package com.fcc.SpringCourse;

public class Order {
    private String CustomerName;
    private String ProductName;
    private int Quantity;

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "CustomerName='" + CustomerName + '\'' +
                ", ProductName='" + ProductName + '\'' +
                ", Quantity=" + Quantity +
                '}';
    }
}
