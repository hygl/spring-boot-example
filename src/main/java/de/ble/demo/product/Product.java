package de.ble.demo.product;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Product {
    private @Id @GeneratedValue Long id;
    private String name;
    private Long quantity;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Product() {}

    public Product(String name, Long quantity, Date date) {
        this.name = name;
        this.quantity = quantity;
        this.date = date;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
               Objects.equals(name, product.name) &&
               Objects.equals(quantity, product.quantity) &&
               Objects.equals(date, product.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, date);
    }

    @Override
    public String toString() {
        return "Product{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", quantity=" + quantity +
               ", date=" + date +
               '}';
    }
}
