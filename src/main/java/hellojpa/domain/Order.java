package hellojpa.domain;

import hellojpa.constants.OrderStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    Long id;

    @ManyToOne()
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    OrderStatus status;

    // 양방편의 메서드
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);

    }

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
