package pl.edu.agh.to2.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.LinkedList;
import java.util.List;

public class DataBase {
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    static{
        factory = Persistence.createEntityManagerFactory("default");
        entityManager = factory.createEntityManager();
    }

    private DataBase() { }

    public static void close(){
        entityManager.close();
        factory.close();
    }

    public static boolean save(Domain domain){
        try {
            EntityTransaction txn = entityManager.getTransaction();
            txn.begin();
            entityManager.persist(domain);
            txn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean save(Article article, Domain domain) {
        try {
            EntityTransaction txn = entityManager.getTransaction();
            txn.begin();
            entityManager.persist(article);
            domain.addArticle(article);
            txn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
