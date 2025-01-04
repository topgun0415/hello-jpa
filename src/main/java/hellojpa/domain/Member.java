package hellojpa.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

   @Id
   @GeneratedValue
   @Column(name = "MEMBER_ID")
   private Long id;
   private String name;
   private String city;
   private String street;
   private String zipcode;

   // 양방향매핑이 그닥 좋은것은 아니다. 되도록이면 단방향으로 매핑을 한 후 나중에 꼭 필요할 경우에만 양방향 매핑으로 이어줄것.
   @OneToMany
   // 상품주문리스트
   private List<Order> orders = new ArrayList<>();

   public Long getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public String getCity() {
      return city;
   }

   public String getStreet() {
      return street;
   }

   public String getZipcode() {
      return zipcode;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public void setStreet(String street) {
      this.street = street;
   }

   public void setZipcode(String zipcode) {
      this.zipcode = zipcode;
   }
}
