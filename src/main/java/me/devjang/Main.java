package me.devjang;

import me.devjang.smartd.entity.Board;
import me.devjang.smartd.entity.Group;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Group group = new Group();
            group.setId(1);
            group.setName("1st group");
            em.persist(group);

            // 이건 주석입니다.
            Board board = new Board();
            board.setGroup(group);
            board.setBoardId(2);
            board.setName("좋은 장소");
            em.persist(board);

            tx.commit();

        } catch (Exception e) {
            System.out.println("oops! 에러 발생 - " + e.getMessage());
            tx.rollback();
        }
        em.close();
        emf.close();
    }
}