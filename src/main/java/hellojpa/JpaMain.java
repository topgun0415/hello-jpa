package hellojpa;

import hellojpa.domain.Member;
import hellojpa.domain.Order;
import hellojpa.domain.OrderItem;
import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        // DB와 연결할 준비
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // DB와 연결 후 팩토리를 운영하는 API
        EntityManager em = emf.createEntityManager();
        // DB 연결 시작 - JDBC connection
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 주문을 한다.
            Order order = new Order();
            order.addOrderItem(new OrderItem());

            // DB에 데이터 커밋
            tx.commit();
        } catch(Exception e) {
            // DB에 문제가 생기면 ROLLBACK으로 데이터 전부 다 리셋시킨다.
            tx.rollback();

        } finally {
            // DB 연결 종료
            em.close();
        }
        // JPA 컨테이너 종료
        emf.close();

    }
}
