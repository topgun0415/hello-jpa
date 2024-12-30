package hellojpa;

import hellojpa.domain.Member;
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








            // GETTER 비영속상태 (Non-persistence)
            /*
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.getId() : " + findMember.getId());
            System.out.println("findMember.getName() : " + findMember.getName());

            List<Member> memberList = em.createQuery("Select m from Member m", Member.class).getResultList();

            for(Member member : memberList) {
                System.out.println("memberList Start");
                System.out.println(member.getId() + member.getName());
            }
            */

            // 영속성
            /*
            JPA 컨테이너의 영속 컨테스트와 DB 사이에는 어떠한 레이어가 존재함.
            이는 캐싱 혹은 버퍼 같은 데이터들을 자바로 데이터베이스에 넣기쉽게 컨트롤이 가능함.
             */

            // 비영속성
            //em.persist(findMember);
            //em.detach(findMember);

            // SETTER
            //findMember.setName("ChangedName");

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
