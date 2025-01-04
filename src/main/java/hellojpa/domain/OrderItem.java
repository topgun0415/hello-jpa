package hellojpa.domain;

import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    Long id;

    @ManyToOne()
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne()
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    Integer orderPrice;

    Integer count;

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public Item getItem() {
        return item;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setOrder(Order order) {  }
}
