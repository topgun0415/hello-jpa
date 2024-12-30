package hellojpa.domain;

import jakarta.persistence.*;

@Entity
public class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    Long id;

    String name;
    Integer price;
    Integer stockQuantity;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
