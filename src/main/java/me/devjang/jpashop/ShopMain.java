package me.devjang.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class ShopMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Member member1 = new Member();
            member1.setName("guest1");
            em.persist(member1);

            Order order1 = new Order();
            order1.setMember(member1);
            order1.setOrderNo("2000-1923-12039120");
            order1.setOrderedAt(LocalDateTime.now());
            em.persist(order1);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }

        em.close();
        emf.close();

    }
}
